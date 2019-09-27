
DROP TABLE IF EXISTS public.lessons;
DROP TABLE IF EXISTS public.pass;
DROP TABLE IF EXISTS public.couchers;
DROP TABLE IF EXISTS public.persons;
DROP TABLE IF EXISTS public.courselevels;
DROP TABLE IF EXISTS public.courses;

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;


CREATE TABLE public.couchers (
    id integer NOT NULL,
    first_name character varying(255),
    last_name character varying(255),
    mid_name character varying(255),
    phone_number character varying(255)
);


CREATE SEQUENCE public.couchers_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.couchers_id_seq OWNED BY public.couchers.id;



CREATE TABLE public.courselevels (
    id bigint NOT NULL,
    name character varying(255),
    course_id bigint
);


CREATE SEQUENCE public.courselevels_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.courselevels_id_seq OWNED BY public.courselevels.id;


CREATE TABLE public.courses (
    id bigint NOT NULL,
    name character varying(255)
);


CREATE SEQUENCE public.courses_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE public.courses_id_seq OWNED BY public.courses.id;


CREATE TABLE public.lessons (
    id bigint NOT NULL,
    date timestamp without time zone,
    name character varying(255),
    courselevel_id bigint,
    pass_id integer
);



CREATE SEQUENCE public.lessons_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE public.lessons_id_seq OWNED BY public.lessons.id;


CREATE TABLE public.pass (
    id integer NOT NULL,
    item_count integer,
    launch_date timestamp without time zone,
    terminate_date timestamp without time zone,
    course_id bigint NOT NULL,
    person_id integer,
    pass_order integer
);


CREATE SEQUENCE public.pass_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.pass_id_seq OWNED BY public.pass.id;


CREATE TABLE public.persons (
    id integer NOT NULL,
    birth_date timestamp without time zone,
    card_number integer,
    comment character varying(255),
    first_name character varying(255),
    last_name character varying(255),
    mid_name character varying(255),
    phone_number character varying(255),
    reg_date timestamp without time zone
);


CREATE SEQUENCE public.persons_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.persons_id_seq OWNED BY public.persons.id;

ALTER TABLE ONLY public.couchers ALTER COLUMN id SET DEFAULT nextval('public.couchers_id_seq'::regclass);

ALTER TABLE ONLY public.courselevels ALTER COLUMN id SET DEFAULT nextval('public.courselevels_id_seq'::regclass);

ALTER TABLE ONLY public.courses ALTER COLUMN id SET DEFAULT nextval('public.courses_id_seq'::regclass);

ALTER TABLE ONLY public.lessons ALTER COLUMN id SET DEFAULT nextval('public.lessons_id_seq'::regclass);

ALTER TABLE ONLY public.pass ALTER COLUMN id SET DEFAULT nextval('public.pass_id_seq'::regclass);

ALTER TABLE ONLY public.persons ALTER COLUMN id SET DEFAULT nextval('public.persons_id_seq'::regclass);


ALTER TABLE ONLY public.couchers
    ADD CONSTRAINT couchers_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.courselevels
    ADD CONSTRAINT courselevels_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.courses
    ADD CONSTRAINT courses_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.lessons
    ADD CONSTRAINT lessons_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.pass
    ADD CONSTRAINT pass_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.persons
    ADD CONSTRAINT persons_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.persons
    ADD CONSTRAINT uk_ssl77qdpo9ybr570cjcb9iv2t UNIQUE (card_number);

ALTER TABLE ONLY public.lessons
    ADD CONSTRAINT fk7agdg5rfp0keka6cmu91gs9rb FOREIGN KEY (pass_id) REFERENCES public.pass(id);

ALTER TABLE ONLY public.pass
    ADD CONSTRAINT fk7fasy89jtu1rwppidod6tv7ts FOREIGN KEY (person_id) REFERENCES public.persons(id);

ALTER TABLE ONLY public.pass
    ADD CONSTRAINT fkbr7dfyhauuy41es90g7x63j5x FOREIGN KEY (course_id) REFERENCES public.courses(id);


ALTER TABLE ONLY public.courselevels
    ADD CONSTRAINT fkca4j9kmbyk28q5usyx7aednmi FOREIGN KEY (course_id) REFERENCES public.courses(id);

ALTER TABLE ONLY public.lessons
    ADD CONSTRAINT fks9v0yhqvcaiikg38uqbc4n7y8 FOREIGN KEY (courselevel_id) REFERENCES public.courselevels(id);

