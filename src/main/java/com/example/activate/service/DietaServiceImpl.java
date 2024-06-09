package com.example.activate.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.activate.models.Dieta;
import com.example.activate.models.enums.TipoAlimento;
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


    public List<Dieta> obtenDietaPorTipoAlimento(TipoAlimento tipoDieta){
        List<Dieta> listaCorrectos = new ArrayList<>();
        List<Dieta> listaDietas = obtenerTodos();

        for (Dieta dieta : listaDietas) {
            if (dieta.getTipoAlimento() == tipoDieta) {
                listaCorrectos.add(dieta);
            }
        }
        return listaCorrectos;
    }




    public Dieta calculaDieta(double kcal, TipoAlimento tipoDieta) {
        // Obtener todas las dietas del tipo especificado
        List<Dieta> dietas = obtenDietaPorTipoAlimento(tipoDieta);
    
        // Si no hay dietas disponibles, devolver null o lanzar una excepción
        if (dietas.isEmpty()) {
            return null; // o lanzar una excepción
        }
    
        // Variable para almacenar la dieta más cercana a las calorías deseadas
        Dieta dietaCercana = null;
        double diferenciaMinima = Double.MAX_VALUE;
    
        // Buscar la dieta que más se acerque a las calorías deseadas
        for (Dieta dieta : dietas) {
            double diferencia = Math.abs(dieta.getCaloriasTotales() - kcal);
            if (diferencia < diferenciaMinima) {
                diferenciaMinima = diferencia;
                dietaCercana = dieta;
            }
        }
    
        // Devolver la dieta que más se acerque a las calorías deseadas
        return dietaCercana;
    }
}