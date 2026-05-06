package com.LUMO.LUMO_Proyecto.mapper;

import com.LUMO.LUMO_Proyecto.dto.MateriaDTO;
import com.LUMO.LUMO_Proyecto.model.Materia;
import org.springframework.stereotype.Component;

@Component
public class MateriaMapper {

    public MateriaDTO toDTO(Materia materia) {
        if (materia == null) return null;

        return new MateriaDTO(
                materia.getId(),
                materia.getNombre(),
                materia.getDescripcion(),
                materia.getActivo()
        );
    }

    public Materia toEntity(MateriaDTO dto) {
        if (dto == null) return null;

        return new Materia(
                dto.getId(),
                dto.getNombre(),
                dto.getDescripcion(),
                dto.getActivo()
        );
    }
}