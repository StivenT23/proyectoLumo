package com.LUMO.LUMO_Proyecto.mapper;

import com.LUMO.LUMO_Proyecto.dto.RespuestaEstudianteDTO;
import com.LUMO.LUMO_Proyecto.model.RespuestaEstudiante;
import org.springframework.stereotype.Component;

@Component
public class RespuestaEstudianteMapper {

    public RespuestaEstudianteDTO toDTO(RespuestaEstudiante respuesta) {
        if (respuesta == null) return null;

        return new RespuestaEstudianteDTO(
                respuesta.getId(),
                respuesta.getEstudianteId(),
                respuesta.getPreguntaId(),
                respuesta.getPartidaId(),
                respuesta.getRespuestaDada(),
                respuesta.getCorrecta(),
                respuesta.getPuntosObtenidos(),
                respuesta.getFechaRespuesta()
        );
    }

    public RespuestaEstudiante toEntity(RespuestaEstudianteDTO dto) {
        if (dto == null) return null;

        return new RespuestaEstudiante(
                dto.getId(),
                dto.getEstudianteId(),
                dto.getPreguntaId(),
                dto.getPartidaId(),
                dto.getRespuestaDada(),
                dto.getCorrecta(),
                dto.getPuntosObtenidos(),
                dto.getFechaRespuesta()
        );
    }
}