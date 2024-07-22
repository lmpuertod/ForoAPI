package com.AlluraChallenge.ForoAPI.data.Usuario;

import java.sql.Timestamp;

public record UsuarioRegistroRespuestaDTO(
        Long id,
        String nombre,
        Timestamp fechaRegistro
)
{
    public UsuarioRegistroRespuestaDTO(Usuario usuario){
        this(
                usuario.getId(),
                usuario.getNombre(),
                usuario.getFechaRegistro()
        );
    }
}
