package com.mycompany.myapp.service.dto;

import java.time.LocalDate;
import java.util.Objects;

public class NotaDto {

    private Long id;
    private Double valor;
    private LocalDate fecha;

    private String alumnoId; // ID del alumno al que pertenece esta valor
    private Long materiaId; // ID de la materia a la que pertenece esta valor

    // Constructores

    public NotaDto() {}

    public NotaDto(Long id, Double valor, LocalDate fecha, String alumnoId, Long materiaId) {
        this.id = id;
        this.valor = valor;
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

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
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
            "NotaDTO{" + "id=" + id + ", valor=" + valor + ", fecha=" + fecha + ", alumnoId=" + alumnoId + ", materiaId=" + materiaId + '}'
        );
    }
}
