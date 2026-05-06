package com.LUMO.LUMO_Proyecto.mapper;

import com.LUMO.LUMO_Proyecto.dto.EstudianteDTO;
import com.LUMO.LUMO_Proyecto.model.Estudiante;
import org.springframework.stereotype.Component;

@Component
public class EstudianteMapper {

    // Convierte Estudiante (model) → EstudianteDTO
    // NOTA: nombres, apellidos y correo NO están en Estudiante,
    // esos vienen del Usuario. Este mapper solo mapea los campos del modelo.
    public EstudianteDTO toDTO(Estudiante estudiante) {
        if (estudiante == null) return null;

        EstudianteDTO dto = new EstudianteDTO();
        dto.setId(estudiante.getId());
        dto.setUsuarioId(estudiante.getUsuarioId());
        dto.setEdad(estudiante.getEdad());
        dto.setNivelEscolar(estudiante.getNivelEscolar());
        dto.setDiagnosticoTDAH(estudiante.getDiagnosticoTDAH());
        dto.setFechaNacimiento(estudiante.getFechaNacimiento());
        dto.setPadreId(estudiante.getPadreId());
        dto.setDocenteId(estudiante.getDocenteId());
        dto.setPuntosAcumulados(estudiante.getPuntosAcumulados());
        dto.setNivelActual(estudiante.getNivelActual());
        return dto;
    }

    // Convierte EstudianteDTO → Estudiante (model)
    public Estudiante toEntity(EstudianteDTO dto) {
        if (dto == null) return null;

        Estudiante estudiante = new Estudiante();
        estudiante.setId(dto.getId());
        estudiante.setUsuarioId(dto.getUsuarioId());
        estudiante.setEdad(dto.getEdad());
        estudiante.setNivelEscolar(dto.getNivelEscolar());
        estudiante.setDiagnosticoTDAH(dto.getDiagnosticoTDAH());
        estudiante.setFechaNacimiento(dto.getFechaNacimiento());
        estudiante.setPadreId(dto.getPadreId());
        estudiante.setDocenteId(dto.getDocenteId());
        estudiante.setPuntosAcumulados(dto.getPuntosAcumulados());
        estudiante.setNivelActual(dto.getNivelActual());
        return estudiante;
    }
}