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
    private Boolean status;
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
        this.status = true;  //activo
        this.autor = datosRegistroTopico.autor();
        this.curso = new Curso(datosRegistroTopico.curso());

        // Crear instancias de Respuesta a partir de DatosRespuesta y agregarlas a la lista de respuestas
        Respuesta respuesta = new Respuesta(datosRegistroTopico.respuesta(), this);
        this.respuestas.add(respuesta);
    }

    public void actualizarDatos(DatosActualizarTopico datosActualizarTopico) {
        if (datosActualizarTopico.titulo() != null) {
            this.titulo = datosActualizarTopico.titulo();
        }
        if (datosActualizarTopico.mensaje() != null) {
            this.mensaje = datosActualizarTopico.mensaje();
        }
    }

    public void desactivarTopico() {
        this.status = false;
    }
}
