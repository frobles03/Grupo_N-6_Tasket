package com.example.Backend.controladores;

import com.example.Backend.modelos.Tarea;
import com.example.Backend.repositorios.TareaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tareas")
public class TareaControlador {

    @Autowired
    private TareaRepositorio TareaRepositorio;

    @GetMapping
    public List<Tarea> getAllTareas() {
        return TareaRepositorio.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarea> getTareaById(@PathVariable Long id) {
        Optional<Tarea> tarea = TareaRepositorio.findById(id);
        return tarea.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Tarea createTarea(@RequestBody Tarea tarea) {
        return TareaRepositorio.save(tarea);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarea> updateTarea(@PathVariable Long id, @RequestBody Tarea tareaDetails) {
        Optional<Tarea> tarea = TareaRepositorio.findById(id);
        if (tarea.isPresent()) {
            Tarea tareaToUpdate = tarea.get();
            tareaToUpdate.setNombre(tareaDetails.getNombre());
            tareaToUpdate.setDescripcion(tareaDetails.getDescripcion());
            tareaToUpdate.setPuntaje(tareaDetails.getPuntaje());
            tareaToUpdate.setUsuario(tareaDetails.getUsuario());
            final Tarea updatedTarea = TareaRepositorio.save(tareaToUpdate);
            return ResponseEntity.ok(updatedTarea);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTarea(@PathVariable Long id) {
        Optional<Tarea> tarea = TareaRepositorio.findById(id);
        if (tarea.isPresent()) {
            TareaRepositorio.delete(tarea.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
