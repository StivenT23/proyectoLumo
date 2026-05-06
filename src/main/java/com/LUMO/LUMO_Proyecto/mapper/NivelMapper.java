package com.LUMO.LUMO_Proyecto.mapper;

import com.LUMO.LUMO_Proyecto.dto.NivelDTO;
import com.LUMO.LUMO_Proyecto.model.Nivel;
import org.springframework.stereotype.Component;

@Component
public class NivelMapper {

    public NivelDTO toDTO(Nivel nivel) {
        if (nivel == null) return null;
        NivelDTO dto = new NivelDTO();
        dto.setId(nivel.getId());
        dto.setNombre(nivel.getNombre());
        dto.setDescripcion(nivel.getDescripcion());
        dto.setNumeroNivel(nivel.getNumeroNivel());
        dto.setPuntosRequeridos(nivel.getPuntosRequeridos());
        dto.setActivo(nivel.getActivo());
        return dto;
    }

    public Nivel toEntity(NivelDTO dto) {
        if (dto == null) return null;
        Nivel nivel = new Nivel();
        nivel.setId(dto.getId());
        nivel.setNombre(dto.getNombre());
        nivel.setDescripcion(dto.getDescripcion());
        nivel.setNumeroNivel(dto.getNumeroNivel());
        nivel.setPuntosRequeridos(dto.getPuntosRequeridos());
        nivel.setActivo(dto.getActivo());
        return nivel;
    }
}