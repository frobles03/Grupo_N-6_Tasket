package com.example.backend.repositorio;

import com.example.backend.models.Usuario;

import lombok.Getter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
}
