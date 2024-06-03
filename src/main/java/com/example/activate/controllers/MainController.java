package com.example.activate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.activate.models.CalculoCaloriasForm;
import com.example.activate.models.Usuario;
import com.example.activate.service.ActivateService;
import com.example.activate.service.CalcularKcalServiceImpl;
import com.example.activate.service.UsuarioDBServiceImpl;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/activate")
public class MainController {

    @Autowired
    private ActivateService activateService;

    @Autowired
    private CalcularKcalServiceImpl calcularKcalService;

    @Autowired
    private UsuarioDBServiceImpl usuarioDBServiceImpl;

    @GetMapping("/inicio")
    public String showHome(Model model) {
        model.addAttribute("mensajeFecha", activateService.mensajeFecha());
        return "views/index";
    }

    @GetMapping("/perfil")
    public String showProfile(Model model) {
        return "views/perfil";
    }

    @GetMapping("/servicios")
    public String showServices() {
        return "views/servicios";
    }

    @GetMapping("/contacto")
    public String showContact() {
        return "views/contacto";
    }

    // Calculo de Calorías
    @GetMapping("servicios/calcularKcal")
    public String showCalcularkcal(Model model) {
        model.addAttribute("calculoCalorias", new CalculoCaloriasForm());
        return "forms/calcularKcal";
    }

    @PostMapping("servicios/calcularKcal")
    public String calcularKcal(@ModelAttribute("calculoCalorias") @Valid CalculoCaloriasForm calculoCaloriasForm,
                               BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "forms/calcularKcal";
        }

        CalcularKcalServiceImpl.Sexo sexo = (calculoCaloriasForm.getSexo().equalsIgnoreCase("HOMBRE")) 
            ? CalcularKcalServiceImpl.Sexo.HOMBRE : CalcularKcalServiceImpl.Sexo.MUJER;
        CalcularKcalServiceImpl.NivelActividad nivelActividad = CalcularKcalServiceImpl.NivelActividad.valueOf(calculoCaloriasForm.getNivelActividad());

        double calorias = calcularKcalService.calcularCalorias(sexo, calculoCaloriasForm.getEdad(), calculoCaloriasForm.getPeso(), calculoCaloriasForm.getAltura(), nivelActividad);
        model.addAttribute("calculoCaloriasResultado", calorias);

        return "forms/calcularKcal";
    }

    // Iniciar Sesión
    @GetMapping("/iniciarSesion")
    public String showIniciarSesion(@RequestParam(required = false) String msg, Model model) {
        if (msg != null) {
            model.addAttribute("mensajeCreacion", "Sesión iniciada correctamente.");
        }
        model.addAttribute("usuario", new Usuario());
        return "forms/registrarse";
    }

    @PostMapping("/iniciarSesion/enviar")
    public String showIniciarSesionEnviar(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "forms/registrarse";
        }
        usuarioDBServiceImpl.añadir(usuario);
        return "redirect:/activate/iniciarSesion?msg=okay";
    }

    // Registrarse
    @GetMapping("/registrarse")
    public String showRegistrarse(@RequestParam(required = false) String msg, Model model) {
        if (msg != null) {
            model.addAttribute("mensajeCreacion", "Usuario creado correctamente.");
        }
        model.addAttribute("usuario", new Usuario());
        return "forms/registrarse";
    }

    @PostMapping("/registrarse/enviar")
    public String showRegistrarseEnviar(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "forms/registrarse";
        }
        usuarioDBServiceImpl.añadir(usuario);
        return "redirect:/activate/registrarse?msg=okay";
    }

       // Cerrar Sesión
       @GetMapping("/cerrarSesion")
       public String showCerrarSesion() {
          
           return "forms/cerrarSesion";
       }




    @GetMapping("/servicios/rutinas")
    public String showRutinas() {
    
        return "views/rutinas";
    }

    // Error
    @GetMapping("/error")
    public String showError() {
        return "views/error";
    }


    @GetMapping("/check")
    public String checkUsers(Model model) {
        model.addAttribute("usuarios", usuarioDBServiceImpl.obtenerTodos());
        return "views/checkUsers";
    }
}
