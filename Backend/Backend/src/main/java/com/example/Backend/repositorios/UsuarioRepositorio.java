package com.example.Backend.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Backend.modelos.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long>{
    
}
