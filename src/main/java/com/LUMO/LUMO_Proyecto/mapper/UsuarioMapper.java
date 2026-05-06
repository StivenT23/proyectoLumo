package com.LUMO.LUMO_Proyecto.mapper;

import com.LUMO.LUMO_Proyecto.dto.UsuarioDTO;
import com.LUMO.LUMO_Proyecto.model.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    // Entity → DTO
    public UsuarioDTO toDTO(Usuario usuario) {
        if (usuario == null) return null;

        return new UsuarioDTO(
                usuario.getId(),
                usuario.getCorreo(),
                usuario.getNombres(),
                usuario.getApellidos(),
                usuario.getRol(),
                usuario.getFechaRegistro(),
                usuario.getEstado()
        );
    }

    // DTO → Entity
    public Usuario toEntity(UsuarioDTO dto) {
        if (dto == null) return null;

        return new Usuario(
                dto.getId(),
                dto.getCorreo(),
                dto.getNombres(),
                dto.getApellidos(),
                null,                    // Password se maneja aparte por seguridad
                dto.getRol(),
                dto.getFechaRegistro(),
                dto.getEstado()
        );
    }
}