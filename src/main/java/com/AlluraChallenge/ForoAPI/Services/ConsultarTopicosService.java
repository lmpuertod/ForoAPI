package com.AlluraChallenge.ForoAPI.Services;

import com.AlluraChallenge.ForoAPI.data.Topico.TopicoConsultaDTO;
import com.AlluraChallenge.ForoAPI.repositories.TopicoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

@Service
public class ConsultarTopicosService {
    private final TopicoRepository repository;

    public ConsultarTopicosService(TopicoRepository repository) {
        this.repository = repository;
    }

    public Slice<TopicoConsultaDTO> obtenerTopicosPorAutorId(Long autorId, Pageable paginacion){
        return repository
                .findByAutor_Id(autorId, paginacion)
                .map(TopicoConsultaDTO::new);
    }

    public Slice<TopicoConsultaDTO> obtenerTopicos(Pageable paginacion){
        return repository.findAll(paginacion).map(TopicoConsultaDTO::new);
    }
}
