package com.example.activate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.activate.models.Dieta;
import com.example.activate.repositories.DietaRepository;

@Service
public class DietaServiceImpl implements DietaService {

    @Autowired
    DietaRepository dietaRepository;

    public Dieta añadir(Dieta dieta) {
        return dietaRepository.save(dieta);
    }

    public List<Dieta> obtenerTodos() {
        return dietaRepository.findAll();
    }

    public Dieta obtenerPorId(long id) {
        return dietaRepository.findById(id).orElse(null);
    }

    public Dieta editar(Dieta dieta) {
        return dietaRepository.save(dieta);
    }

    public void borrar(Long id) {
        dietaRepository.deleteById(id);
    }
}
