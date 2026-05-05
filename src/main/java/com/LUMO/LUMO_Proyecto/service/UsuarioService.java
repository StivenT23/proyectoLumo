package com.LUMO.LUMO_Proyecto.service;

import com.LUMO.LUMO_Proyecto.dto.UsuarioDTO;
import com.LUMO.LUMO_Proyecto.mapper.UsuarioMapper;
import com.LUMO.LUMO_Proyecto.model.Usuario;
import com.LUMO.LUMO_Proyecto.repository.UsuarioRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
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

    public UsuarioService(UsuarioRepository usuarioRepository,
                          UsuarioMapper usuarioMapper,
                          MongoTemplate mongoTemplate) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
        this.mongoTemplate = mongoTemplate;
    }

    public UsuarioDTO guardarUsuario(UsuarioDTO dto) {
        Usuario usuario = usuarioMapper.toEntity(dto);
        usuario.setFechaRegistro(new Date());
        usuario.setEstado(true);

        Usuario usuarioGuardado = usuarioRepository.save(usuario);
        return usuarioMapper.toDTO(usuarioGuardado);
    }

    public List<UsuarioDTO> obtenerUsuarios() {
        System.out.println("Base usada: " + mongoTemplate.getDb().getName());
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream()
                .map(usuarioMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<UsuarioDTO> buscarPorId(String id) {
        return usuarioRepository.findById(id)
                .map(usuarioMapper::toDTO);
    }

    public UsuarioDTO actualizarUsuario(String id, UsuarioDTO dto) {
        return usuarioRepository.findById(id)
                .map(usuarioExistente -> {
                    Usuario usuarioActualizado = usuarioMapper.toEntity(dto);
                    usuarioActualizado.setId(id);
                    usuarioActualizado.setFechaRegistro(usuarioExistente.getFechaRegistro());

                    Usuario guardado = usuarioRepository.save(usuarioActualizado);
                    return usuarioMapper.toDTO(guardado);
                })
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    public void eliminarUsuario(String id) {
        usuarioRepository.deleteById(id);
    }
}