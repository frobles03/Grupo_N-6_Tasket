package com.example.Backend.modelos;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity

@Table(name = "usuarios")
public class Usuario {

    @Id
   @GeneratedValue(
      strategy = GenerationType.IDENTITY
   )
   private Long id;

   @Column(
      name = "nombre_completo",
      nullable = false,
      length = 50
   )
   private String nombreCompleto;

   @Column(
      name = "email",
      nullable = false,
      unique = true,
      length = 50
   )
   private String email;
   @Column(
      name = "contrasena",
      nullable = false,
      length = 50
   )
   private String contrasena;

   @Column(
      name = "genero",
      nullable = false
   )
   @Enumerated(EnumType.STRING)
   private Genero genero;

   @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
   private List<Canje> canjes;

   @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
   private List<Tarea> tareas;
    
}
