package com.example.activate.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.activate.models.Alimento;
import com.example.activate.models.Dieta;
import com.example.activate.models.Rutina;
import com.example.activate.repositories.DietaRepository;
import com.example.activate.repositories.RutinaRepository;

@Controller
public class ServiciosController {

    @Autowired
    private DietaRepository dietaRepository;

    @Autowired
    private RutinaRepository rutinaRepository;

    @GetMapping("activate/servicios/dietas")
    public String mostrarDietas(Model model) {
        List<Dieta> dietas = dietaRepository.findAll();
        model.addAttribute("dietas", dietas);
        return "/views/dietas";
    }


    @GetMapping("/activate/servicios/rutinas")
    public String mostrarRutinas(Model model) {
        List<Rutina> rutinas = rutinaRepository.findAll();
        model.addAttribute("rutinas", rutinas);
        return "/views/rutinas";
    }

    
}
