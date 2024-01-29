package com.example.activate.service;

import java.util.List;

import com.example.activate.models.Alimento;

public interface AlimentoService {
        public Alimento añadir(Alimento alimento);

    public List<Alimento> obtenerTodos();

    public Alimento obtenerPorId(long id);

    public Alimento editar(Alimento alimento);

    public void borrar(Long id);
}
