package com.example.activate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.activate.models.Dieta;
import com.example.activate.models.Rol;
import com.example.activate.models.Usuario;
import com.example.activate.repositories.UsuarioRepository;

@Service
public class UsuarioDBServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private DietaService dietaService;

    public Usuario añadir(Usuario usuario) {
        usuario.setRol(Rol.USUARIO);
        String passCrypted = passwordEncoder.encode(usuario.getContraseña());
        usuario.setContraseña(passCrypted);
        try {
            return usuarioRepository.save(usuario);

        } catch (DataIntegrityViolationException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Usuario añadirAdmin(Usuario usuario) {
        usuario.setRol(Rol.ADMIN);
        String passCrypted = passwordEncoder.encode(usuario.getContraseña());
        usuario.setContraseña(passCrypted);
        try {
            return usuarioRepository.save(usuario);

        } catch (DataIntegrityViolationException e) {
            e.printStackTrace();
            return null;
        }
    }



    public Usuario añadirDieta(Usuario usuario,Integer idDieta) {
        Dieta dieta = dietaService.obtenerPorId(idDieta);
        usuario.setDieta(dieta);
        try {
            return usuarioRepository.save(usuario);

        } catch (DataIntegrityViolationException e) {
            e.printStackTrace();
            return null;
        }
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
    public Usuario obtenerPorEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    public Usuario editar(Usuario usuario) {
        String passCrypted = passwordEncoder.encode(usuario.getContraseña());
        usuario.setContraseña(passCrypted);
        try { return usuarioRepository.save(usuario); }
        catch (DataIntegrityViolationException e) {e.printStackTrace(); return null;} }

    @Override
    public void borrar(Long id) {
        usuarioRepository.deleteById(id);
    }
}
