package com.example.backend.servicio;

import java.util.List;

import com.example.backend.models.Usuario;

public interface usuariosServicio {
  
    public List<Usuario> listarTodosLosUsuarios();
    /*  public List<usuarios> findAll();
    public usuarios findById(Long id);
    public usuarios save(usuarios usuario);
    public void delete(Long id); */
}