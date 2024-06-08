package com.example.activate.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Entrenador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellidos;
    private String email;
    private String fechaNacimiento; // O `LocalDate` si estás utilizando tipos de fecha
    private String telefono;
    private String especialidad;
    private String rutaImagen; // Nota: Usa camelCase para coincidir con el nombre en Thymeleaf
    private String descripcion;


    // public ArrayList<Usuario> verClientesAsignados(){

    // }

    public void enviarMensajeCliente(Usuario usuario){

    }
    

    
}
