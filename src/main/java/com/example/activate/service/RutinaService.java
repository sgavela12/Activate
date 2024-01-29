package com.example.activate.service;

import java.util.List;

import com.example.activate.models.Rutina;

public interface RutinaService {
    public Rutina añadir(Rutina rutina);

    public List<Rutina> obtenerTodos();

    public Rutina obtenerPorId(long id);

    public Rutina editar(Rutina rutina);

    public void borrar(Long id);
}
