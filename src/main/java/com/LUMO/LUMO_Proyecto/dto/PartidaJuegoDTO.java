package com.LUMO.LUMO_Proyecto.dto;

import java.util.Date;

public class PartidaJuegoDTO {

    private String id;
    private String estudianteId;
    private String juegoId;
    private Date fechaInicio;
    private Date fechaFin;
    private Integer puntajeObtenido;
    private Integer tiempoSegundos;
    private String nivelDificultad;
    private Boolean completado;

    public PartidaJuegoDTO() {
    }

    public PartidaJuegoDTO(String id, String estudianteId, String juegoId, Date fechaInicio,
                           Date fechaFin, Integer puntajeObtenido, Integer tiempoSegundos,
                           String nivelDificultad, Boolean completado) {
        this.id = id;
        this.estudianteId = estudianteId;
        this.juegoId = juegoId;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.puntajeObtenido = puntajeObtenido;
        this.tiempoSegundos = tiempoSegundos;
        this.nivelDificultad = nivelDificultad;
        this.completado = completado;
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getEstudianteId() { return estudianteId; }
    public void setEstudianteId(String estudianteId) { this.estudianteId = estudianteId; }

    public String getJuegoId() { return juegoId; }
    public void setJuegoId(String juegoId) { this.juegoId = juegoId; }

    public Date getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(Date fechaInicio) { this.fechaInicio = fechaInicio; }

    public Date getFechaFin() { return fechaFin; }
    public void setFechaFin(Date fechaFin) { this.fechaFin = fechaFin; }

    public Integer getPuntajeObtenido() { return puntajeObtenido; }
    public void setPuntajeObtenido(Integer puntajeObtenido) { this.puntajeObtenido = puntajeObtenido; }

    public Integer getTiempoSegundos() { return tiempoSegundos; }
    public void setTiempoSegundos(Integer tiempoSegundos) { this.tiempoSegundos = tiempoSegundos; }

    public String getNivelDificultad() { return nivelDificultad; }
    public void setNivelDificultad(String nivelDificultad) { this.nivelDificultad = nivelDificultad; }

    public Boolean getCompletado() { return completado; }
    public void setCompletado(Boolean completado) { this.completado = completado; }
}