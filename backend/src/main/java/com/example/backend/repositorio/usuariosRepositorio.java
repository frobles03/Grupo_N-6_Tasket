package com.example.backend.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.backend.entidad.Usuario;

@Repository
public interface usuariosRepositorio extends JpaRepository<Usuario, Long>{
    
}
