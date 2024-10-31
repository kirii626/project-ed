package com.mycompany.myapp.domain;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "profesor")
public class Profesor {

    @Id
    @Column(name = "dni", nullable = false, length = 20)
    private String dni;

    @Column(name = "nombre", length = 100)
    private String nombre;

    @Column(name = "apellido", length = 100)
    private String apellido;

    @Column(name = "email", length = 100)
    private String email;

    // Relación One-to-Many con Horario
    @OneToMany(mappedBy = "profesor", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Horario> horarios = new HashSet<>();

    // Relación One-to-Many con MesaExamen
    @OneToMany(mappedBy = "profesor", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<MesaExamen> mesasExamen = new HashSet<>();

    // Getters y Setters

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

    public Set<Horario> getHorarios() {
        return horarios;
    }

    public void setHorarios(Set<Horario> horarios) {
        this.horarios = horarios;
    }

    public Set<MesaExamen> getMesasExamen() {
        return mesasExamen;
    }

    public void setMesasExamen(Set<MesaExamen> mesasExamen) {
        this.mesasExamen = mesasExamen;
    }

    // Métodos auxiliares para gestionar las relaciones bidireccionales

    public void addHorario(Horario horario) {
        horarios.add(horario);
        horario.setProfesor(this);
    }

    public void removeHorario(Horario horario) {
        horarios.remove(horario);
        horario.setProfesor(null);
    }

    public void addMesaExamen(MesaExamen mesaExamen) {
        mesasExamen.add(mesaExamen);
        mesaExamen.setProfesor(this);
    }

    public void removeMesaExamen(MesaExamen mesaExamen) {
        mesasExamen.remove(mesaExamen);
        mesaExamen.setProfesor(null);
    }
}
