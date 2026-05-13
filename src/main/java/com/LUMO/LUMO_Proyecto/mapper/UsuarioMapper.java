package com.LUMO.LUMO_Proyecto.mapper;

import com.LUMO.LUMO_Proyecto.dto.UsuarioDTO;
import com.LUMO.LUMO_Proyecto.model.Usuario;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class UsuarioMapper {

    public UsuarioDTO toDTO(Usuario usuario) {
        if (usuario == null) return null;

        return new UsuarioDTO(
                usuario.get_id(),           // ObjectId
                usuario.getCodigoUsuario(), // "usr_001"
                usuario.getCorreo(),
                usuario.getNombres(),
                usuario.getApellidos(),
                usuario.getRol(),
                usuario.getFechaRegistro(),
                usuario.getEstado()
        );
    }

    public Usuario toEntity(UsuarioDTO dto) {
        if (dto == null) return null;

        Usuario usuario = new Usuario();

        usuario.set_id(dto.getId());
        usuario.setCodigoUsuario(dto.getIdPersonalizado());
        usuario.setCorreo(dto.getCorreo());
        usuario.setNombres(dto.getNombres());
        usuario.setApellidos(dto.getApellidos());
        usuario.setRol(dto.getRol());
        usuario.setFechaRegistro(dto.getFechaRegistro() != null ? dto.getFechaRegistro() : new Date());
        usuario.setEstado(dto.getEstado() != null ? dto.getEstado() : true);

        if (dto.getPassword() != null && !dto.getPassword().isBlank()) {
            usuario.setPassword(dto.getPassword());
        }

        return usuario;
    }
}