package com.LUMO.LUMO_Proyecto.service;

import com.LUMO.LUMO_Proyecto.dto.RespuestaEstudianteDTO;
import com.LUMO.LUMO_Proyecto.mapper.RespuestaEstudianteMapper;
import com.LUMO.LUMO_Proyecto.model.RespuestaEstudiante;
import com.LUMO.LUMO_Proyecto.repository.RespuestaEstudianteRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RespuestaEstudianteService {

    private final RespuestaEstudianteRepository respuestaRepository;
    private final RespuestaEstudianteMapper respuestaMapper;

    public RespuestaEstudianteService(RespuestaEstudianteRepository respuestaRepository,
                                      RespuestaEstudianteMapper respuestaMapper) {
        this.respuestaRepository = respuestaRepository;
        this.respuestaMapper = respuestaMapper;
    }

    public RespuestaEstudianteDTO guardarRespuesta(RespuestaEstudianteDTO dto) {
        RespuestaEstudiante respuesta = respuestaMapper.toEntity(dto);
        RespuestaEstudiante guardada = respuestaRepository.save(respuesta);
        return respuestaMapper.toDTO(guardada);
    }

    public List<RespuestaEstudianteDTO> listarRespuestas() {
        return respuestaRepository.findAll().stream()
                .map(respuestaMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<RespuestaEstudianteDTO> buscarPorEstudiante(String estudianteId) {
        return respuestaRepository.findByEstudianteId(estudianteId).stream()
                .map(respuestaMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<RespuestaEstudianteDTO> buscarPorId(String id) {
        return respuestaRepository.findById(id).map(respuestaMapper::toDTO);
    }
}