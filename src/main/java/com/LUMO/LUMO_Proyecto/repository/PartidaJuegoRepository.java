package com.LUMO.LUMO_Proyecto.repository;

import com.LUMO.LUMO_Proyecto.model.PartidaJuego;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PartidaJuegoRepository extends MongoRepository<PartidaJuego, String> {

    List<PartidaJuego> findByEstudianteId(String estudianteId);
    List<PartidaJuego> findByJuegoId(String juegoId);
}