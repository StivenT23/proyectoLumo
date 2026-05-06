package com.LUMO.LUMO_Proyecto.service;

import com.LUMO.LUMO_Proyecto.dto.UsuarioDTO;
import com.LUMO.LUMO_Proyecto.mapper.UsuarioMapper;
import com.LUMO.LUMO_Proyecto.model.Usuario;
import com.LUMO.LUMO_Proyecto.repository.UsuarioRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;
    private final MongoTemplate mongoTemplate;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository,
                          UsuarioMapper usuarioMapper,
                          MongoTemplate mongoTemplate,
                          PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
        this.mongoTemplate = mongoTemplate;
        this.passwordEncoder = passwordEncoder;
    }

    public UsuarioDTO guardarUsuario(UsuarioDTO dto) {
        Usuario usuario = usuarioMapper.toEntity(dto);
        usuario.setFechaRegistro(new Date());
        usuario.setEstado(true);
        // Encriptar password con BCrypt
        if (dto.getPassword() != null && !dto.getPassword().isBlank()) {
            usuario.setPassword(passwordEncoder.encode(dto.getPassword()));
        }
        Usuario guardado = usuarioRepository.save(usuario);
        return usuarioMapper.toDTO(guardado);
    }

    public List<UsuarioDTO> obtenerUsuarios() {
        System.out.println("Base usada: " + mongoTemplate.getDb().getName());
        return usuarioRepository.findAll().stream()
                .map(usuarioMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<UsuarioDTO> buscarPorId(String id) {
        return usuarioRepository.findById(id)
                .map(usuarioMapper::toDTO);
    }

    public UsuarioDTO actualizarUsuario(String id, UsuarioDTO dto) {
        return usuarioRepository.findById(id)
                .map(existente -> {
                    Usuario actualizado = usuarioMapper.toEntity(dto);
                    actualizado.setId(id);
                    actualizado.setFechaRegistro(existente.getFechaRegistro());
                    // Solo re-encriptar si se envía nueva password
                    if (dto.getPassword() != null && !dto.getPassword().isBlank()) {
                        actualizado.setPassword(passwordEncoder.encode(dto.getPassword()));
                    } else {
                        actualizado.setPassword(existente.getPassword());
                    }
                    return usuarioMapper.toDTO(usuarioRepository.save(actualizado));
                })
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con id: " + id));
    }

    public void eliminarUsuario(String id) {
        usuarioRepository.deleteById(id);
    }
}