package com.LUMO.LUMO_Proyecto.dto;

import java.util.Date;

public class LogroEstudianteDTO {

    private String id;
    private String estudianteId;
    private String logroId;
    private Date fechaObtenido;
    private Integer puntosOtorgados;

    public LogroEstudianteDTO() {
    }

    public LogroEstudianteDTO(String id, String estudianteId, String logroId,
                              Date fechaObtenido, Integer puntosOtorgados) {
        this.id = id;
        this.estudianteId = estudianteId;
        this.logroId = logroId;
        this.fechaObtenido = fechaObtenido;
        this.puntosOtorgados = puntosOtorgados;
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getEstudianteId() { return estudianteId; }
    public void setEstudianteId(String estudianteId) { this.estudianteId = estudianteId; }

    public String getLogroId() { return logroId; }
    public void setLogroId(String logroId) { this.logroId = logroId; }

    public Date getFechaObtenido() { return fechaObtenido; }
    public void setFechaObtenido(Date fechaObtenido) { this.fechaObtenido = fechaObtenido; }

    public Integer getPuntosOtorgados() { return puntosOtorgados; }
    public void setPuntosOtorgados(Integer puntosOtorgados) { this.puntosOtorgados = puntosOtorgados; }
}