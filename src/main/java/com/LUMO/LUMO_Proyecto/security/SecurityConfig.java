package com.LUMO.LUMO_Proyecto.config;

import com.LUMO.LUMO_Proyecto.security.JwtRequestFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    private final JwtRequestFilter jwtRequestFilter;

    public SecurityConfig(JwtRequestFilter jwtRequestFilter) {
        this.jwtRequestFilter = jwtRequestFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        // Rutas públicas - no requieren token
                        .requestMatchers("/auth/**").permitAll()
                        .requestMatchers("/usuarios/**").permitAll()    // Temporal para pruebas
                        .requestMatchers("/juegos/**").permitAll()      // Temporal para pruebas
                        .requestMatchers("/estudiantes/**").permitAll() // Temporal para pruebas
                        .requestMatchers("/logros/**").permitAll()      // Temporal para pruebas
                        .requestMatchers("/materias/**").permitAll()    // Temporal para pruebas
                        .requestMatchers("/niveles/**").permitAll()     // Temporal para pruebas
                        .requestMatchers("/preguntas/**").permitAll()   // Temporal para pruebas
                        .requestMatchers("/partidas/**").permitAll()    // Temporal para pruebas
                        .requestMatchers("/respuestas/**").permitAll()  // Temporal para pruebas
                        .requestMatchers("/chat/**").permitAll()        // Temporal para pruebas
                        // Cualquier otra ruta requiere autenticación
                        .anyRequest().authenticated()
                )
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}