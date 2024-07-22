package com.AlluraChallenge.ForoAPI.Services;

import com.AlluraChallenge.ForoAPI.data.Usuario.Usuario;
import com.AlluraChallenge.ForoAPI.data.Usuario.UsuarioConsultaDTO;
import com.AlluraChallenge.ForoAPI.repositories.UsuarioRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ConsultarUsuarioService {
    private final UsuarioRepository usuarioRepository;

    public ConsultarUsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Slice<UsuarioConsultaDTO> obtenerUsuarios(Pageable paginacion){
        return usuarioRepository.findAll(paginacion).map(UsuarioConsultaDTO::new);
    }

    public Optional<Usuario> obtenerUsuarioPorId(Long id){
        return usuarioRepository.findById(id);

    }
}
