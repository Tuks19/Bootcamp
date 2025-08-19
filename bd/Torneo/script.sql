CREATE TABLE public.evento_tipo (
    id_tipo_evento SERIAL PRIMARY KEY,
    nombre_tipo_evento VARCHAR(200) NOT NULL UNIQUE,
    descripcion TEXT,
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE public.torneo (
    id_torneo SERIAL PRIMARY KEY,
    nombre_torneo VARCHAR(100) NOT NULL UNIQUE,
    fecha_inicio TIMESTAMP NOT NULL,
    fecha_fin TIMESTAMP NOT NULL,
    sede VARCHAR(200) NOT NULL,
    descripcion TEXT,
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE public.fases (
    id_fase SERIAL PRIMARY KEY,
    nombre_fase VARCHAR(200) NOT NULL,
    orden_fase INTEGER NOT NULL,
    id_torneo INTEGER NOT NULL,
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UNIQUE (orden_fase, id_torneo)
);

CREATE TABLE public.grupo (
    id_grupo SERIAL PRIMARY KEY,
    nombre_grupo VARCHAR(100) NOT NULL,
    id_torneo INTEGER NOT NULL,
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UNIQUE (nombre_grupo, id_torneo)
);

CREATE TABLE public.equipo (
    id_equipo SERIAL PRIMARY KEY,
    nombre_equipo VARCHAR(200) NOT NULL UNIQUE,
    confederacion VARCHAR(100) NOT NULL,
    id_grupo INTEGER NOT NULL,
    pais VARCHAR(100) NOT NULL,
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE public.partido (
    id_partido SERIAL PRIMARY KEY,
    id_fase INTEGER NOT NULL,
    equipo_visitante INTEGER NOT NULL,
    equipo_local INTEGER NOT NULL,
    estadio VARCHAR(100) NOT NULL,
    fecha_juego TIMESTAMP NOT NULL,
    estado VARCHAR(20) DEFAULT 'programado',
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE public.resultado (
    id_resultado SERIAL PRIMARY KEY,
    id_partido INTEGER NOT NULL UNIQUE,
    goles_visitante INTEGER DEFAULT 0,
    goles_local INTEGER DEFAULT 0,
    penales_local INTEGER DEFAULT 0,
    penales_visitante INTEGER DEFAULT 0,
    fecha_resultado TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE public.jugador (
    documento VARCHAR(20) PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    fecha_nacimiento TIMESTAMP NOT NULL,
    posicion VARCHAR(50) NOT NULL,
    dorsal VARCHAR(2) NOT NULL,
    nro_telefono VARCHAR(20) NOT NULL UNIQUE,
    id_equipo INTEGER NOT NULL,
    activo BOOLEAN DEFAULT true,
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UNIQUE (dorsal, id_equipo)
);

CREATE TABLE public.eventos (
    id_evento SERIAL PRIMARY KEY,
    minuto INTEGER NOT NULL,
    id_tipo_evento INTEGER NOT NULL,
    id_partido INTEGER NOT NULL,
    jugador_involucrado VARCHAR(20) NOT NULL,
    descripcion TEXT,
    fecha_evento TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Foreign Keys
ALTER TABLE public.grupo ADD CONSTRAINT torneo_grupo_fk
FOREIGN KEY (id_torneo)
REFERENCES public.torneo (id_torneo)
ON DELETE CASCADE
ON UPDATE CASCADE;

ALTER TABLE public.fases ADD CONSTRAINT torneo_fases_fk
FOREIGN KEY (id_torneo)
REFERENCES public.torneo (id_torneo)
ON DELETE CASCADE
ON UPDATE CASCADE;

ALTER TABLE public.equipo ADD CONSTRAINT grupo_equipo_fk
FOREIGN KEY (id_grupo)
REFERENCES public.grupo (id_grupo)
ON DELETE CASCADE
ON UPDATE CASCADE;

ALTER TABLE public.partido ADD CONSTRAINT fases_partido_fk
FOREIGN KEY (id_fase)
REFERENCES public.fases (id_fase)
ON DELETE CASCADE
ON UPDATE CASCADE;

ALTER TABLE public.partido ADD CONSTRAINT equipo_visitante_fk
FOREIGN KEY (equipo_visitante)
REFERENCES public.equipo (id_equipo)
ON DELETE RESTRICT
ON UPDATE CASCADE;

ALTER TABLE public.partido ADD CONSTRAINT equipo_local_fk
FOREIGN KEY (equipo_local)
REFERENCES public.equipo (id_equipo)
ON DELETE RESTRICT
ON UPDATE CASCADE;

ALTER TABLE public.jugador ADD CONSTRAINT equipo_jugador_fk
FOREIGN KEY (id_equipo)
REFERENCES public.equipo (id_equipo)
ON DELETE CASCADE
ON UPDATE CASCADE;

ALTER TABLE public.resultado ADD CONSTRAINT partido_resultado_fk
FOREIGN KEY (id_partido)
REFERENCES public.partido (id_partido)
ON DELETE CASCADE
ON UPDATE CASCADE;

ALTER TABLE public.eventos ADD CONSTRAINT evento_tipo_eventos_fk
FOREIGN KEY (id_tipo_evento)
REFERENCES public.evento_tipo (id_tipo_evento)
ON DELETE RESTRICT
ON UPDATE CASCADE;

ALTER TABLE public.eventos ADD CONSTRAINT partido_eventos_fk
FOREIGN KEY (id_partido)
REFERENCES public.partido (id_partido)
ON DELETE CASCADE
ON UPDATE CASCADE;

ALTER TABLE public.eventos ADD CONSTRAINT jugador_eventos_fk
FOREIGN KEY (jugador_involucrado)
REFERENCES public.jugador (documento)
ON DELETE CASCADE
ON UPDATE CASCADE;


CREATE INDEX idx_grupo_torneo ON public.grupo (id_torneo);
CREATE INDEX idx_fases_torneo ON public.fases (id_torneo);
CREATE INDEX idx_fases_orden ON public.fases (orden_fase);
CREATE INDEX idx_equipo_grupo ON public.equipo (id_grupo);
CREATE INDEX idx_partido_fase ON public.partido (id_fase);
CREATE INDEX idx_partido_fecha ON public.partido (fecha_juego);
CREATE INDEX idx_partido_equipos ON public.partido (equipo_local, equipo_visitante);
CREATE INDEX idx_jugador_equipo ON public.jugador (id_equipo);
CREATE INDEX idx_jugador_posicion ON public.jugador (posicion);
CREATE INDEX idx_eventos_partido ON public.eventos (id_partido);
CREATE INDEX idx_eventos_jugador ON public.eventos (jugador_involucrado);
CREATE INDEX idx_eventos_tipo ON public.eventos (id_tipo_evento);
CREATE INDEX idx_eventos_minuto ON public.eventos (minuto);
CREATE INDEX idx_resultado_partido ON public.resultado (id_partido);