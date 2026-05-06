package com.LUMO.LUMO_Proyecto.service;

import com.LUMO.LUMO_Proyecto.dto.LogroDTO;
import com.LUMO.LUMO_Proyecto.mapper.LogroMapper;
import com.LUMO.LUMO_Proyecto.model.Logro;
import com.LUMO.LUMO_Proyecto.repository.LogroRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LogroService {

    private final LogroRepository logroRepository;
    private final LogroMapper logroMapper;

    public LogroService(LogroRepository logroRepository, LogroMapper logroMapper) {
        this.logroRepository = logroRepository;
        this.logroMapper = logroMapper;
    }

    public LogroDTO guardarLogro(LogroDTO dto) {
        Logro logro = logroMapper.toEntity(dto);
        Logro guardado = logroRepository.save(logro);
        return logroMapper.toDTO(guardado);
    }

    public List<LogroDTO> listarLogros() {
        return logroRepository.findAll().stream()
                .map(logroMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<LogroDTO> buscarPorId(String id) {
        return logroRepository.findById(id).map(logroMapper::toDTO);
    }

    public LogroDTO actualizarLogro(String id, LogroDTO dto) {
        return logroRepository.findById(id)
                .map(existing -> {
                    Logro actualizado = logroMapper.toEntity(dto);
                    actualizado.setId(id);
                    return logroMapper.toDTO(logroRepository.save(actualizado));
                })
                .orElseThrow(() -> new RuntimeException("Logro no encontrado"));
    }

    public void eliminarLogro(String id) {
        logroRepository.deleteById(id);
    }
}