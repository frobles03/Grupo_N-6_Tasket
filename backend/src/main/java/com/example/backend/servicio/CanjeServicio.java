package com.example.backend.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.models.Canje;
import com.example.backend.repositorio.CanjeRepositorio;

@Service
public class CanjeServicio {

    @Autowired
    private CanjeRepositorio canjeRepositorio;

    public List<Canje> getAll() throws Exception{

        try {
            return canjeRepositorio.findAll();
        } catch (Exception e) {
           throw new Exception("Error: " + e.getMessage());
        }

    }

    public Canje GetCanjeById(Long Id) throws Exception{

        return canjeRepositorio.findById(Id).orElseThrow(() -> new Exception("Error")); 
    }

    public Canje createCanje(Canje canjeToCreate) throws Exception{

        return canjeRepositorio.save(canjeToCreate);

    }

    public void deleteCanjeById(Long Id) throws Exception{

        if (!canjeRepositorio.existsById(Id)) {
            
            throw new Exception("Este usuario no existe");
        }
        canjeRepositorio.deleteById(Id);
    }

    public Canje updateCanje(Canje canjeDetails) throws Exception{
        Canje canjeToUpdate = canjeRepositorio.findById(canjeDetails.getId()).orElseThrow(
            () -> new Exception("Error"));

            canjeToUpdate.setTitulo(canjeDetails.getTitulo());
            canjeToUpdate.setDescripcion(canjeDetails.getDescripcion());
            canjeToUpdate.setPuntos(canjeDetails.getPuntos());

            return canjeRepositorio.save(canjeToUpdate);
    }
    
}
