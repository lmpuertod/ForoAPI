package com.AlluraChallenge.ForoAPI.data.Usuario;

import com.AlluraChallenge.ForoAPI.data.Respuesta.Respuesta;
import com.AlluraChallenge.ForoAPI.data.Topico.TopicoConsultaDTO;
import java.sql.Timestamp;
import java.util.List;

public record UsuarioConsultaDTO(
        Long id,
        String nombre,
        Timestamp fechaRegistro

){
    public UsuarioConsultaDTO(Usuario usuario) {
        this(
                usuario.getId(),
                usuario.getNombre(),
                usuario.getFechaRegistro()
        );
    }
}
