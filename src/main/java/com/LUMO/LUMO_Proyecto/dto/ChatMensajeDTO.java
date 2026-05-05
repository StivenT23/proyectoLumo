package com.LUMO.LUMO_Proyecto.dto;

import java.util.Date;

public class ChatMensajeDTO {

    private String id;
    private String emisorId;
    private String receptorId;
    private String mensaje;
    private Date fechaEnvio;
    private Boolean leido;

    public ChatMensajeDTO() {
    }

    public ChatMensajeDTO(String id, String emisorId, String receptorId, String mensaje,
                          Date fechaEnvio, Boolean leido) {
        this.id = id;
        this.emisorId = emisorId;
        this.receptorId = receptorId;
        this.mensaje = mensaje;
        this.fechaEnvio = fechaEnvio;
        this.leido = leido;
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getEmisorId() { return emisorId; }
    public void setEmisorId(String emisorId) { this.emisorId = emisorId; }

    public String getReceptorId() { return receptorId; }
    public void setReceptorId(String receptorId) { this.receptorId = receptorId; }

    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }

    public Date getFechaEnvio() { return fechaEnvio; }
    public void setFechaEnvio(Date fechaEnvio) { this.fechaEnvio = fechaEnvio; }

    public Boolean getLeido() { return leido; }
    public void setLeido(Boolean leido) { this.leido = leido; }
}