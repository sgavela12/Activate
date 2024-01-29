package com.example.activate.service;

import java.util.List;

import com.example.activate.models.Dieta;

public interface DietaService {
    public Dieta añadir(Dieta alimento);

    public List<Dieta> obtenerTodos();

    public Dieta obtenerPorId(long id);

    public Dieta editar(Dieta dieta);

    public void borrar(Long id);
}
