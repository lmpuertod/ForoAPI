package com.AlluraChallenge.ForoAPI.Services;

import com.AlluraChallenge.ForoAPI.data.Usuario.Usuario;
import com.AlluraChallenge.ForoAPI.data.Usuario.UsuarioRegistroDTO;
import com.AlluraChallenge.ForoAPI.data.Usuario.UsuarioRegistroRespuestaDTO;
import com.AlluraChallenge.ForoAPI.repositories.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.net.URI;
import java.util.Optional;

import org.springframework.web.util.UriComponentsBuilder;

@Service
public class RegistroUsuarioService {

    private final PasswordEncoder passwordEncoder;
    private final UsuarioRepository usuarioRepository;

    public RegistroUsuarioService(PasswordEncoder passwordEncoder, UsuarioRepository usuarioRepository){
        this.passwordEncoder = passwordEncoder;
        this.usuarioRepository = usuarioRepository;
    }

    public Optional<UsuarioRegistroRespuestaDTO> registrarUsuario(UsuarioRegistroDTO usuarioRegistro){

        if(usuarioRepository.existsByNombre(usuarioRegistro.nombre())){
            return Optional.empty();
        }else{
            Usuario nuevoUsuario = usuarioRepository.save(new Usuario(
                    new UsuarioRegistroDTO(
                            usuarioRegistro.nombre(),
                            usuarioRegistro.email(),
                            passwordEncoder.encode(usuarioRegistro.password())
                    )
            ));
            return Optional.of(new UsuarioRegistroRespuestaDTO(nuevoUsuario));
        }
    }


}
