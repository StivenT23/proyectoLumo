package com.LUMO.LUMO_Proyecto.repository;

import com.LUMO.LUMO_Proyecto.model.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {
}