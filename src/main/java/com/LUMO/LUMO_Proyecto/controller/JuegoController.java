package com.LUMO.LUMO_Proyecto.controller;

import com.LUMO.LUMO_Proyecto.dto.JuegoDTO;
import com.LUMO.LUMO_Proyecto.service.JuegoService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/juegos")
public class JuegoController {

    private final JuegoService juegoService;

    public JuegoController(JuegoService juegoService) {
        this.juegoService = juegoService;
    }

    @PostMapping
    public JuegoDTO guardarJuego(@RequestBody JuegoDTO juegoDTO) {
        return juegoService.guardarJuego(juegoDTO);
    }

    @GetMapping
    public List<JuegoDTO> listarJuegos() {
        return juegoService.listarJuegos();
    }

    @GetMapping("/{id}")
    public JuegoDTO buscarPorId(@PathVariable String id) {
        return juegoService.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Juego no encontrado"));
    }

    @PutMapping("/{id}")
    public JuegoDTO actualizarJuego(@PathVariable String id, @RequestBody JuegoDTO juegoDTO) {
        return juegoService.actualizarJuego(id, juegoDTO);
    }

    @DeleteMapping("/{id}")
    public String eliminarJuego(@PathVariable String id) {
        juegoService.eliminarJuego(id);
        return "Juego eliminado correctamente";
    }
}