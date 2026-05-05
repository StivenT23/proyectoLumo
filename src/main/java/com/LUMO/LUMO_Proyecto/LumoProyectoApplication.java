package com.LUMO.LUMO_Proyecto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Map;

@SpringBootApplication
public class LumoProyectoApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(LumoProyectoApplication.class);

        app.setDefaultProperties(Map.of(
                "spring.data.mongodb.uri", "mongodb://localhost:27017/proyectoLUMO",
                "server.port", "8081"
        ));

        app.run(args);
    }
}