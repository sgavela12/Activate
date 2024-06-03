package com.example.activate.models;

import java.time.LocalDate;


import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
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

    private long id;

    @NotNull
    private String nombre;

    @NotNull
    private String apellidos;

    @Email
    @NotNull
    private String email;

    @Past
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private LocalDate fechaNacimiento;

    @NotNull
    private long telefono;

    @NotNull
    private String contraseña;


    // public ArrayList<Usuario> verClientesAsignados(){

    // }

    public void enviarMensajeCliente(Usuario usuario){

    }
    

    
}
