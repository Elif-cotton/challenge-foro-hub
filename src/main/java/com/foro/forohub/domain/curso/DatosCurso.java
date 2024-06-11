package com.foro.forohub.domain.curso;

import jakarta.validation.constraints.NotBlank;

public record DatosCurso(
        @NotBlank
        String nombre,
        @NotBlank
        Categoria categoria) {

        public DatosCurso(Curso curso) {
                this(curso.getNombre(), curso.getCategoria());
        }
}
