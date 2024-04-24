package com.example.activate.models;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class CalculoCaloriasForm{
    private String sexo;
    private int edad;
    private double peso;
    private double altura;
    private String nivelActividad;
}
