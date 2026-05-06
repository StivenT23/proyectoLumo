package com.LUMO.LUMO_Proyecto.controller;

import com.LUMO.LUMO_Proyecto.dto.ChatMensajeDTO;
import com.LUMO.LUMO_Proyecto.service.ChatMensajeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chat")
@CrossOrigin("*")
public class ChatMensajeController {

    private final ChatMensajeService chatService;

    public ChatMensajeController(ChatMensajeService chatService) {
        this.chatService = chatService;
    }

    @PostMapping
    public ResponseEntity<ChatMensajeDTO> enviarMensaje(@RequestBody ChatMensajeDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(chatService.guardarMensaje(dto));
    }

    @GetMapping("/conversacion")
    public ResponseEntity<List<ChatMensajeDTO>> obtenerConversacion(
            @RequestParam String emisorId,
            @RequestParam String receptorId) {
        return ResponseEntity.ok(chatService.obtenerMensajesEntreUsuarios(emisorId, receptorId));
    }
}
