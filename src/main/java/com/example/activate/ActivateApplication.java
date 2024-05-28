package com.example.activate;

import java.time.LocalDate;
import java.time.Month;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.activate.models.Rol;
import com.example.activate.models.Usuario;
import com.example.activate.service.UsuarioService;

@SpringBootApplication
public class ActivateApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActivateApplication.class, args);
	}
	  @Bean
    public CommandLineRunner agregarUsuario(UsuarioService usuarioService) {
        return args -> {
            // Añadir un nuevo usuario al inicio de la aplicación
            usuarioService.añadir(new Usuario("admin", Rol.ADMIN, "1234",LocalDate.of(1990, Month.JANUARY, 1)));
        };
	
	}
}
	