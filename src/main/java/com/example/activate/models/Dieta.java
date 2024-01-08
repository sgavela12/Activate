package com.example.activate.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Dieta {
    @Id
    @GeneratedValue
    private Long idDieta;
    @NotNull
    private int objetivo;
    @NotNull
    private int caloriasTotales;

    public void generarDieta() {

    }

}
