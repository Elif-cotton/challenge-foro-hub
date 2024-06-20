package com.foro.forohub.domain.usuario;

import com.foro.forohub.domain.perfil.Perfil;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroUsuario(
        @NotBlank
        String login,
        @NotBlank
        @Email
        String correoElectronico,
        @NotBlank
        String clave,
        @NotNull(message = "El perfil no puede ser nulo")
        @Valid
        Perfil perfiles
) {
}
