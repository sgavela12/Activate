package com.example.activate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.activate.models.Noticia;


public interface NoticiaRepository extends JpaRepository<Noticia, Long> {
    
}
