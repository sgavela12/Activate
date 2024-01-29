package com.example.activate.models;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(of = "id")
public class Usuario {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String nombreCompleto;

    @Pattern(regexp="(^$|[0-9]{9})")
    @NotNull
    private String telefono;

    @Email
    @NotNull
    private String email;

    @Past
   @DateTimeFormat(pattern = "dd-MM-yyyy")
    @NotNull
    private LocalDate fechaNacimiento;

    @NotNull
    private String contraseña;

    @OneToOne
    private Dieta dieta;

    @Override
    public String toString() {
        return "Usuario [nombre=" + nombreCompleto +  ", email=" + email + ", fechaNacimiento="
                + fechaNacimiento + ", contraseña=" + contraseña + "]";
    }

}
