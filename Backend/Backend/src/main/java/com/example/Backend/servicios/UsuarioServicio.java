package com.example.Backend.servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Backend.modelos.Usuario;
import com.example.Backend.repositorios.UsuarioRepositorio;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioServicio {
    
    private final UsuarioRepositorio usuarioRepositorio;

    public List<Usuario> listarTodosLosUsuarios() throws Exception{

        try {
            return usuarioRepositorio.findAll();
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }
}
