package com.LUMO.LUMO_Proyecto.service;

import com.LUMO.LUMO_Proyecto.dto.EstudianteDTO;
import com.LUMO.LUMO_Proyecto.dto.EstudianteResponseDTO;
import com.LUMO.LUMO_Proyecto.mapper.EstudianteMapper;
import com.LUMO.LUMO_Proyecto.model.Estudiante;
import com.LUMO.LUMO_Proyecto.model.Usuario;
import com.LUMO.LUMO_Proyecto.repository.EstudianteRepository;
import com.LUMO.LUMO_Proyecto.repository.UsuarioRepository;
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

    public EstudianteService(EstudianteRepository estudianteRepository,
                             UsuarioRepository usuarioRepository,
                             EstudianteMapper estudianteMapper) {
        this.estudianteRepository = estudianteRepository;
        this.usuarioRepository = usuarioRepository;
        this.estudianteMapper = estudianteMapper;
    }

    // Registrar estudiante (llamado por el padre)
    public EstudianteResponseDTO registrarEstudiante(EstudianteDTO dto, String padreId) {

        // 1. Crear Usuario del estudiante
        Usuario usuarioEstudiante = new Usuario();
        usuarioEstudiante.setCorreo(dto.getCorreo() != null
                ? dto.getCorreo()
                : "estudiante" + System.currentTimeMillis() + "@lumo.com");
        usuarioEstudiante.setNombres(dto.getNombres() != null ? dto.getNombres() : "Estudiante");
        usuarioEstudiante.setApellidos(dto.getApellidos() != null ? dto.getApellidos() : "Sin Apellido");
        usuarioEstudiante.setPassword("123456"); // Se encriptará cuando se integre BCrypt
        usuarioEstudiante.setRol("estudiante");
        usuarioEstudiante.setFechaRegistro(new Date());
        usuarioEstudiante.setEstado(true);

        Usuario usuarioGuardado = usuarioRepository.save(usuarioEstudiante);

        // 2. Crear Estudiante vinculado al usuario
        Estudiante estudiante = estudianteMapper.toEntity(dto);
        estudiante.setUsuarioId(usuarioGuardado.getId());
        estudiante.setPadreId(padreId);
        estudiante.setPuntosAcumulados(0);
        estudiante.setNivelActual("Nivel 1");

        Estudiante estudianteGuardado = estudianteRepository.save(estudiante);

        // 3. Retornar respuesta combinada
        return construirResponse(usuarioGuardado, estudianteGuardado);
    }

    // Listar todos los estudiantes
    public List<EstudianteResponseDTO> listarEstudiantes() {
        return estudianteRepository.findAll().stream()
                .map(this::convertirAResponse)
                .collect(Collectors.toList());
    }

    // Buscar por ID — método que faltaba y causaba error en el controller
    public Optional<EstudianteResponseDTO> buscarPorId(String id) {
        return estudianteRepository.findById(id)
                .map(this::convertirAResponse);
    }

    // Buscar estudiantes de un padre específico
    public List<EstudianteResponseDTO> buscarPorPadre(String padreId) {
        return estudianteRepository.findByPadreId(padreId).stream()
                .map(this::convertirAResponse)
                .collect(Collectors.toList());
    }

    // Buscar estudiantes de un docente específico
    public List<EstudianteResponseDTO> buscarPorDocente(String docenteId) {
        return estudianteRepository.findByDocenteId(docenteId).stream()
                .map(this::convertirAResponse)
                .collect(Collectors.toList());
    }

    // Helper: convierte Estudiante a Response buscando su Usuario
    private EstudianteResponseDTO convertirAResponse(Estudiante est) {
        Usuario usuario = usuarioRepository.findById(est.getUsuarioId())
                .orElse(new Usuario());
        return construirResponse(usuario, est);
    }

    // Helper: construye el DTO de respuesta combinado
    private EstudianteResponseDTO construirResponse(Usuario usuario, Estudiante est) {
        return new EstudianteResponseDTO(
                usuario.getId(),
                usuario.getNombres(),
                usuario.getApellidos(),
                usuario.getCorreo(),
                usuario.getRol(),           // ← campo rol agregado
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
}