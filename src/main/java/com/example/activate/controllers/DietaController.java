package com.example.activate.controllers;

import com.example.activate.models.Dieta;
import com.example.activate.repositories.DietaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DietaController {

    @Autowired
    private DietaRepository dietaRepository;

    @GetMapping("activate/servicios/dietas")
    public String mostrarDietas(Model model) {
        List<Dieta> dietas = dietaRepository.findAll();
        model.addAttribute("dietas", dietas);
        return "/views/dietas";
    }
}
