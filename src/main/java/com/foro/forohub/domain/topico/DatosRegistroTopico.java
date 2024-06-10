package com.foro.forohub.domain.topico;

import com.foro.forohub.domain.curso.DatosCurso;
import com.foro.forohub.domain.respuesta.DatosRespuesta;

public record DatosRegistroTopico(
        String titulo,
        String mensaje,
        String fechaCreacion,
        Status status,
        String autor,
        DatosCurso curso,
        DatosRespuesta respuestas
) {
}
