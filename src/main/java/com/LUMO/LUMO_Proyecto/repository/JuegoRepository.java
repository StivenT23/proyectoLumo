package com.LUMO.LUMO_Proyecto.repository;

import com.LUMO.LUMO_Proyecto.model.Juego;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JuegoRepository extends MongoRepository<Juego, String> {
}