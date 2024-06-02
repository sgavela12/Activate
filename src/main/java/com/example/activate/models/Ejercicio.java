package com.example.activate.models;

import com.example.activate.models.enums.TipoEjercicio;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEjercicio;

    @NotNull
    private String nombre;

    @NotNull
    private int dificultad;

    @NotNull
    @Enumerated(EnumType.STRING)
    private TipoEjercicio tipoEjercicio;
}
