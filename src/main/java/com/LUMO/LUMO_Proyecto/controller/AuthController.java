package com.LUMO.LUMO_Proyecto.controller;

import com.LUMO.LUMO_Proyecto.model.Usuario;
import com.LUMO.LUMO_Proyecto.repository.UsuarioRepository;
import com.LUMO.LUMO_Proyecto.security.JwtUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthController(UsuarioRepository usuarioRepository,
                          PasswordEncoder passwordEncoder,
                          JwtUtil jwtUtil) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    // ──────────────────────────────────────────
    // POST /auth/register
    // Body: { "correo", "password", "nombres", "apellidos", "rol" }
    // ──────────────────────────────────────────
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Map<String, String> body) {
        String correo = body.get("correo");
        String password = body.get("password");
        String nombres = body.get("nombres");
        String apellidos = body.get("apellidos");
        String rol = body.get("rol");

        // Validar campos requeridos
        if (correo == null || password == null || nombres == null || rol == null) {
            return ResponseEntity.badRequest()
                    .body(Map.of("error", "correo, password, nombres y rol son obligatorios"));
        }

        // Verificar que el correo no esté registrado
        if (usuarioRepository.findByCorreo(correo).isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(Map.of("error", "El correo ya está registrado"));
        }

        // Crear y guardar usuario
        Usuario usuario = new Usuario();
        usuario.setCorreo(correo);
        usuario.setPassword(passwordEncoder.encode(password));
        usuario.setNombres(nombres);
        usuario.setApellidos(apellidos != null ? apellidos : "");
        usuario.setRol(rol);
        usuario.setFechaRegistro(new Date());
        usuario.setEstado(true);

        Usuario guardado = usuarioRepository.save(usuario);

        // Generar token
        String token = jwtUtil.generateToken(guardado.getCorreo(), guardado.getRol());

        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("token", token);
        respuesta.put("id", guardado.getId());
        respuesta.put("correo", guardado.getCorreo());
        respuesta.put("nombres", guardado.getNombres());
        respuesta.put("rol", guardado.getRol());
        respuesta.put("mensaje", "Usuario registrado exitosamente");

        return ResponseEntity.status(HttpStatus.CREATED).body(respuesta);
    }

    // ──────────────────────────────────────────
    // POST /auth/login
    // Body: { "correo", "password" }
    // ──────────────────────────────────────────
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> body) {
        String correo = body.get("correo");
        String password = body.get("password");

        if (correo == null || password == null) {
            return ResponseEntity.badRequest()
                    .body(Map.of("error", "correo y password son obligatorios"));
        }

        // Buscar usuario por correo
        Usuario usuario = usuarioRepository.findByCorreo(correo)
                .orElse(null);

        if (usuario == null || !passwordEncoder.matches(password, usuario.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("error", "Credenciales incorrectas"));
        }

        if (!Boolean.TRUE.equals(usuario.getEstado())) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body(Map.of("error", "Usuario inactivo"));
        }

        // Generar token JWT
        String token = jwtUtil.generateToken(usuario.getCorreo(), usuario.getRol());

        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("token", token);
        respuesta.put("id", usuario.getId());
        respuesta.put("correo", usuario.getCorreo());
        respuesta.put("nombres", usuario.getNombres());
        respuesta.put("apellidos", usuario.getApellidos());
        respuesta.put("rol", usuario.getRol());

        return ResponseEntity.ok(respuesta);
    }
}