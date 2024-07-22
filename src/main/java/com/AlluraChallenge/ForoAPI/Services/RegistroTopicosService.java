package com.AlluraChallenge.ForoAPI.Services;

import com.AlluraChallenge.ForoAPI.data.Topico.TopicoConsultaDTO;
import com.AlluraChallenge.ForoAPI.repositories.TopicoRepository;
import com.AlluraChallenge.ForoAPI.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegistroTopicosService {
    private final UsuarioRepository repository;

    public RegistroTopicosService(UsuarioRepository repository) {
        this.repository = repository;
    }
}
