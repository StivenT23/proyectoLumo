package com.LUMO.LUMO_Proyecto.dto;

public class UsuarioDTO {

    private int estudiantes;
    private int docentes;
    private int administradores;

    public int getEstudiantes() { return estudiantes; }
    public void setEstudiantes(int estudiantes) { this.estudiantes = estudiantes; }

    public int getDocentes() { return docentes; }
    public void setDocentes(int docentes) { this.docentes = docentes; }

    public int getAdministradores() { return administradores; }
    public void setAdministradores(int administradores) { this.administradores = administradores; }
}