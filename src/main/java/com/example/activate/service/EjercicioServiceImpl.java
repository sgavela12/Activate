package com.example.activate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.activate.models.Ejercicio;
import com.example.activate.repositories.EjercicioRepository;

public class EjercicioServiceImpl implements EjercicioService{
    @Autowired
    EjercicioRepository ejercicioRepository;

    public Ejercicio añadir(Ejercicio ejercicio) {
        return ejercicioRepository.save(ejercicio);
    }

    public List<Ejercicio> obtenerTodos() {
        return ejercicioRepository.findAll();
    }

    public Ejercicio obtenerPorId(long id) {
        return ejercicioRepository.findById(id).orElse(null);
    }

    public Ejercicio editar(Ejercicio ejercicio) {
        return ejercicioRepository.save(ejercicio);
    }

    public void borrar(Long id) {
     ejercicioRepository.deleteById(id);
    }
}
