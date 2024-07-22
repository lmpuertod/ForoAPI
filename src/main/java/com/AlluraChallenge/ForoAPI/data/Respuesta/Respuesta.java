package com.AlluraChallenge.ForoAPI.data.Respuesta;

import com.AlluraChallenge.ForoAPI.data.Topico.Topico;
import com.AlluraChallenge.ForoAPI.data.Usuario.Usuario;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@EqualsAndHashCode(of = "id")
@Entity
@Table(name="respuestas")
public class Respuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="mensaje")
    private String mensaje;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topico_id")
    private Topico topico;

    @Column(name="fecha_creacion")
    private Timestamp fechaCreacion = new Timestamp(System.currentTimeMillis());

    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autor_id")
    private Usuario autor;
}
