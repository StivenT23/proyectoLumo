package com.LUMO.LUMO_Proyecto.repository;

import com.LUMO.LUMO_Proyecto.model.Pregunta;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PreguntaRepository extends MongoRepository<Pregunta, String> {

    List<Pregunta> findByMateriaId(String materiaId);
}