package com.example.activate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.activate.models.Alimento;

public interface AlimentoRepository extends JpaRepository<Alimento,Long>{
}
