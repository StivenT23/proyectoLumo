package com.LUMO.LUMO_Proyecto.service;

import com.LUMO.LUMO_Proyecto.dto.EstudianteDTO;
import com.LUMO.LUMO_Proyecto.dto.EstudianteResponseDTO;
import com.LUMO.LUMO_Proyecto.mapper.EstudianteMapper;
import com.LUMO.LUMO_Proyecto.model.Estudiante;
import com.LUMO.LUMO_Proyecto.model.Usuario;
import com.LUMO.LUMO_Proyecto.repository.EstudianteRepository;
import com.LUMO.LUMO_Proyecto.repository.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EstudianteService {

    private final EstudianteRepository estudianteRepository;
    private final UsuarioRepository usuarioRepository;
    private final EstudianteMapper estudianteMapper;
    private final PasswordEncoder passwordEncoder;   // ← Agregado

    public EstudianteService(EstudianteRepository estudianteRepository,
                             UsuarioRepository usuarioRepository,
                             EstudianteMapper estudianteMapper,
                             PasswordEncoder passwordEncoder) {   // ← Inyectado
        this.estudianteRepository = estudianteRepository;
        this.usuarioRepository = usuarioRepository;
        this.estudianteMapper = estudianteMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public EstudianteResponseDTO registrarEstudiante(EstudianteDTO dto, String padreId) {
        // Crear Usuario
        Usuario usuario = new Usuario();
        usuario.setCodigoUsuario("usr_" + System.currentTimeMillis());
        usuario.setNombres(dto.getNombres());
        usuario.setApellidos(dto.getApellidos() != null ? dto.getApellidos() : "");
        usuario.setCorreo(dto.getCorreo());
        usuario.setPassword(passwordEncoder.encode("123456")); // Encriptado
        usuario.setRol("ESTUDIANTE");
        usuario.setFechaRegistro(new Date());
        usuario.setEstado(true);

        Usuario usuarioGuardado = usuarioRepository.save(usuario);

        // Crear Estudiante
        Estudiante estudiante = estudianteMapper.toEntity(dto);
        estudiante.setUsuarioId(usuarioGuardado.getCodigoUsuario());
        estudiante.setPadreId(padreId);
        estudiante.setPuntosAcumulados(0);
        estudiante.setNivelActual("Nivel 1 - Principiante");

        Estudiante estudianteGuardado = estudianteRepository.save(estudiante);

        return construirResponse(usuarioGuardado, estudianteGuardado);
    }

    private EstudianteResponseDTO convertirAResponse(Estudiante est) {
        if (est == null) return null;

        String usuarioIdRef = est.getUsuarioId();
        Usuario usuario = null;

        if (usuarioIdRef != null && !usuarioIdRef.isBlank()) {
            usuario = usuarioRepository.findByCodigoUsuario(usuarioIdRef).orElse(null);
        }

        if (usuario == null) {
            usuario = new Usuario();
        }

        return construirResponse(usuario, est);
    }

    private EstudianteResponseDTO construirResponse(Usuario u, Estudiante est) {
        return new EstudianteResponseDTO(
                u.getCodigoUsuario(),
                u.getNombres(),
                u.getApellidos(),
                u.getCorreo(),
                u.getRol(),
                est.getId(),
                est.getEdad(),
                est.getNivelEscolar(),
                est.getDiagnosticoTDAH(),
                est.getFechaNacimiento(),
                est.getPadreId(),
                est.getDocenteId(),
                est.getPuntosAcumulados(),
                est.getNivelActual()
        );
    }

    // Los demás métodos (listar, buscarPorPadre, etc.) se mantienen igual
    public List<EstudianteResponseDTO> listarEstudiantes() {
        return estudianteRepository.findAll().stream()
                .map(this::convertirAResponse)
                .collect(Collectors.toList());
    }

    public Optional<EstudianteResponseDTO> buscarPorId(String id) {
        return estudianteRepository.findById(id).map(this::convertirAResponse);
    }

    public List<EstudianteResponseDTO> buscarPorPadre(String padreId) {
        return estudianteRepository.findByPadreId(padreId).stream()
                .map(this::convertirAResponse).collect(Collectors.toList());
    }

    public List<EstudianteResponseDTO> buscarPorDocente(String docenteId) {
        return estudianteRepository.findByDocenteId(docenteId).stream()
                .map(this::convertirAResponse).collect(Collectors.toList());
    }
}