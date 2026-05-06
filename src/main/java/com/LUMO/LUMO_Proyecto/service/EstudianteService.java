package com.LUMO.LUMO_Proyecto.service;

import com.LUMO.LUMO_Proyecto.dto.EstudianteDTO;
import com.LUMO.LUMO_Proyecto.mapper.EstudianteMapper;
import com.LUMO.LUMO_Proyecto.model.Estudiante;
import com.LUMO.LUMO_Proyecto.repository.EstudianteRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EstudianteService {

    private final EstudianteRepository estudianteRepository;
    private final EstudianteMapper estudianteMapper;

    public EstudianteService(EstudianteRepository estudianteRepository, EstudianteMapper estudianteMapper) {
        this.estudianteRepository = estudianteRepository;
        this.estudianteMapper = estudianteMapper;
    }

    public EstudianteDTO guardarEstudiante(EstudianteDTO dto) {
        Estudiante estudiante = estudianteMapper.toEntity(dto);
        Estudiante guardado = estudianteRepository.save(estudiante);
        return estudianteMapper.toDTO(guardado);
    }

    public List<EstudianteDTO> listarEstudiantes() {
        List<Estudiante> estudiantes = estudianteRepository.findAll();
        return estudiantes.stream()
                .map(estudianteMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<EstudianteDTO> buscarPorId(String id) {
        return estudianteRepository.findById(id)
                .map(estudianteMapper::toDTO);
    }

    public EstudianteDTO actualizarEstudiante(String id, EstudianteDTO dto) {
        return estudianteRepository.findById(id)
                .map(est -> {
                    Estudiante actualizado = estudianteMapper.toEntity(dto);
                    actualizado.setId(id);
                    Estudiante guardado = estudianteRepository.save(actualizado);
                    return estudianteMapper.toDTO(guardado);
                })
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));
    }

    public void eliminarEstudiante(String id) {
        estudianteRepository.deleteById(id);
    }
}