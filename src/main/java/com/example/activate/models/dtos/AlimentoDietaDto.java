package com.example.activate.models.dtos;


import com.example.activate.models.enums.Comida;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AlimentoDietaDto {
    private int dia;
    private Comida comida;
    private String nombreAlimento;
    private int cantidad;
}
