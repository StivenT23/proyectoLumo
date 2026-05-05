package com.LUMO.LUMO_Proyecto.dto;

public class LogroDTO {

    private String id;
    private String nombre;
    private String descripcion;
    private String tipo;
    private Integer puntosRecompensa;
    private String icono;

    public LogroDTO() {
    }

    public LogroDTO(String id, String nombre, String descripcion, String tipo,
                    Integer puntosRecompensa, String icono) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.puntosRecompensa = puntosRecompensa;
        this.icono = icono;
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public Integer getPuntosRecompensa() { return puntosRecompensa; }
    public void setPuntosRecompensa(Integer puntosRecompensa) { this.puntosRecompensa = puntosRecompensa; }

    public String getIcono() { return icono; }
    public void setIcono(String icono) { this.icono = icono; }
}