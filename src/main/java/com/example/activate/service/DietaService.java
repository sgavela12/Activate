package com.example.activate.service;

import java.util.List;

import com.example.activate.models.Dieta;
import com.example.activate.models.enums.TipoAlimento;

public interface DietaService {
    public Dieta añadir(Dieta alimento);

    public List<Dieta> obtenerTodos();

    public Dieta obtenerPorId(long id);

    public Dieta editar(Dieta dieta);

    public void borrar(Long id);

    public Dieta calculaDieta(double kcal, TipoAlimento tipoDieta);
}
