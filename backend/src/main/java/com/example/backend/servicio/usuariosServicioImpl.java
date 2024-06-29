package com.example.backend.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.entidad.Usuario;
import com.example.backend.repositorio.usuariosRepositorio;

@Service
public class usuariosServicioImpl implements usuariosServicio  {

@Autowired
private usuariosRepositorio repositorio;

    // This method is supposed to return a list of all users
    // Currently, it returns null indicating it's not yet implemented
    @Override
    public List<Usuario> listarTodosLosUsuarios() {
        return repositorio.findAll();
    }

    // Additional methods and logic for user service can be implemented here

}