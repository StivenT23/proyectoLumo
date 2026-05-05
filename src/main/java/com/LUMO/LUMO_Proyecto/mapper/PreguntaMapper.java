package com.LUMO.LUMO_Proyecto.mapper;

import com.LUMO.LUMO_Proyecto.dto.PreguntaDTO;
import com.LUMO.LUMO_Proyecto.model.Pregunta;
import org.springframework.stereotype.Component;

@Component
public class PreguntaMapper {

    public PreguntaDTO toDTO(Pregunta pregunta) {
        if (pregunta == null) return null;

        return new PreguntaDTO(
                pregunta.getId(),
                pregunta.getMateriaId(),
                pregunta.getTextoPregunta(),
                pregunta.getTipo(),
                pregunta.getDificultad(),
                pregunta.getRespuestaCorrecta(),
                pregunta.getOpciones(),
                pregunta.getActivo()
        );
    }

    public Pregunta toEntity(PreguntaDTO dto) {
        if (dto == null) return null;

        return new Pregunta(
                dto.getId(),
                dto.getMateriaId(),
                dto.getTextoPregunta(),
                dto.getTipo(),
                dto.getDificultad(),
                dto.getRespuestaCorrecta(),
                dto.getOpciones(),
                dto.getActivo()
        );
    }
}