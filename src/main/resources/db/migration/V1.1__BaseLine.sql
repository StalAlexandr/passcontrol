
DROP TABLE IF EXISTS public.lessons;
DROP TABLE IF EXISTS public.pass;
DROP TABLE IF EXISTS public.couchers;
DROP TABLE IF EXISTS public.persons;
DROP TABLE IF EXISTS public.courselevels;
DROP TABLE IF EXISTS public.courses;

--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.19
-- Dumped by pg_dump version 9.5.19
-- Started on 2019-09-26 14:52:37 MSK

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 12395)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner:
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2198 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner:
--

-- COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 182 (class 1259 OID 31721)
-- Name: couchers; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.couchers (
    id integer NOT NULL,
    first_name character varying(255),
    last_name character varying(255),
    mid_name character varying(255),
    phone_number character varying(255)
);


ALTER TABLE public.couchers OWNER TO postgres;

--
-- TOC entry 181 (class 1259 OID 31719)
-- Name: couchers_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.couchers_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.couchers_id_seq OWNER TO postgres;

--
-- TOC entry 2199 (class 0 OID 0)
-- Dependencies: 181
-- Name: couchers_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.couchers_id_seq OWNED BY public.couchers.id;


--
-- TOC entry 184 (class 1259 OID 31732)
-- Name: courselevels; Type: TABLE; Schema: public; Owner: postgres
--



CREATE TABLE public.courselevels (
    id bigint NOT NULL,
    name character varying(255),
    course_id bigint
);


ALTER TABLE public.courselevels OWNER TO postgres;

--
-- TOC entry 183 (class 1259 OID 31730)
-- Name: courselevels_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.courselevels_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.courselevels_id_seq OWNER TO postgres;

--
-- TOC entry 2200 (class 0 OID 0)
-- Dependencies: 183
-- Name: courselevels_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.courselevels_id_seq OWNED BY public.courselevels.id;


--
-- TOC entry 186 (class 1259 OID 31740)
-- Name: courses; Type: TABLE; Schema: public; Owner: postgres
--



CREATE TABLE public.courses (
    id bigint NOT NULL,
    name character varying(255)
);


ALTER TABLE public.courses OWNER TO postgres;

--
-- TOC entry 185 (class 1259 OID 31738)
-- Name: courses_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.courses_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.courses_id_seq OWNER TO postgres;

--
-- TOC entry 2201 (class 0 OID 0)
-- Dependencies: 185
-- Name: courses_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.courses_id_seq OWNED BY public.courses.id;


--
-- TOC entry 188 (class 1259 OID 31748)
-- Name: lessons; Type: TABLE; Schema: public; Owner: postgres
--



CREATE TABLE public.lessons (
    id bigint NOT NULL,
    date timestamp without time zone,
    name character varying(255),
    courselevel_id bigint,
    pass_id integer
);


ALTER TABLE public.lessons OWNER TO postgres;

--
-- TOC entry 187 (class 1259 OID 31746)
-- Name: lessons_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.lessons_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.lessons_id_seq OWNER TO postgres;

--
-- TOC entry 2202 (class 0 OID 0)
-- Dependencies: 187
-- Name: lessons_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.lessons_id_seq OWNED BY public.lessons.id;


--
-- TOC entry 190 (class 1259 OID 31756)
-- Name: pass; Type: TABLE; Schema: public; Owner: postgres
--



CREATE TABLE public.pass (
    id integer NOT NULL,
    item_count integer,
    launch_date timestamp without time zone,
    terminate_date timestamp without time zone,
    course_id bigint NOT NULL,
    person_id integer,
    pass_order integer
);


ALTER TABLE public.pass OWNER TO postgres;

--
-- TOC entry 189 (class 1259 OID 31754)
-- Name: pass_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.pass_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.pass_id_seq OWNER TO postgres;

--
-- TOC entry 2203 (class 0 OID 0)
-- Dependencies: 189
-- Name: pass_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.pass_id_seq OWNED BY public.pass.id;


--
-- TOC entry 192 (class 1259 OID 31764)
-- Name: persons; Type: TABLE; Schema: public; Owner: postgres
--


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


ALTER TABLE public.persons OWNER TO postgres;

--
-- TOC entry 191 (class 1259 OID 31762)
-- Name: persons_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.persons_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.persons_id_seq OWNER TO postgres;

