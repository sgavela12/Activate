package com.example.activate.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.activate.models.RutinaEjercicio;

public interface RutinaEjercicioRepository extends JpaRepository<RutinaEjercicio, Long> {
    @Query("SELECT re FROM RutinaEjercicio re WHERE re.rutina.idRutina = :rutinaId")
    List<RutinaEjercicio> findByRutinaId(@Param("rutinaId") Long rutinaId);
}
