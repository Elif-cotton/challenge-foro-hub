package com.foro.forohub.domain.usuario;

import com.foro.forohub.domain.curso.DatosCurso;
import com.foro.forohub.domain.perfil.Perfil;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "usuarios")
@Entity(name = "Usuario")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String correoElectronico;
    private String contrasena;

    @ManyToOne // Relación muchos a uno con Perfil
    @JoinColumn(name = "perfil_id") // Columna que hace referencia al perfil del usuario
    private Perfil perfil;

    public Usuario(DatosRegistroUsuario usuario, Perfil perfil) {
        this.nombre = usuario.nombre();
        this.correoElectronico = usuario.correoElectronico();
        this.contrasena = usuario.contrasena();
        this.perfil = perfil; // Asigna el perfil proporcionado
    }
}
