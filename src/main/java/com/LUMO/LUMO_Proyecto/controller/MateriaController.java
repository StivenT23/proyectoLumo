package com.LUMO.LUMO_Proyecto.controller;

import com.LUMO.LUMO_Proyecto.dto.MateriaDTO;
import com.LUMO.LUMO_Proyecto.service.MateriaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/materias")
@CrossOrigin("*")
public class MateriaController {

    private final MateriaService materiaService;

    public MateriaController(MateriaService materiaService) {
        this.materiaService = materiaService;
    }

    @PostMapping
    public ResponseEntity<MateriaDTO> crear(@RequestBody MateriaDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(materiaService.guardarMateria(dto));
    }

    @GetMapping
    public ResponseEntity<List<MateriaDTO>> listar() {
        return ResponseEntity.ok(materiaService.listarMaterias());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MateriaDTO> buscarPorId(@PathVariable String id) {
        return materiaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<MateriaDTO> actualizar(@PathVariable String id, @RequestBody MateriaDTO dto) {
        return ResponseEntity.ok(materiaService.actualizarMateria(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable String id) {
        materiaService.eliminarMateria(id);
        return ResponseEntity.ok("Materia eliminada correctamente");
    }
}