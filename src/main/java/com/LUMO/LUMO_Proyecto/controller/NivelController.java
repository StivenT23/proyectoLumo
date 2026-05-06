package com.LUMO.LUMO_Proyecto.controller;

import com.LUMO.LUMO_Proyecto.dto.NivelDTO;
import com.LUMO.LUMO_Proyecto.service.NivelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/niveles")
@CrossOrigin("*")
public class NivelController {

    private final NivelService nivelService;

    public NivelController(NivelService nivelService) {
        this.nivelService = nivelService;
    }

    @PostMapping
    public ResponseEntity<NivelDTO> crear(@RequestBody NivelDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(nivelService.guardarNivel(dto));
    }

    @GetMapping
    public ResponseEntity<List<NivelDTO>> listar() {
        return ResponseEntity.ok(nivelService.listarNiveles());
    }

    @GetMapping("/{id}")
    public ResponseEntity<NivelDTO> buscarPorId(@PathVariable String id) {
        return nivelService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<NivelDTO> actualizar(@PathVariable String id, @RequestBody NivelDTO dto) {
        return ResponseEntity.ok(nivelService.actualizarNivel(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable String id) {
        nivelService.eliminarNivel(id);
        return ResponseEntity.ok("Nivel eliminado correctamente");
    }
}