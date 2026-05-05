package com.LUMO.LUMO_Proyecto.mapper;

import com.LUMO.LUMO_Proyecto.dto.PartidaJuegoDTO;
import com.LUMO.LUMO_Proyecto.model.PartidaJuego;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
public class PartidaJuegoMapper {

    public PartidaJuegoDTO toDTO(PartidaJuego partida) {
        if (partida == null) return null;

        return new PartidaJuegoDTO(
                partida.getId(),
                partida.getEstudianteId(),
                partida.getJuegoId(),
                partida.getFechaInicio(),
                partida.getFechaFin(),
                partida.getPuntajeObtenido(),
                partida.getTiempoSegundos(),
                partida.getNivelDificultad(),
                partida.getCompletado()
        );
    }

    public PartidaJuego toEntity(PartidaJuegoDTO dto) {
        if (dto == null) return null;

        return new PartidaJuego(
                dto.getId(),
                dto.getEstudianteId(),
                dto.getJuegoId(),
                dto.getFechaInicio(),
                dto.getFechaFin(),
                dto.getPuntajeObtenido(),
                dto.getTiempoSegundos(),
                dto.getNivelDificultad(),
                dto.getCompletado()
        );
    }
}