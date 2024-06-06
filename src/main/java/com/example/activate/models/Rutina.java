package com.example.activate.models;

import com.example.activate.models.enums.TipoEjercicio;
import com.example.activate.models.enums.TipoObjetivo;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Rutina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRutina;

    @NotNull
    private String nombre;

    @NotNull
    private int duracion;

    private String rutaImagen;


    @NotNull
    @Enumerated(EnumType.STRING)
    private TipoObjetivo objetivo;

    @NotNull
    @Enumerated(EnumType.STRING)
    private TipoEjercicio tipoRutina;

    @ManyToMany
    @JoinTable(
        name = "rutina_ejercicio",
        joinColumns = @JoinColumn(name = "id_rutina"),
        inverseJoinColumns = @JoinColumn(name = "id_ejercicio")
    )
    private Set<Ejercicio> ejercicios;
}
