package com.LUMO.LUMO_Proyecto.mapper;

import com.LUMO.LUMO_Proyecto.dto.LogroDTO;
import com.LUMO.LUMO_Proyecto.model.Logro;
import org.springframework.stereotype.Component;

@Component
public class LogroMapper {

    public LogroDTO toDTO(Logro logro) {
        if (logro == null) return null;

        return new LogroDTO(
                logro.getId(),
                logro.getNombre(),
                logro.getDescripcion(),
                logro.getTipo(),
                logro.getPuntosRecompensa(),
                logro.getIcono()
        );
    }

    public Logro toEntity(LogroDTO dto) {
        if (dto == null) return null;

        return new Logro(
                dto.getId(),
                dto.getNombre(),
                dto.getDescripcion(),
                dto.getTipo(),
                dto.getPuntosRecompensa(),
                dto.getIcono()
        );
    }
}