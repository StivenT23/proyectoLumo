package com.LUMO.LUMO_Proyecto.service;

import com.LUMO.LUMO_Proyecto.model.Usuario;
import com.LUMO.LUMO_Proyecto.repository.UsuarioRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final MongoTemplate mongoTemplate;

    public UsuarioService(UsuarioRepository usuarioRepository, MongoTemplate mongoTemplate) {
        this.usuarioRepository = usuarioRepository;
        this.mongoTemplate = mongoTemplate;
    }

    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> obtenerUsuarios() {
        System.out.println("Base usada por Spring: " + mongoTemplate.getDb().getName());
        System.out.println("Colecciones visibles: " +
                mongoTemplate.getDb().listCollectionNames().into(new ArrayList<>()));

        long totalColeccion = mongoTemplate.getCollection("usuario").countDocuments();
        System.out.println("Documentos directos en colección 'usuarios': " + totalColeccion);

        List<Usuario> usuarios = usuarioRepository.findAll();
        System.out.println("Usuarios encontrados con repository: " + usuarios.size());

        return usuarios;
    }

    public Optional<Usuario> buscarPorId(String id) {
        return usuarioRepository.findById(id);
    }

    public void eliminarUsuario(String id) {
        usuarioRepository.deleteById(id);
    }
}