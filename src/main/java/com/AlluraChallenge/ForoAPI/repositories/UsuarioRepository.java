package com.AlluraChallenge.ForoAPI.repositories;

import com.AlluraChallenge.ForoAPI.data.Usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Boolean existsByNombre(String nombre);
}
