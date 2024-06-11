package com.foro.forohub.domain.usuario;

import com.foro.forohub.domain.perfil.Perfil;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroUsuario(
        @NotBlank
        String nombre,
        @NotBlank
        @Email
        String correoElectronico,
        @NotBlank
        String contrasena,
        @NotNull(message = "El perfil no puede ser nulo")
        @Valid
        Perfil perfiles
) {
}
