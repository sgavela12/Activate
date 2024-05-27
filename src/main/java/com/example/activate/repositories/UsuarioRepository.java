package com.example.activate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.activate.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Long>{
    Usuario findByEmail(String email);
}
