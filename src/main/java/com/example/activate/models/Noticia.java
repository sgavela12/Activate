package com.example.activate.models;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Noticia {

    @Id
    private Long id;

    @NotNull
    private String titulo;

    @NotNull
    private String cuerpo;

    @NotNull
    private String rutaImagen;

    
}
