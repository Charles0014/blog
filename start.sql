--
-- PostgreSQL database dump
--

-- Dumped from database version 13.5 (Debian 13.5-1.pgdg110+1)
-- Dumped by pg_dump version 13.3

-- Started on 2022-01-01 23:32:28

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 3 (class 2615 OID 2200)
-- Name: public; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA public;


ALTER SCHEMA public OWNER TO postgres;

--
-- TOC entry 3020 (class 0 OID 0)
-- Dependencies: 3
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON SCHEMA public IS 'standard public schema';


--
-- TOC entry 200 (class 1259 OID 16403)
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 201 (class 1259 OID 24646)
-- Name: tb_autor; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tb_autor (
    id bigint NOT NULL,
    email character varying(255),
    nome character varying(255)
);


ALTER TABLE public.tb_autor OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 24654)
-- Name: tb_comentario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tb_comentario (
    id bigint NOT NULL,
    comentario character varying(255),
    post_id bigint,
    autor_id bigint,
    postagem_id bigint
);


ALTER TABLE public.tb_comentario OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 24659)
-- Name: tb_postagem; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tb_postagem (
    id bigint NOT NULL,
    conteudo oid,
    data_atualizacao date,
    data_criacao date,
    titulo character varying(255),
    autor_id bigint
);


ALTER TABLE public.tb_postagem OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 24664)
-- Name: tb_usuario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tb_usuario (
    id bigint NOT NULL,
    login character varying(255),
    password character varying(255)
);


ALTER TABLE public.tb_usuario OWNER TO postgres;

--
-- TOC entry 3011 (class 0 OID 24646)
-- Dependencies: 201
-- Data for Name: tb_autor; Type: TABLE DATA; Schema: public; Owner: postgres
--


--
-- TOC entry 3014 (class 0 OID 24664)
-- Dependencies: 204
-- Data for Name: tb_usuario; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.tb_usuario VALUES (68, 'Admin@dev', '$2a$10$EoVHycYU/6r.7LhQIRVIouPiNqXodxtO45QAGHQcMIa4C1pqivh1O');


--
-- TOC entry 3021 (class 0 OID 0)
-- Dependencies: 200
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.hibernate_sequence', 68, true);


--
-- TOC entry 2868 (class 2606 OID 24653)
-- Name: tb_autor tb_autor_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_autor
    ADD CONSTRAINT tb_autor_pkey PRIMARY KEY (id);


--
-- TOC entry 2870 (class 2606 OID 24658)
-- Name: tb_comentario tb_comentario_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_comentario
    ADD CONSTRAINT tb_comentario_pkey PRIMARY KEY (id);


--
-- TOC entry 2872 (class 2606 OID 24663)
-- Name: tb_postagem tb_postagem_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_postagem
    ADD CONSTRAINT tb_postagem_pkey PRIMARY KEY (id);


--
-- TOC entry 2874 (class 2606 OID 24671)
-- Name: tb_usuario tb_usuario_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_usuario
    ADD CONSTRAINT tb_usuario_pkey PRIMARY KEY (id);


--
-- TOC entry 2876 (class 2606 OID 24673)
-- Name: tb_usuario uk_1vofibjsgo77e7km8wowva1qe; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_usuario
    ADD CONSTRAINT uk_1vofibjsgo77e7km8wowva1qe UNIQUE (login);


--
-- TOC entry 2879 (class 2606 OID 24684)
-- Name: tb_postagem fk2001t4eop89a4sswraqjvvryq; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_postagem
    ADD CONSTRAINT fk2001t4eop89a4sswraqjvvryq FOREIGN KEY (autor_id) REFERENCES public.tb_autor(id);


--
-- TOC entry 2878 (class 2606 OID 24679)
-- Name: tb_comentario fkeqsn2qe4e8d323g0s2g899rw7; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_comentario
    ADD CONSTRAINT fkeqsn2qe4e8d323g0s2g899rw7 FOREIGN KEY (postagem_id) REFERENCES public.tb_postagem(id);


--
-- TOC entry 2877 (class 2606 OID 24674)
-- Name: tb_comentario fkhled3s7ofjgvqag6kv4ygsrv7; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_comentario
    ADD CONSTRAINT fkhled3s7ofjgvqag6kv4ygsrv7 FOREIGN KEY (autor_id) REFERENCES public.tb_autor(id);


-- Completed on 2022-01-01 23:32:28

--
-- PostgreSQL database dump complete
--

