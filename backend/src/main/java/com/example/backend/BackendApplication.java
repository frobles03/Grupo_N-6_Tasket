package com.example.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.backend.models.Usuario;
import com.example.backend.repositorio.UsuarioRepositorio; // Corrected the import statement

@SpringBootApplication
public class BackendApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

    @Autowired
    private UsuarioRepositorio repositorio; // Corrected the field type to match the corrected import

    @Override
    public void run(String... args) throws Exception {
   
    }
}
