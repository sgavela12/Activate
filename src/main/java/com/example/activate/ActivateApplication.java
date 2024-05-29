package com.example.activate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class ActivateApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActivateApplication.class, args);
	}
	//   @Bean
    // public CommandLineRunner agregarUsuario(UsuarioService usuarioService) {
    //     return args -> {
    //         // Añadir un nuevo usuario al inicio de la aplicación
    //         usuarioService.añadir(new Usuario("admin", Rol.ADMIN, "1234",LocalDate.of(1990, Month.JANUARY, 1)));
    //     };
	
	// }
}
	