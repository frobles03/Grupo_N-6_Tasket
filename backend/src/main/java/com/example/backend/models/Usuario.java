package com.example.backend.models;
import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_completo", nullable = false, length = 50)
    private String nombreCompleto;

    @Column(name = "email", nullable = false, unique = true, length = 50)
    private String email;

    @Column(name = "contrasena", nullable = false, length = 50)
    private String contrasena;

    @Column(name = "genero", nullable = false)
    @Enumerated(EnumType.STRING)
    private Genero genero;

    public Usuario() {
    }

    public Usuario(String nombreCompleto, String email, String contrasena, Genero genero) {
        this.nombreCompleto = nombreCompleto;
        this.email = email;
        this.contrasena = contrasena;
        this.genero = genero;
    }

    // Constructor completo, incluyendo id, útil para la recuperación de datos.
    public Usuario(Long id, String nombreCompleto, String email, String contrasena, Genero genero) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.email = email;
        this.contrasena = contrasena;
        this.genero = genero;
    }

    // Getters y setters para cada campo, permitiendo la manipulación y acceso a los datos de la entidad.
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }
    
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    // Enumeración para los posibles géneros de los usuarios.
    public enum Genero {
        HOMBRE, MUJER, OTROS
    }
}