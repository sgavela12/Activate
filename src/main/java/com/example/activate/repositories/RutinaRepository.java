package com.example.activate.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.activate.models.Ejercicio;
import com.example.activate.models.Rutina;

public interface RutinaRepository extends JpaRepository<Rutina,Long>{
      @Query("SELECT e FROM Ejercicio e JOIN e.rutinas r WHERE r.idRutina = :idRutina")
    List<Ejercicio> findEjerciciosByRutinaId(@Param("idRutina") Long idRutina);
}
