package com.AlluraChallenge.ForoAPI.data.Topico;

import com.AlluraChallenge.ForoAPI.data.Enums.StatusTopico;

import java.sql.Timestamp;

public record TopicoConsultaDTO(
        Long id,
        String titulo,
        String mensaje,
        StatusTopico status,
        Long autorId,
        Timestamp fechaCreacion,
        String curso

)
{
    public TopicoConsultaDTO(Topico topico){
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getStatus(),
                topico.getAutor().getId(),
                topico.getFechaCreacion(),
                topico.getCurso()
        );

    }
}
