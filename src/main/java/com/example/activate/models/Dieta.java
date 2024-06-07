package com.example.activate.models;

import java.util.Set;

import com.example.activate.models.enums.TipoAlimento;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Dieta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    private int caloriasTotales;
    
    private String rutaImagen;

    @Enumerated(EnumType.STRING)
    private TipoAlimento tipoAlimento;

    private String descripcion;

    @ManyToMany
    @JoinTable(
            name = "dieta_alimento",
            joinColumns = @JoinColumn(name = "id_dieta"),
            inverseJoinColumns = @JoinColumn(name = "id_alimento")
    )
    private Set<Alimento> alimentos;

}