--
-- TOC entry 2204 (class 0 OID 0)
-- Dependencies: 191
-- Name: persons_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.persons_id_seq OWNED BY public.persons.id;


--
-- TOC entry 2051 (class 2604 OID 31724)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.couchers ALTER COLUMN id SET DEFAULT nextval('public.couchers_id_seq'::regclass);


--
-- TOC entry 2052 (class 2604 OID 31735)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.courselevels ALTER COLUMN id SET DEFAULT nextval('public.courselevels_id_seq'::regclass);


--
-- TOC entry 2053 (class 2604 OID 31743)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.courses ALTER COLUMN id SET DEFAULT nextval('public.courses_id_seq'::regclass);


--
-- TOC entry 2054 (class 2604 OID 31751)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.lessons ALTER COLUMN id SET DEFAULT nextval('public.lessons_id_seq'::regclass);


--
-- TOC entry 2055 (class 2604 OID 31759)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pass ALTER COLUMN id SET DEFAULT nextval('public.pass_id_seq'::regclass);


--
-- TOC entry 2056 (class 2604 OID 31767)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.persons ALTER COLUMN id SET DEFAULT nextval('public.persons_id_seq'::regclass);


--
-- TOC entry 2058 (class 2606 OID 31729)
-- Name: couchers_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.couchers
    ADD CONSTRAINT couchers_pkey PRIMARY KEY (id);


--
-- TOC entry 2060 (class 2606 OID 31737)
-- Name: courselevels_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.courselevels
    ADD CONSTRAINT courselevels_pkey PRIMARY KEY (id);


--
-- TOC entry 2062 (class 2606 OID 31745)
-- Name: courses_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.courses
    ADD CONSTRAINT courses_pkey PRIMARY KEY (id);


--
-- TOC entry 2064 (class 2606 OID 31753)
-- Name: lessons_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.lessons
    ADD CONSTRAINT lessons_pkey PRIMARY KEY (id);


--
-- TOC entry 2066 (class 2606 OID 31761)
-- Name: pass_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pass
    ADD CONSTRAINT pass_pkey PRIMARY KEY (id);


--
-- TOC entry 2068 (class 2606 OID 31772)
-- Name: persons_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.persons
    ADD CONSTRAINT persons_pkey PRIMARY KEY (id);


--
-- TOC entry 2070 (class 2606 OID 31774)
-- Name: uk_ssl77qdpo9ybr570cjcb9iv2t; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.persons
    ADD CONSTRAINT uk_ssl77qdpo9ybr570cjcb9iv2t UNIQUE (card_number);


--
-- TOC entry 2073 (class 2606 OID 31785)
-- Name: fk7agdg5rfp0keka6cmu91gs9rb; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.lessons
    ADD CONSTRAINT fk7agdg5rfp0keka6cmu91gs9rb FOREIGN KEY (pass_id) REFERENCES public.pass(id);


--
-- TOC entry 2075 (class 2606 OID 31795)
-- Name: fk7fasy89jtu1rwppidod6tv7ts; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pass
    ADD CONSTRAINT fk7fasy89jtu1rwppidod6tv7ts FOREIGN KEY (person_id) REFERENCES public.persons(id);


--
-- TOC entry 2074 (class 2606 OID 31790)
-- Name: fkbr7dfyhauuy41es90g7x63j5x; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pass
    ADD CONSTRAINT fkbr7dfyhauuy41es90g7x63j5x FOREIGN KEY (course_id) REFERENCES public.courses(id);


--
-- TOC entry 2071 (class 2606 OID 31775)
-- Name: fkca4j9kmbyk28q5usyx7aednmi; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.courselevels
    ADD CONSTRAINT fkca4j9kmbyk28q5usyx7aednmi FOREIGN KEY (course_id) REFERENCES public.courses(id);


--
-- TOC entry 2072 (class 2606 OID 31780)
-- Name: fks9v0yhqvcaiikg38uqbc4n7y8; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.lessons
    ADD CONSTRAINT fks9v0yhqvcaiikg38uqbc4n7y8 FOREIGN KEY (courselevel_id) REFERENCES public.courselevels(id);


--
-- TOC entry 2197 (class 0 OID 0)
-- Dependencies: 6
-- Name: SCHEMA public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2019-09-26 14:52:37 MSK

--
-- PostgreSQL database dump complete
--

