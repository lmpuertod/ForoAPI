package com.AlluraChallenge.ForoAPI.controllers;

import com.AlluraChallenge.ForoAPI.Services.ConsultarTopicosService;
import com.AlluraChallenge.ForoAPI.Services.RegistroTopicosService;
import com.AlluraChallenge.ForoAPI.data.Topico.TopicoConsultaDTO;
import com.AlluraChallenge.ForoAPI.data.Topico.TopicoCreacionDTO;
import com.AlluraChallenge.ForoAPI.repositories.TopicoRepository;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/v1/topicos")
public class TopicosController {

    private final ConsultarTopicosService topicoService;
    private final RegistroTopicosService registroTopicosService;

    public TopicosController(
            ConsultarTopicosService topicoService,
            RegistroTopicosService registroTopicosService
    )
    {
        this.topicoService = topicoService;
        this.registroTopicosService = registroTopicosService;
    }

    @GetMapping
    public HttpEntity<Slice<TopicoConsultaDTO>> odtenerTopicos(Pageable paginacion){
        return ResponseEntity.ok(topicoService.obtenerTopicos(paginacion));
    }



}
