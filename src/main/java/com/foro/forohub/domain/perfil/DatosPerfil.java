package com.foro.forohub.domain.perfil;

import jakarta.validation.constraints.NotBlank;

public record DatosPerfil(
        @NotBlank
        String nombre
) {
}
