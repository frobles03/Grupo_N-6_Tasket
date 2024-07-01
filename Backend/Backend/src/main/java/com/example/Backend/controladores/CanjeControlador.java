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

import com.example.Backend.modelos.Canje;
import com.example.Backend.servicios.CanjeServicio;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin()

@RequestMapping("api/canjes")

@RequiredArgsConstructor
public class CanjeControlador {

    private final CanjeServicio canjeServicio;


    @GetMapping
    public ResponseEntity<?> getAllCanjes() throws Exception{

        try {
            return ResponseEntity.ok(canjeServicio.getAll());
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{canjeId}")
    public ResponseEntity<?> getCanjeById(@PathVariable Long canjeId) throws Exception{

        try {
            return ResponseEntity.ok(canjeServicio.getCanjeById(canjeId));
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping
    public ResponseEntity<?> createCanje(@RequestBody Canje canjeToCreate) throws Exception{

        try {
            return ResponseEntity.ok(canjeServicio.createCanje(canjeToCreate));
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{canjeId}")
    public ResponseEntity<?> deleteUsuarioById(@PathVariable Long canjeId) throws Exception{

        try {
            canjeServicio.deleteCanjeById(canjeId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{canjeId}")
    public ResponseEntity<?> updateCanje(@PathVariable Long canjeId, @RequestBody Canje canjeToUpdate) throws Exception{

        try {
            return ResponseEntity.ok(canjeServicio.updateCanje(canjeToUpdate));
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    
}
