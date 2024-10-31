package com.mycompany.myapp.service.dto;

import java.util.List;

public class AlumnoDto {

    private String dni;
    private String nombre;
    private String apellido;
    private String email;

    // Relación con Preceptor (solo el ID o DNI, en lugar de la entidad completa)
    private String preceptorDni;

    // Relación con Faltas (IDs o fechas de las faltas)
    private List<Long> faltasIds;

    // Relación con Notas (puede ser solo el ID de la nota o el valor)
    private List<NotaDto> notas;

    // Relación con Mesas de Examen (solo IDs o nombres de las mesas)
    private List<Long> mesasExamenIds;

    //Constructores

    public AlumnoDto() {}

    public AlumnoDto(
        String dni,
        String nombre,
        String apellido,
        String email,
        String preceptorDni,
        List<Long> faltasIds,
        List<NotaDto> notas,
        List<Long> mesasExamenIds
    ) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.preceptorDni = preceptorDni;
        this.faltasIds = faltasIds;
        this.notas = notas;
        this.mesasExamenIds = mesasExamenIds;
    }

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

    public String getPreceptorDni() {
        return preceptorDni;
    }

    public void setPreceptorDni(String preceptorDni) {
        this.preceptorDni = preceptorDni;
    }

    public List<Long> getFaltasIds() {
        return faltasIds;
    }

    public void setFaltasIds(List<Long> faltasIds) {
        this.faltasIds = faltasIds;
    }

    public List<NotaDto> getNotas() {
        return notas;
    }

    public void setNotas(List<NotaDto> notas) {
        this.notas = notas;
    }

    public List<Long> getMesasExamenIds() {
        return mesasExamenIds;
    }

    public void setMesasExamenIds(List<Long> mesasExamenIds) {
        this.mesasExamenIds = mesasExamenIds;
    }

    @Override
    public String toString() {
        return (
            "AlumnoDTO{" +
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
            ", preceptorDni='" +
            preceptorDni +
            '\'' +
            ", faltasIds=" +
            faltasIds +
            ", notas=" +
            notas +
            ", mesasExamenIds=" +
            mesasExamenIds +
            '}'
        );
    }
}
