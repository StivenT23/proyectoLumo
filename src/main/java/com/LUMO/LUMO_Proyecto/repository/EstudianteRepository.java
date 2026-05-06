package com.LUMO.LUMO_Proyecto.repository;

import com.LUMO.LUMO_Proyecto.model.Estudiante;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EstudianteRepository extends MongoRepository<Estudiante, String> {

    List<Estudiante> findByUsuarioId(String usuarioId);
    List<Estudiante> findByDocenteId(String docenteId);
    List<Estudiante> findByPadreId(String padreId);
}