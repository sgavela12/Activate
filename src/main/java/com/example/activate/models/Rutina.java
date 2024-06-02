package com.example.activate.models;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Rutina {
    @Id
    @GeneratedValue
    private Long idRutina;

    @NotNull
    private int duracion;

    @NotNull
    private int objetivo;

    @OneToMany
    private List<Ejercicio> ejercicios = new ArrayList<>();


    // public Rutina generarRutina(){}

}
