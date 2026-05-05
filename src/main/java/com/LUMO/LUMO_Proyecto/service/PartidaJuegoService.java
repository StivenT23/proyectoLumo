package com.LUMO.LUMO_Proyecto.service;

import com.LUMO.LUMO_Proyecto.dto.PartidaJuegoDTO;
import com.LUMO.LUMO_Proyecto.mapper.PartidaJuegoMapper;
import com.LUMO.LUMO_Proyecto.model.PartidaJuego;
import com.LUMO.LUMO_Proyecto.repository.PartidaJuegoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PartidaJuegoService {

    private final PartidaJuegoRepository partidaJuegoRepository;
    private final PartidaJuegoMapper partidaJuegoMapper;

    public PartidaJuegoService(PartidaJuegoRepository partidaJuegoRepository,
                               PartidaJuegoMapper partidaJuegoMapper) {
        this.partidaJuegoRepository = partidaJuegoRepository;
        this.partidaJuegoMapper = partidaJuegoMapper;
    }

    public PartidaJuegoDTO guardarPartida(PartidaJuegoDTO dto) {
        PartidaJuego partida = partidaJuegoMapper.toEntity(dto);
        PartidaJuego guardada = partidaJuegoRepository.save(partida);
        return partidaJuegoMapper.toDTO(guardada);
    }

    public List<PartidaJuegoDTO> listarPartidas() {
        return partidaJuegoRepository.findAll().stream()
                .map(partidaJuegoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<PartidaJuegoDTO> buscarPorId(String id) {
        return partidaJuegoRepository.findById(id)
                .map(partidaJuegoMapper::toDTO);
    }

    public List<PartidaJuegoDTO> buscarPorEstudiante(String estudianteId) {
        // Este método es muy útil para reportes
        return partidaJuegoRepository.findByEstudianteId(estudianteId).stream()
                .map(partidaJuegoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public void eliminarPartida(String id) {
        partidaJuegoRepository.deleteById(id);
    }
}