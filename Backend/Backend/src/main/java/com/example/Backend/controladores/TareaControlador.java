package com.example.Backend.controladores;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Backend.modelos.Tarea;
import com.example.Backend.servicios.TareaServicio;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin()
@RequestMapping("api/tareas")
@RequiredArgsConstructor
public class TareaControlador {

    private final TareaServicio tareaServicio;

    @GetMapping
    public ResponseEntity<?> getAllTareas() {
        try {
            return ResponseEntity.ok(tareaServicio.getAll());
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{tareaId}")
    public ResponseEntity<?> getTareaById(@PathVariable Long tareaId) {
        try {
            return ResponseEntity.ok(tareaServicio.getTareaById(tareaId));
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> createTarea(@RequestBody Tarea tareaToCreate) {
        try {
            return ResponseEntity.ok(tareaServicio.createTarea(tareaToCreate));
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{tareaId}")
    public ResponseEntity<?> deleteTareaById(@PathVariable Long tareaId) {
        try {
            tareaServicio.deleteTareaById(tareaId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{tareaId}")
    public ResponseEntity<?> updateTarea(@PathVariable Long tareaId, @RequestBody Tarea tareaToUpdate) {
        try {
            return ResponseEntity.ok(tareaServicio.updateTarea(tareaToUpdate));
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
