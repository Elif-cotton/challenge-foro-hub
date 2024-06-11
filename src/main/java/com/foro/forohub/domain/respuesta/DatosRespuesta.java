package com.foro.forohub.domain.respuesta;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record DatosRespuesta(
        @NotBlank
        String mensaje,
        @NotBlank
        String topico,

        //LocalDate fechaCreacion,
        @NotBlank
        String autor,
        @NotBlank
        String solucion
) {
}
