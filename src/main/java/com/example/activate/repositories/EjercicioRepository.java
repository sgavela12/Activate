package com.example.activate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.activate.models.Ejercicio;

public interface EjercicioRepository extends JpaRepository<Ejercicio,Long>{
    
}
