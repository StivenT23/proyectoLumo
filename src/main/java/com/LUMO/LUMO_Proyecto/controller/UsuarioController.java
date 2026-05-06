package com.LUMO.LUMO_Proyecto.controller;

import com.LUMO.LUMO_Proyecto.dto.UsuarioDTO;
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
    public UsuarioDTO guardarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        return usuarioService.guardarUsuario(usuarioDTO);
    }

    @GetMapping
    public List<UsuarioDTO> obtenerUsuarios() {
        List<UsuarioDTO> usuarios = usuarioService.obtenerUsuarios();
        System.out.println("Usuarios encontrados: " + usuarios.size());
        return usuarios;
    }

    @GetMapping("/{id}")
    public UsuarioDTO buscarPorId(@PathVariable String id) {
        return usuarioService.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    @PutMapping("/{id}")
    public UsuarioDTO actualizarUsuario(@PathVariable String id, @RequestBody UsuarioDTO usuarioDTO) {
        return usuarioService.actualizarUsuario(id, usuarioDTO);
    }

    @DeleteMapping("/{id}")
    public String eliminarUsuario(@PathVariable String id) {
        usuarioService.eliminarUsuario(id);
        return "Usuario eliminado correctamente";
    }
}