package com.AlluraChallenge.ForoAPI.repositories;

import com.AlluraChallenge.ForoAPI.data.Respuesta.Respuesta;
import com.AlluraChallenge.ForoAPI.data.Respuesta.RespuestaConsultaDTO;
import com.AlluraChallenge.ForoAPI.data.Usuario.Usuario;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RespuestaRepository extends JpaRepository<Respuesta, Long> {
    Slice<Respuesta> findByAutor_Id(Long id, Pageable paginacion);
}
