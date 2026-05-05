package com.LUMO.LUMO_Proyecto.dto;

public class PreguntaDTO {

    private String id;
    private String materiaId;
    private String textoPregunta;
    private String tipo;
    private String dificultad;
    private String respuestaCorrecta;
    private String opciones;
    private Boolean activo;

    public PreguntaDTO() {
    }

    public PreguntaDTO(String id, String materiaId, String textoPregunta, String tipo,
                       String dificultad, String respuestaCorrecta, String opciones, Boolean activo) {
        this.id = id;
        this.materiaId = materiaId;
        this.textoPregunta = textoPregunta;
        this.tipo = tipo;
        this.dificultad = dificultad;
        this.respuestaCorrecta = respuestaCorrecta;
        this.opciones = opciones;
        this.activo = activo;
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getMateriaId() { return materiaId; }
    public void setMateriaId(String materiaId) { this.materiaId = materiaId; }

    public String getTextoPregunta() { return textoPregunta; }
    public void setTextoPregunta(String textoPregunta) { this.textoPregunta = textoPregunta; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getDificultad() { return dificultad; }
    public void setDificultad(String dificultad) { this.dificultad = dificultad; }

    public String getRespuestaCorrecta() { return respuestaCorrecta; }
    public void setRespuestaCorrecta(String respuestaCorrecta) { this.respuestaCorrecta = respuestaCorrecta; }

    public String getOpciones() { return opciones; }
    public void setOpciones(String opciones) { this.opciones = opciones; }

    public Boolean getActivo() { return activo; }
    public void setActivo(Boolean activo) { this.activo = activo; }
}