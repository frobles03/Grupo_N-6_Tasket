package com.example.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.backend.entidad.Usuario;
import com.example.backend.repositorio.usuariosRepositorio;

@SpringBootApplication
public class BackendApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

    @Autowired
    private usuariosRepositorio repositorio;

    @Override
    public void run(String... args) throws Exception {
        Usuario usuario1 = new Usuario("Fernando", "Robles", "f.robles03@ufromail.cl");
        repositorio.save(usuario1);
    }
} 