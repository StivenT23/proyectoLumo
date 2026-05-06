package com.LUMO.LUMO_Proyecto.repository;

import com.LUMO.LUMO_Proyecto.model.ChatMensaje;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ChatMensajeRepository extends MongoRepository<ChatMensaje, String> {

    List<ChatMensaje> findByEmisorIdAndReceptorId(String emisorId, String receptorId);
    List<ChatMensaje> findByEmisorId(String emisorId);
}