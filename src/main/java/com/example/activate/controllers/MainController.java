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
import com.example.activate.service.CalcularKcalService;
import com.example.activate.service.CalcularKcalServiceImpl;
import com.example.activate.service.UsuarioDBServiceImpl;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/activate")
public class MainController {

    @Autowired
    ActivateService activateService;

    @Autowired
    CalcularKcalService calcularKcalService;

    @Autowired
    UsuarioDBServiceImpl usuarioDBServiceImpl;

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
    
    // CALCULO DE CALORIAS

    @GetMapping("/calcularKcal")
    public String showCalcularkcal(Model model) {
        model.addAttribute("calculoCalorias", new CalculoCaloriasForm());
        return "forms/calcularKcal";
    }

    @PostMapping("/calcularKcal")
    public String calcularKcal(@ModelAttribute("calculoCalorias") @Valid CalculoCaloriasForm calculoCaloriasForm,
                               BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "forms/calcularKcal";
        }

        // Convertir el formulario a los tipos esperados por el servicio
        CalcularKcalServiceImpl.Sexo sexo = (calculoCaloriasForm.getSexo().equals("HOMBRE")) ? CalcularKcalServiceImpl.Sexo.HOMBRE : CalcularKcalServiceImpl.Sexo.MUJER;
        CalcularKcalServiceImpl.NivelActividad nivelActividad = CalcularKcalServiceImpl.NivelActividad.valueOf(calculoCaloriasForm.getNivelActividad());

        // Calcular las calorías
        double calorias = calcularKcalService.calcularKcal(sexo,
                calculoCaloriasForm.getEdad(), calculoCaloriasForm.getPeso(), calculoCaloriasForm.getAltura(),
                nivelActividad);

        // Agregar el resultado al modelo
        model.addAttribute("calculoCaloriasResultado", calorias);

        return "forms/calcularKcal";
    }



// INICIAR SESION
    @GetMapping("/iniciarSesion")
    public String showIniciarSesion(@RequestParam(required = false) String msg, Model model) {
        if (msg != null) {
            model.addAttribute("mensajeCreacion", "Sesión iniciada correctamente.");

        }
        //Hacer dto para coger email y contraseña del registro de datos y luego comprobar si estan 
        model.addAttribute("usuario", new Usuario());
        

        return "forms/registrarse";
    }

    @GetMapping("/iniciarSesion/enviar")
    public String showIniciarSesionEnviar(@Valid Usuario usuario, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors())
            return "redirect:/activate/error";
        usuarioDBServiceImpl.añadir(usuario);
        System.out.println((usuarioDBServiceImpl.obtenerTodos()));
        return "redirect:/activate/iniciarSesion?msg=okay";
    }



    // REGISTRARSE

    @GetMapping("/registrarse")
    public String showRegistrarse(@RequestParam(required = false) String msg, Model model) {
        if (msg != null) {
            model.addAttribute("mensajeCreacion", "Usuario creado correctamente.");
        }
        model.addAttribute("usuario", new Usuario());
        return "forms/registrarse";
    }

    @PostMapping("/registrarse/enviar")
    public String showRegistrarseEnviar(@Valid Usuario usuario, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors())
            return "redirect:/activate/error";
        usuarioDBServiceImpl.añadir(usuario);
        System.out.println((usuarioDBServiceImpl.obtenerTodos()));
        return "redirect:/activate/registrarse?msg=okay";
    }


    // ENTRENADORES 

    @GetMapping("/entrenadores")
    public String showEntrenadores(Model model) {
        model.addAttribute("entrenadores", activateService.devuelveEntrenadores());
        return "views/entrenadores";
    }

   
    // ERROR
    @GetMapping("/error")
    public String showError() {

        return "views/error";
    }

    // NUEVOENTRENADOR
    @GetMapping("/nuevoEntrenador")
    public String showFormEntrenadores() {
        
        return "views/inciarSesion";
    }


    @GetMapping("/check")
    public String checkUsers(Model model) {
        model.addAttribute("usuarios", usuarioDBServiceImpl.obtenerTodos());
        return "views/checkUsers.html";
    }

}
    




    


