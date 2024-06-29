package com.example.backend.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.backend.servicio.usuariosServicio;

@Controller 
public class usuariosControlador {
    
    @Autowired
    private usuariosServicio servicio; // Create an instance of usuariosServicio
    
    @GetMapping({"/usuarios","/"})  
    public String listaUsuarios(Model modelo){
        modelo.addAttribute("usuarios", servicio.listarTodosLosUsuarios()); // Use the servicio instance to call the method

        return "usuarios";
    }
    
}