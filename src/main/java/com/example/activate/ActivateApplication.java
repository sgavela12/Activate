package com.example.activate;

import java.time.LocalDate;
import java.time.Month;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.activate.models.Rol;
import com.example.activate.models.Usuario;
import com.example.activate.service.UsuarioService;



@SpringBootApplication
public class ActivateApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActivateApplication.class, args);
	}
	// @Bean
    // public CommandLineRunner agregarUsuario(UsuarioService usuarioService, PasswordEncoder passwordEncoder) {
    //     return args -> {
    //         // Crear un usuario con todos los campos
    //         Usuario usuario = new Usuario();
    //         usuario.setRol(Rol.ADMIN);
    //         usuario.setNombreCompleto("Admin");
    //         usuario.setTelefono("123456789");
    //         usuario.setEmail("admin@admin");
    //         usuario.setFechaNacimiento(LocalDate.of(1990, Month.JANUARY, 1));
    //         usuario.setContraseña("1234"); // Aquí puedes definir la contraseña deseada
    //         // Puedes seguir configurando los demás campos según sea necesario

    //         usuarioService.añadir(usuario);
    //     };
	
	// }
}
	