package com.example.activate.service;

import java.util.List;

import com.example.activate.models.Usuario;

public interface UsuarioService {
    public Usuario añadir(Usuario usuario);

    public Usuario añadirAdmin(Usuario usuario);

    public List<Usuario> obtenerTodos();

    public Usuario obtenerPorId(long id);

    public Usuario editar(Usuario usuario);

    public void borrar(Long id);

    public Usuario obtenerPorEmail(String email);


}
