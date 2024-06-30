package com.example.backend.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.backend.models.Canje;

public interface CanjeRepositorio extends JpaRepository<Canje, Long>{
    
}
