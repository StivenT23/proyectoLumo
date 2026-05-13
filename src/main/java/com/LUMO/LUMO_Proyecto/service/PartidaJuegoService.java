package com.LUMO.LUMO_Proyecto.service;

import com.LUMO.LUMO_Proyecto.dto.PartidaJuegoDTO;
import com.LUMO.LUMO_Proyecto.mapper.PartidaJuegoMapper;
import com.LUMO.LUMO_Proyecto.model.PartidaJuego;
import com.LUMO.LUMO_Proyecto.repository.PartidaJuegoRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PartidaJuegoService {

    private final PartidaJuegoRepository partidaRepository;
    private final PartidaJuegoMapper partidaMapper;

    public PartidaJuegoService(PartidaJuegoRepository partidaRepository,
                               PartidaJuegoMapper partidaMapper) {
        this.partidaRepository = partidaRepository;
        this.partidaMapper = partidaMapper;
    }

    public PartidaJuegoDTO guardarPartida(PartidaJuegoDTO dto) {
        PartidaJuego partida = partidaMapper.toEntity(dto);
        partida.setFechaInicio(new Date()); // Registrar hora de inicio

        if (partida.getFechaFin() == null) {
            partida.setFechaFin(new Date());
        }

        PartidaJuego guardada = partidaRepository.save(partida);
        return partidaMapper.toDTO(guardada);
    }

    public List<PartidaJuegoDTO> listarPartidas() {
        return partidaRepository.findAll().stream()
                .map(partidaMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<PartidaJuegoDTO> buscarPorEstudiante(String estudianteId) {
        return partidaRepository.findByEstudianteId(estudianteId).stream()
                .map(partidaMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<PartidaJuegoDTO> buscarPorId(String id) {
        return partidaRepository.findById(id).map(partidaMapper::toDTO);
    }

    public void eliminarPartida(String id) {
        partidaRepository.deleteById(id);
    }
}