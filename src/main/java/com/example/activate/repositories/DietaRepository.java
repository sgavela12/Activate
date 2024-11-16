package com.example.activate.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.activate.models.Dieta;
import com.example.activate.models.dtos.AlimentoDietaDto;

public interface DietaRepository extends JpaRepository<Dieta,Long>{
    @Query("SELECT new com.example.activate.models.dtos.AlimentoDietaDto(da.dia, da.comida, a.nombre, da.cantidad) " +
           "FROM DietaAlimento da " +
           "JOIN da.alimento a " +
           "WHERE da.dieta.id = :idDieta " +
           "ORDER BY da.dia, da.comida")
    List<AlimentoDietaDto> findAlimentosByDietaId(@Param("idDieta") Long idDieta);
}