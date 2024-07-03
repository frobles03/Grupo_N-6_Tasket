package com.example.Backend.repositorios;

import com.example.Backend.modelos.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TareaRepositorio extends JpaRepository<Tarea, Long> {
}
