package com.example.activate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.activate.models.Usuario;
import com.example.activate.repositories.UsuarioRepository;

@Service
public class UsuarioDBServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Usuario añadir(Usuario usuario) {

        if (usuarioRepository.findByEmail(usuario.getEmail()) != null)
            return null; // ya existe ese nombre de usuario
        String passCrypted = passwordEncoder.encode(usuario.getContraseña());
        usuario.setContraseña(passCrypted);
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
