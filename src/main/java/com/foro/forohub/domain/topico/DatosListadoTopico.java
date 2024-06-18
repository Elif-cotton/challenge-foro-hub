package com.foro.forohub.domain.topico;

import com.foro.forohub.domain.curso.DatosCurso;
import com.foro.forohub.domain.respuesta.DatosRespuesta;

import java.time.LocalDate;

public record DatosListadoTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDate fechaCreacion,
        String autor,
        DatosCurso curso

) {

    public DatosListadoTopico(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion(), topico.getAutor(),
                new DatosCurso(topico.getCurso()));
    }
}
