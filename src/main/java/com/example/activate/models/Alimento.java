package com.example.activate.models;

import java.util.Set;

import com.example.activate.models.enums.TipoAlimento;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Alimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private int calorias;
    private int proteinas;
    private int hidratos;
    private int grasas;

    @Enumerated(EnumType.STRING)
    private TipoAlimento tipoAlimento;

    @ManyToMany(mappedBy = "alimentos")
    private Set<Dieta> dietas;
}
