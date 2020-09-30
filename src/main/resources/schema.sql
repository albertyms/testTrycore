DROP SEQUENCE public.planet_person_reg_sequence;

DROP SEQUENCE public.person_sequence;

DROP SEQUENCE public.planet_sequence;

DROP TABLE public.planet_person_reg;

DROP TABLE public.persons;

DROP TABLE public.planet;


-- DROP TABLE public.persons;

CREATE TABLE public.persons
(
    id bigint NOT NULL,
    age integer,
    birth_date timestamp without time zone,
    count_view integer,
    full_name character varying(255) COLLATE pg_catalog."default",
    gender integer,
    height double precision,
    id_number integer,
    weight double precision,
    CONSTRAINT persons_pkey PRIMARY KEY (id)
)

-- DROP SEQUENCE public.person_sequence;

CREATE SEQUENCE public.person_sequence
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.person_sequence
    OWNER TO postgres;

TABLESPACE pg_default;

ALTER TABLE public.persons
    OWNER to postgres;


-- DROP TABLE public.planet;

CREATE TABLE public.planet
(
    id bigint NOT NULL,
    count_view integer,
    name character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT planet_pkey PRIMARY KEY (id)
)

-- DROP SEQUENCE public.planet_sequence;

CREATE SEQUENCE public.planet_sequence
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.planet_sequence
    OWNER TO postgres;

TABLESPACE pg_default;

ALTER TABLE public.planet
    OWNER to postgres;


-- DROP TABLE public.planet_person_reg;

CREATE TABLE public.planet_person_reg
(
    id bigint NOT NULL,
    id_person_fk bigint,
    id_planet_fk bigint,
    CONSTRAINT planet_person_reg_pkey PRIMARY KEY (id),
    CONSTRAINT fkd3h31tfds2e9aoojfe34676s7 FOREIGN KEY (id_person_fk)
        REFERENCES public.persons (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fkotpdr1men3h7igsrhe0kng11y FOREIGN KEY (id_planet_fk)
        REFERENCES public.planet (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

-- DROP SEQUENCE public.planet_person_reg_sequence;

CREATE SEQUENCE public.planet_person_reg_sequence
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.planet_person_reg_sequence
    OWNER TO postgres;

TABLESPACE pg_default;

ALTER TABLE public.planet_person_reg
    OWNER to postgres;