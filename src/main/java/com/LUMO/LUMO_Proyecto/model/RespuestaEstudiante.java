package com.LUMO.LUMO_Proyecto.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Document(collection = "respuestas_estudiante")
public class RespuestaEstudiante {

    @Id
    private String id;

    private String estudianteId;
    private String preguntaId;
    private String partidaId;
    private String respuestaDada;
    private Boolean correcta;
    private Integer puntosObtenidos;
    private Date fechaRespuesta;

    public RespuestaEstudiante() {
    }

    public RespuestaEstudiante(String id, String estudianteId, String preguntaId, String partidaId,
                               String respuestaDada, Boolean correcta, Integer puntosObtenidos, Date fechaRespuesta) {
        this.id = id;
        this.estudianteId = estudianteId;
        this.preguntaId = preguntaId;
        this.partidaId = partidaId;
        this.respuestaDada = respuestaDada;
        this.correcta = correcta;
        this.puntosObtenidos = puntosObtenidos;
        this.fechaRespuesta = fechaRespuesta;
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getEstudianteId() { return estudianteId; }
    public void setEstudianteId(String estudianteId) { this.estudianteId = estudianteId; }

    public String getPreguntaId() { return preguntaId; }
    public void setPreguntaId(String preguntaId) { this.preguntaId = preguntaId; }

    public String getPartidaId() { return partidaId; }
    public void setPartidaId(String partidaId) { this.partidaId = partidaId; }

    public String getRespuestaDada() { return respuestaDada; }
    public void setRespuestaDada(String respuestaDada) { this.respuestaDada = respuestaDada; }

    public Boolean getCorrecta() { return correcta; }
    public void setCorrecta(Boolean correcta) { this.correcta = correcta; }

    public Integer getPuntosObtenidos() { return puntosObtenidos; }
    public void setPuntosObtenidos(Integer puntosObtenidos) { this.puntosObtenidos = puntosObtenidos; }

    public Date getFechaRespuesta() { return fechaRespuesta; }
    public void setFechaRespuesta(Date fechaRespuesta) { this.fechaRespuesta = fechaRespuesta; }
}