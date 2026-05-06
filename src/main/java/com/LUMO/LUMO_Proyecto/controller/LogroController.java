package com.LUMO.LUMO_Proyecto.controller;

import com.LUMO.LUMO_Proyecto.dto.LogroDTO;
import com.LUMO.LUMO_Proyecto.service.LogroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/logros")
@CrossOrigin("*")
public class LogroController {

    private final LogroService logroService;

    public LogroController(LogroService logroService) {
        this.logroService = logroService;
    }

    @PostMapping
    public ResponseEntity<LogroDTO> crear(@RequestBody LogroDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(logroService.guardarLogro(dto));
    }

    @GetMapping
    public ResponseEntity<List<LogroDTO>> listar() {
        return ResponseEntity.ok(logroService.listarLogros());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LogroDTO> buscarPorId(@PathVariable String id) {
        return logroService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<LogroDTO> actualizar(@PathVariable String id, @RequestBody LogroDTO dto) {
        return ResponseEntity.ok(logroService.actualizarLogro(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable String id) {
        logroService.eliminarLogro(id);
        return ResponseEntity.ok("Logro eliminado correctamente");
    }
}