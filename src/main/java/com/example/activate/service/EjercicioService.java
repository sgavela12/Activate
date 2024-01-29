package com.example.activate.service;

import java.util.List;

import com.example.activate.models.Ejercicio;

public interface EjercicioService {
    public Ejercicio añadir(Ejercicio ejercicio);

    public List<Ejercicio> obtenerTodos();

    public Ejercicio obtenerPorId(long id);

    public Ejercicio editar(Ejercicio ejercicio);

    public void borrar(Long id);
}
