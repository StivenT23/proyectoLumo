package com.LUMO.LUMO_Proyecto.service;

import com.LUMO.LUMO_Proyecto.model.Usuario;
import com.LUMO.LUMO_Proyecto.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepositosry.save(usuario);
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> buscarPorId(String id) {
        return usuarioRepository.findById(id);
    }

    public void eliminarUsuario(String id) {
        usuarioRepository.deleteById(id);
    }
}