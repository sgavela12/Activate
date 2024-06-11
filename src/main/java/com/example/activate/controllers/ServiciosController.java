package com.example.activate.controllers;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.activate.models.Dieta;
import com.example.activate.models.Ejercicio;
import com.example.activate.models.Rutina;
import com.example.activate.models.RutinaEjercicio;
import com.example.activate.repositories.DietaRepository;
import com.example.activate.repositories.EjercicioRepository;
import com.example.activate.repositories.RutinaRepository;
import com.example.activate.service.RutinaEjercicioService;


@Controller
public class ServiciosController {

    @Autowired
    private RutinaRepository rutinaRepository;

    @Autowired
    private DietaRepository dietaRepository;

    @Autowired
    private RutinaEjercicioService rutinaEjercicioService;

    @Autowired
    private EjercicioRepository ejercicioRepository;


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

    @GetMapping("/activate/servicios/rutinas/{idRutina}")
    public String mostrarDetalleRutina(@PathVariable Long idRutina, Model model) {
       Rutina rutina = rutinaRepository.findById(idRutina)
            .orElseThrow(() -> new IllegalArgumentException("Rutina no encontrada: " + idRutina));
    List<Ejercicio> ejercicios = rutinaRepository.findEjerciciosByRutinaId(idRutina);
    List<RutinaEjercicio> rutinaEjercicio = rutinaEjercicioService.getRutinaEjerciciosByRutinaId(idRutina);

    // Obtener la lista de días únicos
    Set<String> dias = rutinaEjercicio.stream()
        .map(RutinaEjercicio::getDia)
        .collect(Collectors.toCollection(LinkedHashSet::new)); // LinkedHashSet para mantener el orden

    model.addAttribute("rutinaEjercicio", rutinaEjercicio);
    model.addAttribute("rutina", rutina);
    model.addAttribute("ejercicios", ejercicios);
    model.addAttribute("dias", dias);
    return "/views/rutinaDetalles";
    }

    @GetMapping("/activate/servicios/ejercicio/{idEjercicio}")
public String mostrarDetalleEjercicio(@PathVariable Long idEjercicio, Model model) {
    Ejercicio ejercicio = ejercicioRepository.findById(idEjercicio)
        .orElseThrow(() -> new IllegalArgumentException("Ejercicio no encontrado: " + idEjercicio));
    model.addAttribute("ejercicio", ejercicio);
    return "views/ejercicioDetalles";
}
}
