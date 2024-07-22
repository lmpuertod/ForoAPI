package com.AlluraChallenge.ForoAPI.data.Topico;

import com.AlluraChallenge.ForoAPI.data.Respuesta.Respuesta;
import com.AlluraChallenge.ForoAPI.data.Enums.StatusTopico;
import com.AlluraChallenge.ForoAPI.data.Usuario.Usuario;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Getter
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "topicos")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="titulo")
    private String titulo;

    @Column(name="mensaje")
    private String mensaje;

    @Enumerated(EnumType.STRING)
    @Column(name="status")
    private StatusTopico status = StatusTopico.ACTIVO;
    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autor_id")
    private Usuario autor;

    @Column(name="fecha_creacion")
    private final Timestamp fechaCreacion = new Timestamp(System.currentTimeMillis());

    @Column(name="curso")
    private String curso = "Off topic";

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "topico")
    private final List<Respuesta> respuestas = new ArrayList<>();

    public Topico(){}

    public Topico(
            String titulo,
            String mensaje,
            Usuario autor

    ){
        this.titulo = titulo;
        this.mensaje = mensaje;
        autor.addTopico(this);


    }


}
