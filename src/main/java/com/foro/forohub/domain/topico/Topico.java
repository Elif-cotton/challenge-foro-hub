package com.foro.forohub.domain.topico;

import com.foro.forohub.domain.curso.Curso;
import com.foro.forohub.domain.respuesta.Respuesta;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDate fechaCreacion;
    @Enumerated(EnumType.STRING)
    private Status status;
    private String autor;

    @ManyToOne
    @JoinColumn(name = "curso_id") // columna en la tabla topicos que contiene la clave externa a curso
    private Curso curso;

    @OneToMany(mappedBy = "topico")
    private List<Respuesta> respuestas = new ArrayList<>();

    public Topico(DatosRegistroTopico datosRegistroTopico) {
        this.titulo = datosRegistroTopico.titulo();
        this.mensaje = datosRegistroTopico.mensaje();
        this.fechaCreacion = LocalDate.now(); // Obtener la fecha actual;
        this.status = datosRegistroTopico.status();
        this.autor = datosRegistroTopico.autor();
        this.curso = new Curso(datosRegistroTopico.curso());

        // Crear instancias de Respuesta a partir de DatosRespuesta y agregarlas a la lista de respuestas
        Respuesta respuesta = new Respuesta(datosRegistroTopico.respuestas(), this);
        this.respuestas.add(respuesta);
    }
}
