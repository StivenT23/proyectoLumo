package com.LUMO.LUMO_Proyecto.dto;

import java.util.Date;

public class EstudianteDTO {

    private String id;
    private String usuarioId;
    private Integer edad;
    private String nivelEscolar;
    private String diagnosticoTDAH;
    private Date fechaNacimiento;
    private String padreId;
    private String docenteId;
    private Integer puntosAcumulados;
    private String nivelActual;

    public EstudianteDTO() {
    }

    public EstudianteDTO(String id, String usuarioId, Integer edad, String nivelEscolar,
                         String diagnosticoTDAH, Date fechaNacimiento, String padreId,
                         String docenteId, Integer puntosAcumulados, String nivelActual) {
        this.id = id;
        this.usuarioId = usuarioId;
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
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getUsuarioId() { return usuarioId; }
    public void setUsuarioId(String usuarioId) { this.usuarioId = usuarioId; }

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