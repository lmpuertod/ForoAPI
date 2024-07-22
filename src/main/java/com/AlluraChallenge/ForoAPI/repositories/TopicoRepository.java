package com.AlluraChallenge.ForoAPI.repositories;

import com.AlluraChallenge.ForoAPI.data.Topico.Topico;
import com.AlluraChallenge.ForoAPI.data.Usuario.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {
    Page<Topico> findByAutor_Id(Long id, Pageable paginacion);

}
