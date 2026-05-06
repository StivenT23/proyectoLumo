package com.LUMO.LUMO_Proyecto.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey; // Importación necesaria para versiones nuevas
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class JwtUtil {

    // La clave debe ser lo suficientemente larga para HMAC-SHA
    private static final String SECRET_KEY = "LUMO2026_PROYECTO_TDAH_POPAYAN_CAUCA_2026_KEY_256BITS_LONG_ENOUGH";
    private static final long EXPIRATION_TIME = 86400000; // 24 horas

    // Cambiamos el tipo de retorno de Key a SecretKey
    private SecretKey getSigningKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
    }

    public String generateToken(String username, String rol) {
        return Jwts.builder()
                .subject(username)
                .claim("rol", rol)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(getSigningKey()) // Ahora reconoce el SecretKey sin problemas
                .compact();
    }

    public String extractUsername(String token) {
        return Jwts.parser()
                .verifyWith(getSigningKey()) // Requiere SecretKey
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }

    public String extractRol(String token) {
        return Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .get("rol", String.class);
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser()
                    .verifyWith(getSigningKey())
                    .build()
                    .parseSignedClaims(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            System.out.println("Token inválido: " + e.getMessage());
            return false;
        }
    }
}