package com.LUMO.LUMO_Proyecto.dto;

public class MateriaDTO {

    private String id;
    private String nombre;
    private String descripcion;
    private Boolean activo;

    public MateriaDTO() {
    }

    public MateriaDTO(String id, String nombre, String descripcion, Boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.activo = activo;
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public Boolean getActivo() { return activo; }
    public void setActivo(Boolean activo) { this.activo = activo; }
}