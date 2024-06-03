package com.example.activate.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.activate.models.Entrenador;
import com.example.activate.repositories.EntrenadorRepository;

@Controller
public class EntrenadorController {

      @Autowired
    private EntrenadorRepository entrenadorRepository;

    @GetMapping("activate/servicios/entrenadores")
    public String listarEntrenadores(Model model) {
        List<Entrenador> entrenadores = entrenadorRepository.findAll();
        model.addAttribute("entrenadores", entrenadores);
        return "views/entrenadores";
    }
}
