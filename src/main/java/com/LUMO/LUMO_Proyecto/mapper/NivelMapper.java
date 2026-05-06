package com.LUMO.LUMO_Proyecto.mapper;

import com.LUMO.LUMO_Proyecto.dto.NivelDTO;
import com.LUMO.LUMO_Proyecto.model.Nivel;
import org.springframework.stereotype.Component;

@Component
public class NivelMapper {

    public NivelDTO toDTO(Nivel nivel) {
        if (nivel == null) return null;

        return new NivelDTO(
                nivel.getId(),
                nivel.getNombre(),
                nivel.getDescripcion(),
                nivel.getNumeroNivel(),
                nivel.getPuntosRequeridos(),
                nivel.getActivo()
        );
    }

    public Nivel toEntity(NivelDTO dto) {
        if (dto == null) return null;

        return new Nivel(
                dto.getId(),
                dto.getNombre(),
                dto.getDescripcion(),
                dto.getNumeroNivel(),
                dto.getPuntosRequeridos(),
                dto.getActivo()
        );
    }
}