package com.mycompany.myapp.service.dto;

import java.util.List;
import java.util.Objects;

public class MateriaDto {

    private Long id;
    private String nombre;

    private List<Long> horariosId; // Lista de IDs de horarios asociados a esta materia
    private List<Long> notasId; // Lista de IDs de notas asociadas a esta materia
    private List<Long> mesasExamenId; // Lista de IDs de mesas de examen asociadas a esta materia

    // Constructores

    public MateriaDto() {}

    public MateriaDto(Long id, String nombre, List<Long> horariosId, List<Long> notasId, List<Long> mesasExamenId) {
        this.id = id;
        this.nombre = nombre;
        this.horariosId = horariosId;
        this.notasId = notasId;
        this.mesasExamenId = mesasExamenId;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Long> getHorariosId() {
        return horariosId;
    }

    public void setHorariosId(List<Long> horariosId) {
        this.horariosId = horariosId;
    }

    public List<Long> getNotasId() {
        return notasId;
    }

    public void setNotasId(List<Long> notasId) {
        this.notasId = notasId;
    }

    public List<Long> getMesasExamenId() {
        return mesasExamenId;
    }

    public void setMesasExamenId(List<Long> mesasExamenId) {
        this.mesasExamenId = mesasExamenId;
    }

    // equals y hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MateriaDto that = (MateriaDto) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // toString
    @Override
    public String toString() {
        return (
            "MateriaDTO{" +
            "id=" +
            id +
            ", nombre='" +
            nombre +
            '\'' +
            ", horariosId=" +
            horariosId +
            ", notasId=" +
            notasId +
            ", mesasExamenId=" +
            mesasExamenId +
            '}'
        );
    }
}
