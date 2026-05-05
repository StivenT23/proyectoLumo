package com.LUMO.LUMO_Proyecto.service;

import com.LUMO.LUMO_Proyecto.dto.ChatMensajeDTO;
import com.LUMO.LUMO_Proyecto.mapper.ChatMensajeMapper;
import com.LUMO.LUMO_Proyecto.model.ChatMensaje;
import com.LUMO.LUMO_Proyecto.repository.ChatMensajeRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChatMensajeService {

    private final ChatMensajeRepository chatRepository;
    private final ChatMensajeMapper chatMapper;

    public ChatMensajeService(ChatMensajeRepository chatRepository, ChatMensajeMapper chatMapper) {
        this.chatRepository = chatRepository;
        this.chatMapper = chatMapper;
    }

    public ChatMensajeDTO guardarMensaje(ChatMensajeDTO dto) {
        ChatMensaje mensaje = chatMapper.toEntity(dto);
        ChatMensaje guardado = chatRepository.save(mensaje);
        return chatMapper.toDTO(guardado);
    }

    public List<ChatMensajeDTO> obtenerMensajesEntreUsuarios(String emisorId, String receptorId) {
        return chatRepository.findByEmisorIdAndReceptorId(emisorId, receptorId).stream()
                .map(chatMapper::toDTO)
                .collect(Collectors.toList());  // Asegúrate de importar Collectors
    }
}