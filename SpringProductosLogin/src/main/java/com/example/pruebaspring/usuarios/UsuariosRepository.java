package com.example.pruebaspring.usuarios;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface UsuariosRepository extends CrudRepository<Usuario, Integer> {
    Optional<Usuario> findByEmailAndPassword(String email, String password);
}
