package com.AlluraChallenge.ForoAPI.data.Usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UsuarioRegistroDTO(
        @NotBlank
        String nombre,
        @Email
        String email,
        @NotBlank
        @Size(min = 10)
        String password
) {}
