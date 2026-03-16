package com.LUMO.LUMO_Proyecto.controller;

import com.LUMO.LUMO_Proyecto.model.Juego;
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
    public Juego guardarJuego(@RequestBody Juego juego) {
        return juegoService.guardarJuego(juego);
    }

    @GetMapping
    public List<Juego> listarJuegos() {
        return juegoService.listarJuegos();
    }

    @GetMapping("/{id}")
    public Optional<Juego> buscarPorId(@PathVariable String id) {
        return juegoService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public String eliminarJuego(@PathVariable String id) {
        juegoService.eliminarJuego(id);
        return "Juego eliminado correctamente";
    }
}