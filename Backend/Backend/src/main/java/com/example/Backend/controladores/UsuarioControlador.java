package com.example.Backend.controladores;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Backend.servicios.UsuarioServicio;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin()

@RequestMapping("api/usuarios")

@RequiredArgsConstructor
public class UsuarioControlador {

    private final UsuarioServicio usuarioServicio;
    
    @GetMapping
    public ResponseEntity<?> listarTodosLosUsuarios() throws Exception{

        try {
            return ResponseEntity.ok(usuarioServicio.listarTodosLosUsuarios());
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
