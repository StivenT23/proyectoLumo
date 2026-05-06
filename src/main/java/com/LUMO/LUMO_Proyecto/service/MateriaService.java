package com.LUMO.LUMO_Proyecto.service;

import com.LUMO.LUMO_Proyecto.dto.MateriaDTO;
import com.LUMO.LUMO_Proyecto.mapper.MateriaMapper;
import com.LUMO.LUMO_Proyecto.model.Materia;
import com.LUMO.LUMO_Proyecto.repository.MateriaRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MateriaService {

    private final MateriaRepository materiaRepository;
    private final MateriaMapper materiaMapper;

    public MateriaService(MateriaRepository materiaRepository, MateriaMapper materiaMapper) {
        this.materiaRepository = materiaRepository;
        this.materiaMapper = materiaMapper;
    }

    public MateriaDTO guardarMateria(MateriaDTO dto) {
        Materia materia = materiaMapper.toEntity(dto);
        Materia guardada = materiaRepository.save(materia);
        return materiaMapper.toDTO(guardada);
    }

    public List<MateriaDTO> listarMaterias() {
        return materiaRepository.findAll().stream()
                .map(materiaMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<MateriaDTO> buscarPorId(String id) {
        return materiaRepository.findById(id).map(materiaMapper::toDTO);
    }

    public void eliminarMateria(String id) {
        materiaRepository.deleteById(id);
    }
}