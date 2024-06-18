package com.foro.forohub.domain.topico;

import com.foro.forohub.domain.curso.Curso;
import com.foro.forohub.domain.curso.DatosCurso;
import com.foro.forohub.domain.respuesta.DatosRespuesta;

public record DatosRespuestaTopico(
                Long id,
                String titulo,
                String mensaje,
                String autor,
                DatosCurso curso
                ) {

}
