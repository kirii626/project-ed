package com.mycompany.myapp.domain;

import jakarta.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "faltas")
public class Falta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha;

    @Column(name = "justificada", nullable = false)
    private boolean justificada;

    @ManyToOne
    @JoinColumn(name = "alumno_dni", nullable = false)
    private Alumno alumno;

    // Constructor vacío
    public Falta() {}

    // Constructor con parámetros
    public Falta(Date fecha, boolean justificada, Alumno alumno) {
        this.fecha = fecha;
        this.justificada = justificada;
        this.alumno = alumno;
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

    public boolean isJustificada() {
        return justificada;
    }

    public void setJustificada(boolean justificada) {
        this.justificada = justificada;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    // Metodo equals y hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Falta falta = (Falta) o;
        return Objects.equals(id, falta.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // toString
    @Override
    public String toString() {
        return "Falta{" + "id=" + id + ", fecha=" + fecha + ", justificada=" + justificada + ", alumno=" + alumno + '}';
    }
}
