package com.mycompany.myapp.domain;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "materia")
public class Materia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @OneToMany(mappedBy = "materia", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Horario> horarios = new HashSet<>();

    @OneToMany(mappedBy = "materia", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Nota> notas = new HashSet<>();

    @OneToMany(mappedBy = "materia", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<MesaExamen> mesasExamen = new HashSet<>();

    // Constructor vacío
    public Materia() {}

    // Constructor con parámetros
    public Materia(String nombre) {
        this.nombre = nombre;
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

    public Set<Horario> getHorarios() {
        return horarios;
    }

    public void setHorarios(Set<Horario> horarios) {
        this.horarios = horarios;
    }

    public Set<Nota> getNotas() {
        return notas;
    }

    public void setNotas(Set<Nota> notas) {
        this.notas = notas;
    }

    public Set<MesaExamen> getMesasExamen() {
        return mesasExamen;
    }

    public void setMesasExamen(Set<MesaExamen> mesasExamen) {
        this.mesasExamen = mesasExamen;
    }

    // Métodos para manejar las relaciones bidireccionales

    public void addHorario(Horario horario) {
        horarios.add(horario);
        horario.setMateria(this);
    }

    public void removeHorario(Horario horario) {
        horarios.remove(horario);
        horario.setMateria(null);
    }

    public void addNota(Nota nota) {
        notas.add(nota);
        nota.setMateria(this);
    }

    public void removeNota(Nota nota) {
        notas.remove(nota);
        nota.setMateria(null);
    }

    public void addMesaExamen(MesaExamen mesaExamen) {
        mesasExamen.add(mesaExamen);
        mesaExamen.setMateria(this);
    }

    public void removeMesaExamen(MesaExamen mesaExamen) {
        mesasExamen.remove(mesaExamen);
        mesaExamen.setMateria(null);
    }

    // Método equals y hashCode para comparar objetos Materia
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Materia materia = (Materia) o;
        return Objects.equals(id, materia.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // toString
    @Override
    public String toString() {
        return "Materia{" + "id=" + id + ", nombre='" + nombre + '\'' + '}';
    }
}
