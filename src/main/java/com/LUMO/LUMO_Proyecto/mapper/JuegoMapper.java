package com.LUMO.LUMO_Proyecto.mapper;

import com.LUMO.LUMO_Proyecto.dto.JuegoDTO;
import com.LUMO.LUMO_Proyecto.model.Juego;
import org.springframework.stereotype.Component;

@Component
public class JuegoMapper {

    public JuegoDTO toDTO(Juego juego) {
        if (juego == null) return null;

        return new JuegoDTO(
                juego.getId(),
                juego.getNombre(),
                juego.getDescripcion(),
                juego.getTipo(),
                juego.getNivelDificultad(),
                juego.getActivo()
        );
    }

    public Juego toEntity(JuegoDTO dto) {
        if (dto == null) return null;

        return new Juego(
                dto.getId(),
                dto.getNombre(),
                dto.getDescripcion(),
                dto.getTipo(),
                dto.getNivelDificultad(),
                dto.getActivo()
        );
    }
}