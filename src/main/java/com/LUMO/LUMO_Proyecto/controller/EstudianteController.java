package com.LUMO.LUMO_Proyecto.controller;

import com.LUMO.LUMO_Proyecto.dto.EstudianteDTO;
import com.LUMO.LUMO_Proyecto.dto.EstudianteResponseDTO;
import com.LUMO.LUMO_Proyecto.service.EstudianteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController                  // ← anotación que faltaba
@RequestMapping("/estudiantes")
@CrossOrigin("*")
public class EstudianteController {

    private final EstudianteService estudianteService;

    public EstudianteController(EstudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }

    // POST /estudiantes/registrar-hijo
    // El padre registra a su hijo. El padreId viene del header (temporal, luego del token JWT)
    @PostMapping("/registrar-hijo")
    public ResponseEntity<EstudianteResponseDTO> registrarEstudiante(
            @RequestBody EstudianteDTO dto,
            @RequestHeader("X-Padre-Id") String padreId) {

        EstudianteResponseDTO response = estudianteService.registrarEstudiante(dto, padreId);
        return ResponseEntity.ok(response);
    }

    // GET /estudiantes
    @GetMapping
    public ResponseEntity<List<EstudianteResponseDTO>> listarEstudiantes() {
        return ResponseEntity.ok(estudianteService.listarEstudiantes());
    }

    // GET /estudiantes/{id}
    @GetMapping("/{id}")
    public ResponseEntity<EstudianteResponseDTO> buscarPorId(@PathVariable String id) {
        return estudianteService.buscarPorId(id)   // ← método que faltaba en el service
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // GET /estudiantes/padre/{padreId}
    @GetMapping("/padre/{padreId}")
    public ResponseEntity<List<EstudianteResponseDTO>> buscarPorPadre(@PathVariable String padreId) {
        return ResponseEntity.ok(estudianteService.buscarPorPadre(padreId));
    }

    // GET /estudiantes/docente/{docenteId}
    @GetMapping("/docente/{docenteId}")
    public ResponseEntity<List<EstudianteResponseDTO>> buscarPorDocente(@PathVariable String docenteId) {
        return ResponseEntity.ok(estudianteService.buscarPorDocente(docenteId));
    }
}