package com.LUMO.LUMO_Proyecto.repository;

import com.LUMO.LUMO_Proyecto.model.LogroEstudiante;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface LogroEstudianteRepository extends MongoRepository<LogroEstudiante, String> {

    List<LogroEstudiante> findByEstudianteId(String estudianteId);
}