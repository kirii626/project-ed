package com.mycompany.myapp.service.dto;

import java.time.LocalTime;

public class HorarioDto {

    private Long id;
    private String dia;
    private LocalTime horaInicio;
    private LocalTime horaFin;

    // Relación con Materia (solo el ID de la materia)
    private Long materiaId;

    // Relación con Profesor (solo el DNI del profesor)
    private String profesorDni;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

    public Long getMateriaId() {
        return materiaId;
    }

    public void setMateriaId(Long materiaId) {
        this.materiaId = materiaId;
    }

    public String getProfesorDni() {
        return profesorDni;
    }

    public void setProfesorDni(String profesorDni) {
        this.profesorDni = profesorDni;
    }

    @Override
    public String toString() {
        return (
            "HorarioDTO{" +
            "id=" +
            id +
            ", dia='" +
            dia +
            '\'' +
            ", horaInicio=" +
            horaInicio +
            ", horaFin=" +
            horaFin +
            ", materiaId=" +
            materiaId +
            ", profesorDni='" +
            profesorDni +
            '\'' +
            '}'
        );
    }
}
