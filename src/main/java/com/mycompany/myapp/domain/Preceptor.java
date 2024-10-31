package com.mycompany.myapp.domain;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "preceptor")
public class Preceptor {

    @Id
    @Column(name = "dni", nullable = false, length = 20)
    private String dni;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "apellido", nullable = false, length = 100)
    private String apellido;

    @Column(name = "email", length = 100)
    private String email;

    // Relación con Alumno (uno a muchos)
    @OneToMany(mappedBy = "preceptor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Alumno> alumnos;

    // Constructores, getters y setters

    public Preceptor() {}

    public Preceptor(String dni, String nombre, String apellido, String email) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }
}
