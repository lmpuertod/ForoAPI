CREATE TABLE respuestas(
    id serial,
    mensaje text NOT NULL,
    topico_id integer NOT NULL,
    fecha_creacion TIMESTAMP,
    autor_id integer,

    PRIMARY KEY(id),

    CONSTRAINT fk_topico
    FOREIGN KEY(topico_id)
    REFERENCES topicos(id)
    On DELETE CASCADE,

    CONSTRAINT fk_autor
    FOREIGN KEY(autor_id)
    REFERENCES usuarios(id)
     On DELETE CASCADE
);