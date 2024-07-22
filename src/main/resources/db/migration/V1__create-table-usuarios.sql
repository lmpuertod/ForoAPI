CREATE TABLE usuarios(
    id SERIAL,
    nombre varchar(50) NOT NULL,
    email varchar(50) NOT NULL,
    password varchar(300) NOT NULL,
    fecha_registro TIMESTAMP NOT NULL,
    PRIMARY KEY(id)
);