package com.example.activate.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
        @Bean
        public AuthenticationManager authenticationManager(
                        AuthenticationConfiguration authenticationConfiguration)
                        throws Exception {
                return authenticationConfiguration.getAuthenticationManager();
        }

        @Bean
        public PasswordEncoder passwordEncoder() {
                return new BCryptPasswordEncoder();
        }

   @Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.headers(headersConfigurer -> headersConfigurer.frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin));

    http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED));

    http.authorizeHttpRequests(auth -> auth
            .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
            .requestMatchers("/activate/servicios/**").permitAll()
            .requestMatchers("/activate/inicio").permitAll()
            .requestMatchers("/activate/iniciarSesion").permitAll()
            .requestMatchers("/activate/registrarse").permitAll()
            .requestMatchers("/activate/contacto").permitAll()
            .requestMatchers("/activate/perfil").hasAnyRole("USUARIO", "ADMIN")
            .requestMatchers("/activate/admin").hasAnyRole("ADMIN")
            .anyRequest().authenticated()
    );

    http.formLogin(formLogin -> formLogin
            .loginPage("/activate/iniciarSesion")
            .loginProcessingUrl("/login")
            .defaultSuccessUrl("/activate/perfil", true)
            .permitAll()
    );

    http.logout(logout -> logout
            .logoutSuccessUrl("/")
            .permitAll()
    );

    http.exceptionHandling(exceptions -> exceptions.accessDeniedPage("/sesion/error"));

    return http.build();
}

        
}