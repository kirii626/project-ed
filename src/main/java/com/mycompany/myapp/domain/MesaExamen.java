package com.mycompany.myapp.domain;

import jakarta.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "mesas_examen")
public class MesaExamen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "materia_id", nullable = false)
    private Materia materia;

    @ManyToOne
    @JoinColumn(name = "profesor_dni", nullable = false)
    private Profesor profesor;

    @ManyToMany
    @JoinTable(
        name = "alumno_mesas_examen",
        joinColumns = @JoinColumn(name = "mesa_examen_id"),
        inverseJoinColumns = @JoinColumn(name = "alumno_dni")
    )
    private Set<Alumno> alumnos = new HashSet<>();

    // Constructor vacío
    public MesaExamen() {}

    // Constructor con parámetros
    public MesaExamen(Date fecha, Materia materia, Profesor profesor) {
        this.fecha = fecha;
        this.materia = materia;
        this.profesor = profesor;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public Set<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(Set<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    // Métodos para añadir y remover alumnos de la mesa de examen
    public void addAlumno(Alumno alumno) {
        alumnos.add(alumno);
        alumno.getMesasExamen().add(this);
    }

    public void removeAlumno(Alumno alumno) {
        alumnos.remove(alumno);
        alumno.getMesasExamen().remove(this);
    }

    // Metodo equals y hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MesaExamen that = (MesaExamen) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // toString
    @Override
    public String toString() {
        return "MesaExamen{" + "id=" + id + ", fecha=" + fecha + ", materia=" + materia + ", profesor=" + profesor + '}';
    }
}
