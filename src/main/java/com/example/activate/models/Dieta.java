package com.example.activate.models;

import java.util.ArrayList;
import java.util.List;

import com.example.activate.models.enums.TipoAlimento;

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
public class Dieta {
    @Id
    @GeneratedValue
    private Long idDieta;
    @NotNull
    private int objetivo;
    @NotNull
    private int caloriasTotales;

    @NotNull
    private TipoAlimento tipoAlimento;

    @OneToMany
    private List<Alimento> alimentos = new ArrayList<>();

    public void generarDieta() {

    }

}
