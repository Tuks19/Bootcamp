CREATE TABLE public.usuarios (
    id_usuario SERIAL PRIMARY KEY,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    fecha_union TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    user_name VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE public.posteos (
    id_posteo SERIAL PRIMARY KEY,
    id_usuario INTEGER NOT NULL,
    titulo VARCHAR(200) NOT NULL,
    cant_comentarios INTEGER DEFAULT 0,
    fecha_posteo TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    contenido TEXT NOT NULL,
    me_gusta INTEGER DEFAULT 0,
    re_post INTEGER DEFAULT 0
);

CREATE TABLE public.comentarios (
    id_comentario SERIAL PRIMARY KEY,
    id_usuario INTEGER NOT NULL,
    id_posteo INTEGER NOT NULL,
    fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    contenido TEXT NOT NULL
);

-- Foreign Keys
ALTER TABLE public.posteos ADD CONSTRAINT usuarios_posteos_fk
FOREIGN KEY (id_usuario)
REFERENCES public.usuarios (id_usuario)
ON DELETE CASCADE
ON UPDATE CASCADE;

ALTER TABLE public.comentarios ADD CONSTRAINT usuarios_comentarios_fk
FOREIGN KEY (id_usuario)
REFERENCES public.usuarios (id_usuario)
ON DELETE CASCADE
ON UPDATE CASCADE;

ALTER TABLE public.comentarios ADD CONSTRAINT posteos_comentarios_fk
FOREIGN KEY (id_posteo)
REFERENCES public.posteos (id_posteo)
ON DELETE CASCADE
ON UPDATE CASCADE;


CREATE INDEX idx_posteos_usuario ON public.posteos (id_usuario);
CREATE INDEX idx_posteos_fecha ON public.posteos (fecha_posteo DESC);
CREATE INDEX idx_comentarios_posteo ON public.comentarios (id_posteo);
CREATE INDEX idx_comentarios_usuario ON public.comentarios (id_usuario);