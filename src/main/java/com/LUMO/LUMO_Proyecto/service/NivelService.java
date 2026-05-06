package com.LUMO.LUMO_Proyecto.service;

import com.LUMO.LUMO_Proyecto.dto.NivelDTO;
import com.LUMO.LUMO_Proyecto.mapper.NivelMapper;
import com.LUMO.LUMO_Proyecto.model.Nivel;
import com.LUMO.LUMO_Proyecto.repository.NivelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NivelService {

    private final NivelRepository nivelRepository;
    private final NivelMapper nivelMapper;

    public NivelService(NivelRepository nivelRepository, NivelMapper nivelMapper) {
        this.nivelRepository = nivelRepository;
        this.nivelMapper = nivelMapper;
    }

    public NivelDTO guardarNivel(NivelDTO dto) {
        Nivel nivel = nivelMapper.toEntity(dto);
        return nivelMapper.toDTO(nivelRepository.save(nivel));
    }

    public List<NivelDTO> listarNiveles() {
        return nivelRepository.findAll().stream()
                .map(nivelMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<NivelDTO> buscarPorId(String id) {
        return nivelRepository.findById(id).map(nivelMapper::toDTO);
    }

    public NivelDTO actualizarNivel(String id, NivelDTO dto) {
        return nivelRepository.findById(id)
                .map(existente -> {
                    Nivel actualizado = nivelMapper.toEntity(dto);
                    actualizado.setId(id);
                    return nivelMapper.toDTO(nivelRepository.save(actualizado));
                })
                .orElseThrow(() -> new RuntimeException("Nivel no encontrado con id: " + id));
    }

    public void eliminarNivel(String id) {
        nivelRepository.deleteById(id);
    }
}