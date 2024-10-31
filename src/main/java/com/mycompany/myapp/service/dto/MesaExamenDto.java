package com.mycompany.myapp.service.dto;

import java.time.LocalDate;
import java.util.List;

public class MesaExamenDto {

    private Long id;
    private LocalDate fecha;

    // Relación con Materia (solo el ID o el nombre de la materia)
    private Long materiaId;
    private String materiaNombre;

    // Relación con Profesor (solo el DNI)
    private String profesorDni;

    // Relación con Alumnos (solo los DNIs)
    private List<String> alumnosDni;

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

    public Long getMateriaId() {
        return materiaId;
    }

    public void setMateriaId(Long materiaId) {
        this.materiaId = materiaId;
    }

    public String getMateriaNombre() {
        return materiaNombre;
    }

    public void setMateriaNombre(String materiaNombre) {
        this.materiaNombre = materiaNombre;
    }

    public String getProfesorDni() {
        return profesorDni;
    }

    public void setProfesorDni(String profesorDni) {
        this.profesorDni = profesorDni;
    }

    public List<String> getAlumnosDni() {
        return alumnosDni;
    }

    public void setAlumnosDni(List<String> alumnosDni) {
        this.alumnosDni = alumnosDni;
    }

    @Override
    public String toString() {
        return (
            "MesaExamenDTO{" +
            "id=" +
            id +
            ", fecha=" +
            fecha +
            ", materiaId=" +
            materiaId +
            ", materiaNombre='" +
            materiaNombre +
            '\'' +
            ", profesorDni='" +
            profesorDni +
            '\'' +
            ", alumnosDni=" +
            alumnosDni +
            '}'
        );
    }
}
