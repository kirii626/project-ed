package com.mycompany.myapp.domain;

import jakarta.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "alumno")
public class Alumno {

    @Id
    @Column(name = "dni", nullable = false, length = 20)
    private String dni;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "apellido", nullable = false, length = 100)
    private String apellido;

    @Column(name = "email", length = 100)
    private String email;

    // Relación con Preceptor (muchos a uno)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "preceptor_dni", nullable = false)
    private Preceptor preceptor;

    // Relación con Faltas (uno a muchos) con carga perezosa (lazy loading)
    @OneToMany(mappedBy = "alumno", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Falta> faltas;

    // Relación con Notas (uno a muchos) con carga perezosa (lazy loading)
    @OneToMany(mappedBy = "alumno", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Nota> notas;

    // Relación con Mesas de Examen (muchos a muchos)
    @ManyToMany
    @JoinTable(
        name = "alumno_mesas_examen",
        joinColumns = @JoinColumn(name = "alumno_dni"),
        inverseJoinColumns = @JoinColumn(name = "mesa_examen_id")
    )
    private Set<MesaExamen> mesasExamen;

    // Constructores, getters y setters

    public Alumno() {}

    public Alumno(String dni, String nombre, String apellido, String email, Preceptor preceptor) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.preceptor = preceptor;
    }

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

    public Preceptor getPreceptor() {
        return preceptor;
    }

    public void setPreceptor(Preceptor preceptor) {
        this.preceptor = preceptor;
    }

    public List<Falta> getFaltas() {
        return faltas;
    }

    public void setFaltas(List<Falta> faltas) {
        this.faltas = faltas;
    }

    public List<Nota> getNotas() {
        return notas;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }

    public Set<MesaExamen> getMesasExamen() {
        return mesasExamen;
    }

    public void setMesasExamen(Set<MesaExamen> mesasExamen) {
        this.mesasExamen = mesasExamen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Alumno)) return false;
        Alumno alumno = (Alumno) o;
        return dni != null && dni.equals(alumno.dni);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return (
            "Alumno{" +
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
            '}'
        );
    }
}
