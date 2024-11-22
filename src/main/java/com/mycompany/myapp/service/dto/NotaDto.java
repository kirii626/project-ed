package com.mycompany.myapp.service.dto;

import java.time.LocalDate;
import java.util.Objects;

public class NotaDto {

    private Long id;
    private Double nota;
    private LocalDate fecha;

    private String alumnoId; // ID del alumno al que pertenece esta nota
    private Long materiaId; // ID de la materia a la que pertenece esta nota

    // Constructores

    public NotaDto() {}

    public NotaDto(Long id, Double nota, LocalDate fecha, String alumnoId, Long materiaId) {
        this.id = id;
        this.nota = nota;
        this.fecha = fecha;
        this.alumnoId = alumnoId;
        this.materiaId = materiaId;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getAlumnoId() {
        return alumnoId;
    }

    public void setAlumnoId(String alumnoId) {
        this.alumnoId = alumnoId;
    }

    public Long getMateriaId() {
        return materiaId;
    }

    public void setMateriaId(Long materiaId) {
        this.materiaId = materiaId;
    }

    // equals y hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NotaDto notaDTO = (NotaDto) o;
        return Objects.equals(id, notaDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // toString
    @Override
    public String toString() {
        return (
            "NotaDTO{" + "id=" + id + ", nota=" + nota + ", fecha=" + fecha + ", alumnoId=" + alumnoId + ", materiaId=" + materiaId + '}'
        );
    }
}
