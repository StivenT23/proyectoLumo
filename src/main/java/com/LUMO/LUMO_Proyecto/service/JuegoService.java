package com.LUMO.LUMO_Proyecto.service;

import com.LUMO.LUMO_Proyecto.model.Juego;
import com.LUMO.LUMO_Proyecto.repository.JuegoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JuegoService {

    private final JuegoRepository juegoRepository;

    public JuegoService(JuegoRepository juegoRepository) {
        this.juegoRepository = juegoRepository;
    }

    public Juego guardarJuego(Juego juego) {
        return juegoRepository.save(juego);
    }

    public List<Juego> listarJuegos() {
        return juegoRepository.findAll();
    }

    public Optional<Juego> buscarPorId(String id) {
        return juegoRepository.findById(id);
    }

    public void eliminarJuego(String id) {
        juegoRepository.deleteById(id);
    }
}