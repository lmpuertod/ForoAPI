package com.AlluraChallenge.ForoAPI.controllers;


import com.AlluraChallenge.ForoAPI.Services.ConsultarRespuestasService;
import com.AlluraChallenge.ForoAPI.Services.ConsultarTopicosService;
import com.AlluraChallenge.ForoAPI.Services.ConsultarUsuarioService;
import com.AlluraChallenge.ForoAPI.Services.RegistroUsuarioService;
import com.AlluraChallenge.ForoAPI.data.Usuario.Usuario;
import com.AlluraChallenge.ForoAPI.data.Usuario.UsuarioConsultaDTO;
import com.AlluraChallenge.ForoAPI.data.Usuario.UsuarioRegistroDTO;
import com.AlluraChallenge.ForoAPI.data.Usuario.UsuarioRegistroRespuestaDTO;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/v1/usuarios")
public class UsuariosController {

    private final RegistroUsuarioService registroUsuarioService;
    private final ConsultarUsuarioService consultarUsuarioService;
    private final ConsultarTopicosService consultarTopicosService;
    private final ConsultarRespuestasService consultarRespuestasService;

    public UsuariosController(RegistroUsuarioService registroUsuarioService,
                              ConsultarUsuarioService consultarUsuarioService,
                              ConsultarTopicosService consultarTopicosService,
                              ConsultarRespuestasService consultarRespuestasService
    ) {
        this.registroUsuarioService = registroUsuarioService;
        this.consultarUsuarioService = consultarUsuarioService;
        this.consultarTopicosService = consultarTopicosService;
        this.consultarRespuestasService = consultarRespuestasService;
    }

    @PostMapping("/registro")
    public ResponseEntity regitro(@RequestBody @Valid UsuarioRegistroDTO usuario, UriComponentsBuilder uriComponentsBuilder){
        Optional<UsuarioRegistroRespuestaDTO> nuevoUsuario= registroUsuarioService.registrarUsuario(usuario);
        if(nuevoUsuario.isEmpty()){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }else{
            UsuarioRegistroRespuestaDTO usuarioNuevoRespuesta = nuevoUsuario.get();
            URI url = uriComponentsBuilder.path("/v1/usuarios/{id}").buildAndExpand(usuarioNuevoRespuesta.id()).toUri();
            return ResponseEntity.created(url).body(usuarioNuevoRespuesta);
        }

    }

    @GetMapping
    public ResponseEntity obtenerUsuarios(Pageable paginacion){
        return ResponseEntity.ok().body(consultarUsuarioService.obtenerUsuarios(paginacion));
    }

    @GetMapping("/{id}")
    public ResponseEntity obtenerUsuario(@PathVariable Long id){
        Optional<Usuario> usuario = consultarUsuarioService.obtenerUsuarioPorId(id);
            if(usuario.isPresent()){
                return ResponseEntity.ok().body(new UsuarioConsultaDTO(usuario.get()));
            }else{
                return ResponseEntity.notFound().build();
            }
    }

    @GetMapping("/{id}/topicos")
    public ResponseEntity obtenerTopicosPorautorId(@PathVariable Long id, Pageable paginacion){
        Optional<Usuario> usuario = consultarUsuarioService.obtenerUsuarioPorId(id);
        if(usuario.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            Usuario usuarioEncontrado = usuario.get();
            return ResponseEntity.ok().body(
                    consultarTopicosService.obtenerTopicosPorAutorId(
                            usuarioEncontrado.getId(),
                            paginacion
                    )
            );
        }
    }

    @GetMapping("/{id}/respuestas")
    public ResponseEntity obtenerRespuestasPorautorId(@PathVariable Long id, Pageable paginacion){
        Optional<Usuario> usuario = consultarUsuarioService.obtenerUsuarioPorId(id);
        if(usuario.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            Usuario usuarioEncontrado = usuario.get();
            return ResponseEntity.ok().body(
                    consultarRespuestasService.obtenerRespuesasPorAutorId(
                            usuarioEncontrado.getId(),
                            paginacion
                    )
            );
        }
    }


}
