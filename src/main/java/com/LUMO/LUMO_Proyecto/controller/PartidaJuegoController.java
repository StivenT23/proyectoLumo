package com.LUMO.LUMO_Proyecto.controller;

import com.LUMO.LUMO_Proyecto.dto.PartidaJuegoDTO;
import com.LUMO.LUMO_Proyecto.service.PartidaJuegoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/partidas")
@CrossOrigin("*")
public class PartidaJuegoController {

    private final PartidaJuegoService partidaService;

    public PartidaJuegoController(PartidaJuegoService partidaService) {
        this.partidaService = partidaService;
    }

    @PostMapping
    public ResponseEntity<PartidaJuegoDTO> crear(@RequestBody PartidaJuegoDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(partidaService.guardarPartida(dto));
    }

    @GetMapping
    public ResponseEntity<List<PartidaJuegoDTO>> listar() {
        return ResponseEntity.ok(partidaService.listarPartidas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PartidaJuegoDTO> buscarPorId(@PathVariable String id) {
        return partidaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/estudiante/{estudianteId}")
    public ResponseEntity<List<PartidaJuegoDTO>> buscarPorEstudiante(@PathVariable String estudianteId) {
        return ResponseEntity.ok(partidaService.buscarPorEstudiante(estudianteId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable String id) {
        partidaService.eliminarPartida(id);
        return ResponseEntity.ok("Partida eliminada correctamente");
    }
}