package com.LUMO.LUMO_Proyecto.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Document(collection = "usuarios")
public class Usuario {

    @Id
    private String id;
    private String correo;
    private String nombres;
    private String apellidos;
    private String password;
    private String rol;
    private Date fechaRegistro;
    private Boolean estado;

    public Usuario() {
    }

    public Usuario(String id, String correo, String nombres, String apellidos,
                   String password, String rol, Date fechaRegistro, Boolean estado) {
        this.id = id;
        this.correo = correo;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.password = password;
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

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getRol() { return rol; }
    public void setRol(String rol) { this.rol = rol; }

    public Date getFechaRegistro() { return fechaRegistro; }
    public void setFechaRegistro(Date fechaRegistro) { this.fechaRegistro = fechaRegistro; }

    public Boolean getEstado() { return estado; }
    public void setEstado(Boolean estado) { this.estado = estado; }
}