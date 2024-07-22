package com.AlluraChallenge.ForoAPI.Services;

import com.AlluraChallenge.ForoAPI.data.Respuesta.RespuestaConsultaDTO;
import com.AlluraChallenge.ForoAPI.repositories.RespuestaRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

@Service
public class ConsultarRespuestasService {

    private final RespuestaRepository respuestaRepository;

    public ConsultarRespuestasService(RespuestaRepository respuestaRepository) {
        this.respuestaRepository = respuestaRepository;
    }
    public Slice<RespuestaConsultaDTO> obtenerRespuesasPorAutorId(Long id, Pageable paginacion){
        return respuestaRepository
                .findByAutor_Id(id, paginacion)
                .map(RespuestaConsultaDTO::new);
    }
}
