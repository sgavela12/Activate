package com.example.activate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.activate.service.ContactoFormServiceImpl;
import com.example.activate.service.UsuarioDBServiceImpl;

@Controller
@RequestMapping("/activate")
public class AdminController {

    @Autowired
    UsuarioDBServiceImpl usuarioDBServiceImpl;
    @Autowired
    ContactoFormServiceImpl contactoFormServiceImpl;



    @GetMapping("/admin")
public String showProfile(Model model) {
    model.addAttribute("usuarios", usuarioDBServiceImpl.obtenerTodos());
    model.addAttribute("contactos", contactoFormServiceImpl.obtenerTodos()); 
    return "views/admin";
}





}
