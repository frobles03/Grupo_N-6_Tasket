package com.example.Backend.servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Backend.modelos.Tarea;
import com.example.Backend.repositorios.TareaRepositorio;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TareaServicio {

    private final TareaRepositorio tareaRepositorio;

    public List<Tarea> getAll() throws Exception {
        try {
            return tareaRepositorio.findAll();
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

    public Tarea getTareaById(Long id) throws Exception {
        return tareaRepositorio.findById(id).orElseThrow(() -> new Exception("Tarea no encontrada"));
    }

    public Tarea createTarea(Tarea tareaToCreate) throws Exception {
        try {
            return tareaRepositorio.save(tareaToCreate);
        } catch (Exception e) {
            throw new Exception("Error al crear la tarea: " + e.getMessage());
        }
    }

    public void deleteTareaById(Long id) throws Exception {
        if (!tareaRepositorio.existsById(id)) {
            throw new Exception("Esta tarea no existe");
        }
        try {
            tareaRepositorio.deleteById(id);
        } catch (Exception e) {
            throw new Exception("Error al eliminar la tarea: " + e.getMessage());
        }
    }

    public Tarea updateTarea(Tarea tareaDetails) throws Exception {
        Tarea tareaToUpdate = tareaRepositorio.findById(tareaDetails.getId()).orElseThrow(
                () -> new Exception("Error: Tarea no encontrada"));

        tareaToUpdate.setNombre(tareaDetails.getNombre());
        tareaToUpdate.setDescripcion(tareaDetails.getDescripcion());
        tareaToUpdate.setPuntaje(tareaDetails.getPuntaje());

        try {
            return tareaRepositorio.save(tareaToUpdate);
        } catch (Exception e) {
            throw new Exception("Error al actualizar la tarea: " + e.getMessage());
        }
    }
}
