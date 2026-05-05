package com.LUMO.LUMO_Proyecto.mapper;

import com.LUMO.LUMO_Proyecto.dto.ChatMensajeDTO;
import com.LUMO.LUMO_Proyecto.model.ChatMensaje;
import org.springframework.stereotype.Component;

@Component
public class ChatMensajeMapper {

    public ChatMensajeDTO toDTO(ChatMensaje chatMensaje) {
        if (chatMensaje == null) return null;

        return new ChatMensajeDTO(
                chatMensaje.getId(),
                chatMensaje.getEmisorId(),
                chatMensaje.getReceptorId(),
                chatMensaje.getMensaje(),
                chatMensaje.getFechaEnvio(),
                chatMensaje.getLeido()
        );
    }

    public ChatMensaje toEntity(ChatMensajeDTO dto) {
        if (dto == null) return null;

        return new ChatMensaje(
                dto.getId(),
                dto.getEmisorId(),
                dto.getReceptorId(),
                dto.getMensaje(),
                dto.getFechaEnvio(),
                dto.getLeido()
        );
    }
}