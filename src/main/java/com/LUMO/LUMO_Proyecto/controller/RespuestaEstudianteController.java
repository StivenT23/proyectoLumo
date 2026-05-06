package com.LUMO.LUMO_Proyecto.controller;

import com.LUMO.LUMO_Proyecto.dto.RespuestaEstudianteDTO;
import com.LUMO.LUMO_Proyecto.service.RespuestaEstudianteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/respuestas")
@CrossOrigin("*")
public class RespuestaEstudianteController {

    private final RespuestaEstudianteService respuestaService;

    public RespuestaEstudianteController(RespuestaEstudianteService respuestaService) {
        this.respuestaService = respuestaService;
    }

    @PostMapping
    public ResponseEntity<RespuestaEstudianteDTO> crear(@RequestBody RespuestaEstudianteDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(respuestaService.guardarRespuesta(dto));
    }

    @GetMapping
    public ResponseEntity<List<RespuestaEstudianteDTO>> listar() {
        return ResponseEntity.ok(respuestaService.listarRespuestas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RespuestaEstudianteDTO> buscarPorId(@PathVariable String id) {
        return respuestaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/estudiante/{estudianteId}")
    public ResponseEntity<List<RespuestaEstudianteDTO>> buscarPorEstudiante(@PathVariable String estudianteId) {
        return ResponseEntity.ok(respuestaService.buscarPorEstudiante(estudianteId));
    }
}