package com.LUMO.LUMO_Proyecto.service;

import com.LUMO.LUMO_Proyecto.dto.JuegoDTO;
import com.LUMO.LUMO_Proyecto.mapper.JuegoMapper;
import com.LUMO.LUMO_Proyecto.model.Juego;
import com.LUMO.LUMO_Proyecto.repository.JuegoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JuegoService {

    private final JuegoRepository juegoRepository;
    private final JuegoMapper juegoMapper;

    public JuegoService(JuegoRepository juegoRepository, JuegoMapper juegoMapper) {
        this.juegoRepository = juegoRepository;
        this.juegoMapper = juegoMapper;
    }

    public JuegoDTO guardarJuego(JuegoDTO dto) {
        Juego juego = juegoMapper.toEntity(dto);
        Juego juegoGuardado = juegoRepository.save(juego);
        return juegoMapper.toDTO(juegoGuardado);
    }

    public List<JuegoDTO> listarJuegos() {
        List<Juego> juegos = juegoRepository.findAll();
        return juegos.stream()
                .map(juegoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<JuegoDTO> buscarPorId(String id) {
        return juegoRepository.findById(id)
                .map(juegoMapper::toDTO);
    }

    public void eliminarJuego(String id) {
        juegoRepository.deleteById(id);
    }

    public JuegoDTO actualizarJuego(String id, JuegoDTO dto) {
        return juegoRepository.findById(id)
                .map(juegoExistente -> {
                    Juego juegoActualizado = juegoMapper.toEntity(dto);
                    juegoActualizado.setId(id);
                    Juego guardado = juegoRepository.save(juegoActualizado);
                    return juegoMapper.toDTO(guardado);
                })
                .orElseThrow(() -> new RuntimeException("Juego no encontrado"));
    }
}