package com.example.activate.models;

import com.example.activate.models.enums.Comida;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "dieta_alimento")
public class DietaAlimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Identificador único para evitar conflictos de duplicados

    @ManyToOne
    @JoinColumn(name = "id_dieta", nullable = false)
    private Dieta dieta;

    @ManyToOne
    @JoinColumn(name = "id_alimento", nullable = false)
    private Alimento alimento;

    private int dia;

    @Enumerated(EnumType.STRING)
    private Comida comida;

    private int cantidad;
}
