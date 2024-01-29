package com.example.activate.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Ejercicio {
    @Id
    @GeneratedValue
    private Long idEjercicio;
    @NotNull
    private String nombre;
    @NotNull
    private int dificultad;

    @ManyToOne
    private Rutina rutina;

    // public ArrayList<Ejercicio> listarEjercicios(){

    // }

    // public Ejercicio obtenerEjercicioPorId(id){}

}
