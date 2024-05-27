package com.example.activate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.example.activate.models.Usuario;
import com.example.activate.repositories.UsuarioRepository;

@Service
public class UsuarioDBServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario añadir(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public List<Usuario> obtenerTodos() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario obtenerPorId(long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public Usuario editar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public void borrar(Long id) {
        usuarioRepository.deleteById(id);
    }
}
