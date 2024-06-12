package com.example.activate.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "contacto")
public class ContactoForm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "El nombre es obligatorio")
    private String nombre;

    @NotEmpty(message = "El asunto es obligatorio")
    private String asunto;

    @NotEmpty(message = "El mensaje es obligatorio")
    private String mensaje;

    @Email(message = "Debe ser un correo electrónico válido")
    private String email;
}
