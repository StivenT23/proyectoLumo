package com.LUMO.LUMO_Proyecto.controller;

import com.LUMO.LUMO_Proyecto.dto.PreguntaDTO;
import com.LUMO.LUMO_Proyecto.service.PreguntaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/preguntas")
@CrossOrigin("*")
public class PreguntaController {

    private final PreguntaService preguntaService;

    public PreguntaController(PreguntaService preguntaService) {
        this.preguntaService = preguntaService;
    }

    @PostMapping
    public ResponseEntity<PreguntaDTO> crear(@RequestBody PreguntaDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(preguntaService.guardarPregunta(dto));
    }

    @GetMapping
    public ResponseEntity<List<PreguntaDTO>> listar() {
        return ResponseEntity.ok(preguntaService.listarPreguntas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PreguntaDTO> buscarPorId(@PathVariable String id) {
        return preguntaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/materia/{materiaId}")
    public ResponseEntity<List<PreguntaDTO>> buscarPorMateria(@PathVariable String materiaId) {
        return ResponseEntity.ok(preguntaService.buscarPorMateria(materiaId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PreguntaDTO> actualizar(@PathVariable String id, @RequestBody PreguntaDTO dto) {
        return ResponseEntity.ok(preguntaService.actualizarPregunta(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable String id) {
        preguntaService.eliminarPregunta(id);
        return ResponseEntity.ok("Pregunta eliminada correctamente");
    }
}