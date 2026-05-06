package com.LUMO.LUMO_Proyecto.mapper;

import com.LUMO.LUMO_Proyecto.dto.EstudianteDTO;
import com.LUMO.LUMO_Proyecto.model.Estudiante;
import org.springframework.stereotype.Component;

@Component
public class EstudianteMapper {

    public EstudianteDTO toDTO(Estudiante estudiante) {
        if (estudiante == null) return null;

        return new EstudianteDTO(
                estudiante.getId(),
                estudiante.getUsuarioId(),
                estudiante.getEdad(),
                estudiante.getNivelEscolar(),
                estudiante.getDiagnosticoTDAH(),
                estudiante.getFechaNacimiento(),
                estudiante.getPadreId(),
                estudiante.getDocenteId(),
                estudiante.getPuntosAcumulados(),
                estudiante.getNivelActual()
        );
    }

    public Estudiante toEntity(EstudianteDTO dto) {
        if (dto == null) return null;

        return new Estudiante(
                dto.getId(),
                dto.getUsuarioId(),
                dto.getEdad(),
                dto.getNivelEscolar(),
                dto.getDiagnosticoTDAH(),
                dto.getFechaNacimiento(),
                dto.getPadreId(),
                dto.getDocenteId(),
                dto.getPuntosAcumulados(),
                dto.getNivelActual()
        );
    }
}