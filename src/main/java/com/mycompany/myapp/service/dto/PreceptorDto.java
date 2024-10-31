package com.mycompany.myapp.service.dto;

import java.util.List;
import java.util.Objects;

public class PreceptorDto {

    private String dni;
    private String nombre;
    private String apellido;
    private String email;

    private List<String> alumnosDni; // Lista de DNI de los alumnos asignados a este preceptor

    // Constructores

    public PreceptorDto() {}

    public PreceptorDto(String dni, String nombre, String apellido, String email, List<String> alumnosDni) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.alumnosDni = alumnosDni;
    }

    // Getters y Setters
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

    public List<String> getAlumnosDni() {
        return alumnosDni;
    }

    public void setAlumnosDni(List<String> alumnosDni) {
        this.alumnosDni = alumnosDni;
    }

    // equals y hashCode (usando el campo dni para identificar de manera única)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PreceptorDto that = (PreceptorDto) o;
        return Objects.equals(dni, that.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni);
    }

    // toString
    @Override
    public String toString() {
        return (
            "PreceptorDTO{" +
            "dni='" +
            dni +
            '\'' +
            ", nombre='" +
            nombre +
            '\'' +
            ", apellido='" +
            apellido +
            '\'' +
            ", email='" +
            email +
            '\'' +
            ", alumnosDni=" +
            alumnosDni +
            '}'
        );
    }
}
