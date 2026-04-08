package com.LUMO.LUMO_Proyecto.controller;

import com.LUMO.LUMO_Proyecto.model.Usuario;
import com.LUMO.LUMO_Proyecto.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public Usuario guardarUsuario(@RequestBody Usuario usuario) {
        return usuarioService.guardarUsuario(usuario);
    }

    @GetMapping
    public List<Usuario> obtenerUsuarios() {
        List<Usuario> usuarios = usuarioService.obtenerUsuarios();
        System.out.println("Usuarios encontrados: " + usuarios.size());
        return usuarios;
    }

    @GetMapping("/{id}")
    public Usuario buscarPorId(@PathVariable String id) {
        return usuarioService.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    @DeleteMapping("/{id}")
    public String eliminarUsuario(@PathVariable String id) {
        usuarioService.eliminarUsuario(id);
        return "Usuario eliminado correctamente";
    }
}