package com.example.activate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.activate.models.Dieta;
import com.example.activate.models.Ejercicio;
import com.example.activate.models.Rutina;
import com.example.activate.models.Usuario;
import com.example.activate.models.dtos.CalculoDietaForm;
import com.example.activate.models.enums.TipoAlimento;
import com.example.activate.repositories.EjercicioRepository;
import com.example.activate.service.CalcularKcalServiceImpl;
import com.example.activate.service.DietaServiceImpl;
import com.example.activate.service.RutinaServiceImpl;
import com.example.activate.service.UsuarioDBServiceImpl;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/activate")
public class PerfilController {

    @Autowired
    private UsuarioDBServiceImpl usuarioDBServiceImpl;

    @Autowired
    private RutinaServiceImpl rutinaServiceImpl;

    @Autowired
    private DietaServiceImpl dietaServiceImpl;

    @Autowired
    private CalcularKcalServiceImpl calcularKcalService;

    

    

    @GetMapping("/perfil")
    public String showProfile(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();

        Usuario usuario = usuarioDBServiceImpl.obtenerPorEmail(currentUserName);

        if (usuario.getRutina() != null) {
            Rutina rutina = rutinaServiceImpl.obtenerPorId(usuario.getRutina().getIdRutina());
            model.addAttribute("rutina", rutina);
        }

        if (usuario.getDieta() != null) {
            Dieta dieta = dietaServiceImpl.obtenerPorId(usuario.getDieta().getId());
            model.addAttribute("dieta", dieta);
        }

        return "views/perfil";
    }



    @GetMapping("/nuevaDieta")
    public String showNuevaDieta(Model model) {
        model.addAttribute("calculoCalorias", new CalculoDietaForm());
        return "forms/nuevaDieta";
    }




    @PostMapping("/nuevaDieta/enviar")
    public String calcularKcal(@ModelAttribute("calculoCalorias") @Valid CalculoDietaForm calculoDietaForm,
            BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "forms/nuevaDieta";
        }

        // Validación de datos de entrada
        if (calculoDietaForm.getEdad() == 0 || calculoDietaForm.getPeso() == 0
                || calculoDietaForm.getAltura() == 0) {
            model.addAttribute("mensajeError", "Por favor, introduzca datos válidos para edad, peso y altura.");
            return "forms/nuevaDieta";
        }
        
        CalcularKcalServiceImpl.Sexo sexo = (calculoDietaForm.getSexo().equalsIgnoreCase("HOMBRE"))
                ? CalcularKcalServiceImpl.Sexo.HOMBRE
                : CalcularKcalServiceImpl.Sexo.MUJER;
        CalcularKcalServiceImpl.NivelActividad nivelActividad = CalcularKcalServiceImpl.NivelActividad
                .valueOf(calculoDietaForm.getNivelActividad());

        double calorias = calcularKcalService.calcularCalorias(sexo, calculoDietaForm.getEdad(),
                calculoDietaForm.getPeso(), calculoDietaForm.getAltura(), nivelActividad);


        
        TipoAlimento tipoDieta =  calcularKcalService.guardaTipoDieta(calculoDietaForm.getTipoDieta());


        Dieta dietaCorrecta = dietaServiceImpl.calculaDieta(calorias, tipoDieta);

        model.addAttribute("dieta", dietaCorrecta);
        
        model.addAttribute("calculoCaloriasResultado", String.format("%.2f", calorias));

        return "forms/nuevaDieta";
    }


    
 @PostMapping("/perfil/añadeDieta/{id}")
public String showRegistrarse(@PathVariable("id") int id) {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    String currentUserName = authentication.getName();

    Usuario usuario = usuarioDBServiceImpl.obtenerPorEmail(currentUserName);
    usuarioDBServiceImpl.añadirDieta(usuario, id);

    return "redirect:/activate/perfil";
}





}
