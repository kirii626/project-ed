package com.mycompany.myapp.service.dto;

import java.util.List;
import java.util.Objects;

public class ProfesorDto {

    private String dni;
    private String nombre;
    private String apellido;
    private String email;

    private List<Long> horariosIds; // IDs de los horarios en los que enseña
    private List<Long> mesasExamenIds; // IDs de las mesas de examen donde participa

    // Constructores

    public ProfesorDto() {}

    public ProfesorDto(String dni, String nombre, String apellido, String email, List<Long> horariosIds, List<Long> mesasExamenIds) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.horariosIds = horariosIds;
        this.mesasExamenIds = mesasExamenIds;
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

    public List<Long> getHorariosIds() {
        return horariosIds;
    }

    public void setHorariosIds(List<Long> horariosIds) {
        this.horariosIds = horariosIds;
    }

    public List<Long> getMesasExamenIds() {
        return mesasExamenIds;
    }

    public void setMesasExamenIds(List<Long> mesasExamenIds) {
        this.mesasExamenIds = mesasExamenIds;
    }

    // equals y hashCode (usando el campo dni para identificar de manera única)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProfesorDto that = (ProfesorDto) o;
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
            "ProfesorDTO{" +
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
            ", horariosIds=" +
            horariosIds +
            ", mesasExamenIds=" +
            mesasExamenIds +
            '}'
        );
    }
}
