package com.foro.forohub.domain.topico;

import com.foro.forohub.domain.curso.DatosCurso;
import com.foro.forohub.domain.respuesta.DatosRespuesta;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DatosRegistroTopico(
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
       // LocalDate fechaCreacion,
        @NotNull
        Status status,
        @NotBlank
        String autor,
        @NotNull
        @Valid
        DatosCurso curso,
        @NotNull
        @Valid
        DatosRespuesta respuestas
) {
}
