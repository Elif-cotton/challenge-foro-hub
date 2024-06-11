package com.foro.forohub.domain.respuesta;

import com.foro.forohub.domain.curso.DatosCurso;
import com.foro.forohub.domain.topico.Topico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Table(name = "respuestas")
@Entity(name = "Respuesta")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Respuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mensaje;
    @ManyToOne
    @JoinColumn(name = "topico_id")
    private Topico topico;
    private LocalDate fechaCreacion;
    private String autor;
    private String solucion;

    public Respuesta(DatosRespuesta respuesta, Topico topico) {
        this.mensaje = respuesta.mensaje();
        this.topico = topico;
        this.fechaCreacion = LocalDate.now(); // Generar la fecha actual al crear la respuesta;
        this.autor = respuesta.autor();
        this.solucion = respuesta.solucion();

    }
}
