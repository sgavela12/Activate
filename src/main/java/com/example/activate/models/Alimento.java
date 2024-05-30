package com.example.activate.models;

import com.example.activate.models.enums.TipoAlimento;

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
public class Alimento {
    @Id
    @GeneratedValue
    private Long idComida;
    
    @NotNull
    private String nombre;
    
    @NotNull
    private int calorias;

    @NotNull
    private int proteinas;

    @NotNull
    private int hidratos;

    @NotNull
    private int grasas;
    
    @NotNull
    private TipoAlimento tipoAlimento; 
}
