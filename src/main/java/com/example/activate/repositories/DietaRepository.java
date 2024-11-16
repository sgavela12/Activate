package com.example.activate.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.activate.models.Alimento;
import com.example.activate.models.Dieta;

public interface DietaRepository extends JpaRepository<Dieta,Long>{
    @Query("SELECT a FROM Alimento a WHERE a.id IN " +
    "(SELECT da.alimento.id FROM DietaAlimento da WHERE da.dieta.id = :idDieta)")
    List<Alimento> findAlimentosByDietaId(@Param("idDieta") Long idDieta);
}
