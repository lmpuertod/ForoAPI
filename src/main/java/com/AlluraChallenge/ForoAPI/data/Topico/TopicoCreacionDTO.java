package com.AlluraChallenge.ForoAPI.data.Topico;

import com.AlluraChallenge.ForoAPI.data.Enums.StatusTopico;
import com.AlluraChallenge.ForoAPI.data.Usuario.Usuario;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;
import java.sql.Timestamp;

public record TopicoCreacionDTO(

        @NotBlank
        String titulo,

        @NotBlank
        String mensaje,

        @NotBlank
        @DecimalMin("0")
        Long autorId,
        String curso

) {}
