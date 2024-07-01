package com.example.Backend.servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Backend.modelos.Canje;
import com.example.Backend.repositorios.CanjeRepositorio;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CanjeServicio {

    private final CanjeRepositorio canjeRepositorio;

    public List<Canje> getAll() throws Exception{

        try {
            return canjeRepositorio.findAll();
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

    public Canje getCanjeById(Long id) throws Exception{

        return canjeRepositorio.findById(id).orElseThrow(() -> new Exception("Error"));

    }


    public Canje createCanje(Canje canjeToCreate) throws Exception{

        return canjeRepositorio.save(canjeToCreate);
    }
    

    public void deleteCanjeById(Long id) throws Exception{

        if (!canjeRepositorio.existsById(id)) {
            
            throw new Exception("Este canje no existe");
        }

        canjeRepositorio.deleteById(id);
    }

    public Canje updateCanje(Canje canjeDetails) throws Exception{

        Canje canjeToUpdate = canjeRepositorio.findById(canjeDetails.getId()).orElseThrow(
            () -> new Exception("Error"));

            canjeToUpdate.setNombre(canjeDetails.getNombre());
            canjeToUpdate.setDescripcion(canjeDetails.getDescripcion());
            canjeToUpdate.setPuntos(canjeDetails.getPuntos());

            return canjeRepositorio.save(canjeToUpdate);
    }
}
