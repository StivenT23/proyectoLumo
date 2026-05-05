package com.LUMO.LUMO_Proyecto.dto;

public class NivelDTO {

    private String id;
    private String nombre;
    private String descripcion;
    private Integer numeroNivel;
    private Integer puntosRequeridos;
    private Boolean activo;

    public NivelDTO() {
    }

    public NivelDTO(String id, String nombre, String descripcion, Integer numeroNivel,
                    Integer puntosRequeridos, Boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.numeroNivel = numeroNivel;
        this.puntosRequeridos = puntosRequeridos;
        this.activo = activo;
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public Integer getNumeroNivel() { return numeroNivel; }
    public void setNumeroNivel(Integer numeroNivel) { this.numeroNivel = numeroNivel; }

    public Integer getPuntosRequeridos() { return puntosRequeridos; }
    public void setPuntosRequeridos(Integer puntosRequeridos) { this.puntosRequeridos = puntosRequeridos; }

    public Boolean getActivo() { return activo; }
    public void setActivo(Boolean activo) { this.activo = activo; }
}