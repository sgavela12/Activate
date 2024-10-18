package com.example.activate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.activate.models.Alimento;
import com.example.activate.models.Noticia;
import com.example.activate.repositories.NoticiaRepository;

public class NoticiasServiceImpl {

    @Autowired
    NoticiaRepository noticiaRepository;

    public Noticia añadir(Noticia noticia) {
        return noticiaRepository.save(noticia);
        
    }

    public List<Noticia> obtenerTodos() {
        return noticiaRepository.findAll();
    }

    public Noticia obtenerPorId(long id) {
        return noticiaRepository.findById(id).orElse(null);
    }

    public Noticia editar(Noticia noticia) {
        return noticiaRepository.save(noticia);
    }

    public void borrar(Long id) {
        noticiaRepository.deleteById(id);
    }
    
}
