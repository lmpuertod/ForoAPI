package com.AlluraChallenge.ForoAPI.data.Respuesta;

import java.sql.Timestamp;

public record RespuestaConsultaDTO(
        Long id,
        String mensaje,
        Long topicoId,
        Timestamp fechaCreacion,
        Long autorId
) {
    public RespuestaConsultaDTO(Respuesta respuesta){
        this(
                respuesta.getId(),
                respuesta.getMensaje(),
                respuesta.getTopico().getId(),
                respuesta.getFechaCreacion(),
                respuesta.getAutor().getId()
        );
    }
}
