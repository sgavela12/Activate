package com.example.activate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.activate.models.Usuario;
import com.example.activate.service.ActivateService;
import com.example.activate.service.UsuarioDBServiceImpl;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/activate")
public class MainController {

    @Autowired
    ActivateService activateService;

    @Autowired
    UsuarioDBServiceImpl usuarioDBServiceImpl;

    @GetMapping("/inicio")
    public String showHome(Model model) {
        model.addAttribute("navActual", "inicio");
        return "views/index";
    }

    @GetMapping("/perfil")
    public String showProfile(Model model) {
        model.addAttribute("navActual", "perfil");

        return "views/perfil";
    }

    @GetMapping("/servicios")
    public String showServices(Model model) {
        model.addAttribute("navActual", "servicios");
        return "views/servicios";
    }

    @GetMapping("/contacto")
    public String showContact(Model model) {
        model.addAttribute("navActual", "contacto");
        return "views/contacto";
    }
    

    @GetMapping("/calcularKcal")
    public String showCalcularkcal(Model model){
        model.addAttribute("navActual", "perfil");

        return "views/calcularKcal";
    }

    @GetMapping("/iniciarSesion")
    public String showIniciarSesion(@RequestParam(required = false) String msg, Model model) {
        if (msg != null) {
        model.addAttribute("navActual", "iniciarSesion");

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

    @GetMapping("/entrenadores")
    public String showEntrenadores(Model model) {
        model.addAttribute("navActual", "perfil");

        model.addAttribute("entrenadores", activateService.devuelveEntrenadores());
        return "views/entrenadores";
    }

    @GetMapping("/registrarse")
    public String showRegistrarse(@RequestParam(required = false) String msg, Model model) {
        if (msg != null) {
            model.addAttribute("mensajeCreacion", "Usuario creado correctamente.");
        }
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("navActual", "inciarSesion");

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

    @GetMapping("/error")
    public String showError() {

        return "views/error";
    }


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



    


