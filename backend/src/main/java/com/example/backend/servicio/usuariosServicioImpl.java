package com.example.backend.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.models.Usuario;
import com.example.backend.repositorio.UsuarioRepositorio;

@Service
public class usuariosServicioImpl implements usuariosServicio {

    @Autowired
    private UsuarioRepositorio repositorio;

    @Override
    public List<Usuario> listarTodosLosUsuarios() {
        return repositorio.findAll();
    }

    // Additional methods and logic for user service can be implemented here

}