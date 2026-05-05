package com.LUMO.LUMO_Proyecto.service;

import com.LUMO.LUMO_Proyecto.dto.PreguntaDTO;
import com.LUMO.LUMO_Proyecto.mapper.PreguntaMapper;
import com.LUMO.LUMO_Proyecto.model.Pregunta;
import com.LUMO.LUMO_Proyecto.repository.PreguntaRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PreguntaService {

    private final PreguntaRepository preguntaRepository;
    private final PreguntaMapper preguntaMapper;

    public PreguntaService(PreguntaRepository preguntaRepository, PreguntaMapper preguntaMapper) {
        this.preguntaRepository = preguntaRepository;
        this.preguntaMapper = preguntaMapper;
    }

    public PreguntaDTO guardarPregunta(PreguntaDTO dto) {
        Pregunta pregunta = preguntaMapper.toEntity(dto);
        Pregunta guardada = preguntaRepository.save(pregunta);
        return preguntaMapper.toDTO(guardada);
    }

    public List<PreguntaDTO> listarPreguntas() {
        return preguntaRepository.findAll().stream()
                .map(preguntaMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<PreguntaDTO> buscarPorId(String id) {
        return preguntaRepository.findById(id).map(preguntaMapper::toDTO);
    }

    public List<PreguntaDTO> buscarPorMateria(String materiaId) {
        return preguntaRepository.findByMateriaId(materiaId).stream()
                .map(preguntaMapper::toDTO)
                .collect(Collectors.toList());
    }

    public void eliminarPregunta(String id) {
        preguntaRepository.deleteById(id);
    }
}