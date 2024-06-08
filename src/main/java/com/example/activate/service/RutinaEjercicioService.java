package com.example.activate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.example.activate.models.RutinaEjercicio;
import com.example.activate.repositories.RutinaEjercicioRepository;

@Service
public class RutinaEjercicioService {

    @Autowired
    private RutinaEjercicioRepository rutinaEjercicioRepository;

    public List<RutinaEjercicio> getRutinaEjerciciosByRutinaId(Long rutinaId) {
        return rutinaEjercicioRepository.findByRutinaId(rutinaId);
    }
}