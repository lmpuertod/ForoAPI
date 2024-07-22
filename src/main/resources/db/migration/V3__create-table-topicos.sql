CREATE TABLE topicos(
    id serial,
    titulo varchar(300) NOT NULL,
    mensaje text NOT NULL,
    status status DEFAULT 'activo',
    autor_id integer NOT NULL,
    fecha_creacion TIMESTAMP NOT NULL,
    curso varchar(300),
    PRIMARY KEY(id),

    CONSTRAINT fk_autor
    FOREIGN KEY(autor_id)
    REFERENCES usuarios(id)
    ON DELETE SET NULL


);

