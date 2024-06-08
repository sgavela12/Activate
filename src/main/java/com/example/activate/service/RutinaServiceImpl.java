package com.example.activate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.activate.models.Rutina;
import com.example.activate.repositories.RutinaRepository;

@Service
public class RutinaServiceImpl implements RutinaService{
    
    @Autowired
    RutinaRepository RutinaRepository;

    public Rutina añadir(Rutina rutina) {
        return RutinaRepository.save(rutina);
    }

    public List<Rutina> obtenerTodos() {
        return RutinaRepository.findAll();
    }

    public Rutina obtenerPorId(long id) {
        return RutinaRepository.findById(id).orElse(null);
    }

    public Rutina editar(Rutina rutina) {
        return RutinaRepository.save(rutina);
    }

    public void borrar(Long id) {
        RutinaRepository.deleteById(id);
    }
}
