package com.LUMO.LUMO_Proyecto.mapper;

import com.LUMO.LUMO_Proyecto.dto.LogroEstudianteDTO;
import com.LUMO.LUMO_Proyecto.model.LogroEstudiante;
import org.springframework.stereotype.Component;

@Component
public class LogroEstudianteMapper {

    public LogroEstudianteDTO toDTO(LogroEstudiante logroEstudiante) {
        if (logroEstudiante == null) return null;

        return new LogroEstudianteDTO(
                logroEstudiante.getId(),
                logroEstudiante.getEstudianteId(),
                logroEstudiante.getLogroId(),
                logroEstudiante.getFechaObtenido(),
                logroEstudiante.getPuntosOtorgados()
        );
    }

    public LogroEstudiante toEntity(LogroEstudianteDTO dto) {
        if (dto == null) return null;

        return new LogroEstudiante(
                dto.getId(),
                dto.getEstudianteId(),
                dto.getLogroId(),
                dto.getFechaObtenido(),
                dto.getPuntosOtorgados()
        );
    }
}