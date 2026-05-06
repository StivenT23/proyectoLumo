package com.LUMO.LUMO_Proyecto.repository;

import com.LUMO.LUMO_Proyecto.model.RespuestaEstudiante;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RespuestaEstudianteRepository extends MongoRepository<RespuestaEstudiante, String> {

    List<RespuestaEstudiante> findByEstudianteId(String estudianteId);
    List<RespuestaEstudiante> findByPartidaId(String partidaId);
}