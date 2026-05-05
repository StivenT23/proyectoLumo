package com.LUMO.LUMO_Proyecto.dto;

import java.util.Date;

public class UsuarioDTO {

    private String id;
    private String correo;
    private String nombres;
    private String apellidos;
    private String rol;
    private Date fechaRegistro;
    private Boolean estado;

    // Constructor vacío
    public UsuarioDTO() {
    }

    // Constructor completo
    public UsuarioDTO(String id, String correo, String nombres, String apellidos,
                      String rol, Date fechaRegistro, Boolean estado) {
        this.id = id;
        this.correo = correo;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.rol = rol;
        this.fechaRegistro = fechaRegistro;
        this.estado = estado;
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getNombres() { return nombres; }
    public void setNombres(String nombres) { this.nombres = nombres; }

    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }

    public String getRol() { return rol; }
    public void setRol(String rol) { this.rol = rol; }

    public Date getFechaRegistro() { return fechaRegistro; }
    public void setFechaRegistro(Date fechaRegistro) { this.fechaRegistro = fechaRegistro; }

    public Boolean getEstado() { return estado; }
    public void setEstado(Boolean estado) { this.estado = estado; }
}