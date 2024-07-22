package com.AlluraChallenge.ForoAPI.data.Usuario;

import com.AlluraChallenge.ForoAPI.data.Respuesta.Respuesta;
import com.AlluraChallenge.ForoAPI.data.Topico.Topico;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Getter
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="nombre")
    private String nombre;

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    @Column(name="fecha_registro")
    private final Timestamp fechaRegistro = new Timestamp(System.currentTimeMillis());

    @OneToMany(mappedBy = "autor", fetch = FetchType.LAZY)
    private final List<Respuesta> respuestas = new ArrayList<>();

    @OneToMany(mappedBy = "autor", fetch = FetchType.LAZY)
    private final List<Topico> topicos = new ArrayList<>();

    public Usuario(){}

    public Usuario(UsuarioRegistroDTO usuarioRegistro){
        this.nombre = usuarioRegistro.nombre();
        this.email = usuarioRegistro.email();
        this.password = usuarioRegistro.password();

    }



    public void addRespuesta(Respuesta respuesta){
        this.getRespuestas().add(respuesta);
        respuesta.setAutor(this);
    }

    public void removeRespuesta(Respuesta respuesta){
        if(this.getRespuestas().remove(respuesta)){
            respuesta.setAutor(null);
        }
    }

    public void addTopico(Topico topico){
        this.getTopicos().add(topico);
        topico.setAutor(this);
    }

    public void removeTopico(Topico topico){
        if(this.getTopicos().remove(topico)){
            topico.setAutor(null);
        }

    }

}
