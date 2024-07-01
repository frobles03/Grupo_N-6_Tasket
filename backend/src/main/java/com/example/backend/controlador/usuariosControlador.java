package com.example.backend.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.backend.models.Usuario;
import com.example.backend.servicio.usuariosServicio;
import com.example.backend.repositorio.UsuarioRepositorio; // Import the UsuarioRepositorio class

import java.util.Optional; // Import the Optional class
import java.util.List; // Import the List class

@Controller 
public class usuariosControlador {
    
    @Autowired
    private usuariosServicio servicio; // Create an instance of usuariosServicio
    
    @Autowired
    private UsuarioRepositorio usuarioRepositorio; // Instantiate the UsuarioRepositorio
    
    @CrossOrigin(origins = "http://localhost:5173")
    /*
    @GetMapping({"/usuarios","/"})  
    public String listaUsuarios(Model modelo){
        modelo.addAttribute("usuarios", servicio.listarTodosLosUsuarios()); // Use the servicio instance to call the method

        return "usuarios";
    }
    */
    @GetMapping("/usuarios")
    public ResponseEntity<List<Usuario>> listarTodosLosUsuarios() {
        List<Usuario> usuarios = usuarioRepositorio.findAll();
        if(usuarios.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuarios);
    }
}
