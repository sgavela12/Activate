package com.example.activate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.activate.models.Dieta;
import com.example.activate.models.Rutina;
import com.example.activate.models.Usuario;
import com.example.activate.service.DietaServiceImpl;
import com.example.activate.service.RutinaServiceImpl;
import com.example.activate.service.UsuarioDBServiceImpl;

@Controller
@RequestMapping("/activate")
public class PerfilController {

    

    @Autowired
    private UsuarioDBServiceImpl usuarioDBServiceImpl;

    @Autowired
    private RutinaServiceImpl rutinaServiceImpl;

    @Autowired
    private DietaServiceImpl dietaServiceImpl;


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
    
}
