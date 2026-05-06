package com.LUMO.LUMO_Proyecto.dto;

import java.util.Date;

public class EstudianteResponseDTO {

    // Datos del Usuario
    private String usuarioId;
    private String nombres;
    private String apellidos;
    private String correo;
    private String rol;  // ← CAMPO AGREGADO (faltaba)

    // Datos del Estudiante
    private String estudianteId;
    private Integer edad;
    private String nivelEscolar;
    private String diagnosticoTDAH;
    private Date fechaNacimiento;
    private String padreId;
    private String docenteId;
    private Integer puntosAcumulados;
    private String nivelActual;

    public EstudianteResponseDTO() {
    }

    // Constructor completo con rol
    public EstudianteResponseDTO(String usuarioId, String nombres, String apellidos, String correo,
                                 String rol, String estudianteId, Integer edad, String nivelEscolar,
                                 String diagnosticoTDAH, Date fechaNacimiento, String padreId,
                                 String docenteId, Integer puntosAcumulados, String nivelActual) {
        this.usuarioId = usuarioId;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.rol = rol;
        this.estudianteId = estudianteId;
        this.edad = edad;
        this.nivelEscolar = nivelEscolar;
        this.diagnosticoTDAH = diagnosticoTDAH;
        this.fechaNacimiento = fechaNacimiento;
        this.padreId = padreId;
        this.docenteId = docenteId;
        this.puntosAcumulados = puntosAcumulados;
        this.nivelActual = nivelActual;
    }

    // Getters y Setters
    public String getUsuarioId() { return usuarioId; }
    public void setUsuarioId(String usuarioId) { this.usuarioId = usuarioId; }

    public String getNombres() { return nombres; }
    public void setNombres(String nombres) { this.nombres = nombres; }

    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getRol() { return rol; }
    public void setRol(String rol) { this.rol = rol; }

    public String getEstudianteId() { return estudianteId; }
    public void setEstudianteId(String estudianteId) { this.estudianteId = estudianteId; }

    public Integer getEdad() { return edad; }
    public void setEdad(Integer edad) { this.edad = edad; }

    public String getNivelEscolar() { return nivelEscolar; }
    public void setNivelEscolar(String nivelEscolar) { this.nivelEscolar = nivelEscolar; }

    public String getDiagnosticoTDAH() { return diagnosticoTDAH; }
    public void setDiagnosticoTDAH(String diagnosticoTDAH) { this.diagnosticoTDAH = diagnosticoTDAH; }

    public Date getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(Date fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }

    public String getPadreId() { return padreId; }
    public void setPadreId(String padreId) { this.padreId = padreId; }

    public String getDocenteId() { return docenteId; }
    public void setDocenteId(String docenteId) { this.docenteId = docenteId; }

    public Integer getPuntosAcumulados() { return puntosAcumulados; }
    public void setPuntosAcumulados(Integer puntosAcumulados) { this.puntosAcumulados = puntosAcumulados; }

    public String getNivelActual() { return nivelActual; }
    public void setNivelActual(String nivelActual) { this.nivelActual = nivelActual; }
}