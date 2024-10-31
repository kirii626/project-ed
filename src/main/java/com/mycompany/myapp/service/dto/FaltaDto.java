package com.mycompany.myapp.service.dto;

import java.time.LocalDate;

public class FaltaDto {

    private Long id;
    private LocalDate fecha;
    private boolean justificada;

    // Relación con Alumno (solo el DNI del alumno)
    private String alumnoDni;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public boolean isJustificada() {
        return justificada;
    }

    public void setJustificada(boolean justificada) {
        this.justificada = justificada;
    }

    public String getAlumnoDni() {
        return alumnoDni;
    }

    public void setAlumnoDni(String alumnoDni) {
        this.alumnoDni = alumnoDni;
    }

    @Override
    public String toString() {
        return "FaltaDTO{" + "id=" + id + ", fecha=" + fecha + ", justificada=" + justificada + ", alumnoDni='" + alumnoDni + '\'' + '}';
    }
}
