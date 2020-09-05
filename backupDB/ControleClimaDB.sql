--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.9
-- Dumped by pg_dump version 9.5.9

-- Started on 2020-09-04 22:33:39

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 12355)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2325 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

--
-- TOC entry 201 (class 1259 OID 31084)
-- Name: sq_pkey_cidade; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE sq_pkey_cidade
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE sq_pkey_cidade OWNER TO postgres;

--
-- TOC entry 189 (class 1259 OID 31018)
-- Name: sq_pkey_cliente; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE sq_pkey_cliente
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE sq_pkey_cliente OWNER TO postgres;

--
-- TOC entry 195 (class 1259 OID 31048)
-- Name: sq_pkey_endereco; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE sq_pkey_endereco
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE sq_pkey_endereco OWNER TO postgres;

--
-- TOC entry 193 (class 1259 OID 31039)
-- Name: sq_pkey_estado; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE sq_pkey_estado
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE sq_pkey_estado OWNER TO postgres;

--
-- TOC entry 185 (class 1259 OID 30996)
-- Name: sq_pkey_evapotranspiracao; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE sq_pkey_evapotranspiracao
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE sq_pkey_evapotranspiracao OWNER TO postgres;

--
-- TOC entry 209 (class 1259 OID 31121)
-- Name: sq_pkey_gastoenergia; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE sq_pkey_gastoenergia
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE sq_pkey_gastoenergia OWNER TO postgres;

--
-- TOC entry 199 (class 1259 OID 31072)
-- Name: sq_pkey_irrigacao; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE sq_pkey_irrigacao
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE sq_pkey_irrigacao OWNER TO postgres;

--
-- TOC entry 197 (class 1259 OID 31058)
-- Name: sq_pkey_log_registros; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE sq_pkey_log_registros
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE sq_pkey_log_registros OWNER TO postgres;

--
-- TOC entry 191 (class 1259 OID 31030)
-- Name: sq_pkey_login; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE sq_pkey_login
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE sq_pkey_login OWNER TO postgres;

--
-- TOC entry 207 (class 1259 OID 31112)
-- Name: sq_pkey_modeloequipamentoevapo; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE sq_pkey_modeloequipamentoevapo
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE sq_pkey_modeloequipamentoevapo OWNER TO postgres;

--
-- TOC entry 205 (class 1259 OID 31103)
-- Name: sq_pkey_modeloirrigacao; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE sq_pkey_modeloirrigacao
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE sq_pkey_modeloirrigacao OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 31094)
-- Name: sq_pkey_ocorrencia; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE sq_pkey_ocorrencia
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE sq_pkey_ocorrencia OWNER TO postgres;

--
-- TOC entry 187 (class 1259 OID 31007)
-- Name: sq_pkey_pluviometria; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE sq_pkey_pluviometria
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE sq_pkey_pluviometria OWNER TO postgres;

--
-- TOC entry 211 (class 1259 OID 48525)
-- Name: sq_pkey_temparduino; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE sq_pkey_temparduino
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE sq_pkey_temparduino OWNER TO postgres;

--
-- TOC entry 181 (class 1259 OID 30976)
-- Name: sq_pkey_temperatura; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE sq_pkey_temperatura
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE sq_pkey_temperatura OWNER TO postgres;

--
-- TOC entry 183 (class 1259 OID 30986)
-- Name: sq_pkey_umidade; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE sq_pkey_umidade
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE sq_pkey_umidade OWNER TO postgres;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 202 (class 1259 OID 31086)
-- Name: tb_cidade; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE tb_cidade (
    id_cidade bigint DEFAULT nextval('sq_pkey_cidade'::regclass) NOT NULL,
    nome_cidade character varying(64) NOT NULL,
    id_estado bigint NOT NULL,
    data_hora_registro timestamp without time zone DEFAULT now()
)
WITH (autovacuum_enabled='true');


ALTER TABLE tb_cidade OWNER TO postgres;

--
-- TOC entry 190 (class 1259 OID 31020)
-- Name: tb_cliente; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE tb_cliente (
    id_cliente bigint DEFAULT nextval('sq_pkey_cliente'::regclass) NOT NULL,
    nome character varying(64) NOT NULL,
    sobrenome character varying(64) NOT NULL,
    situacao character varying(32) NOT NULL,
    id_endereco bigint,
    id_login bigint,
    id_estado bigint,
    data_hora_registro timestamp without time zone DEFAULT now()
)
WITH (autovacuum_enabled='true');


ALTER TABLE tb_cliente OWNER TO postgres;

--
-- TOC entry 2326 (class 0 OID 0)
-- Dependencies: 190
-- Name: COLUMN tb_cliente.situacao; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN tb_cliente.situacao IS 'Ativo,
Inativo';


--
-- TOC entry 196 (class 1259 OID 31050)
-- Name: tb_endereco; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE tb_endereco (
    id_endereco bigint DEFAULT nextval('sq_pkey_endereco'::regclass) NOT NULL,
    rua character varying(64),
    numero character varying(32),
    id_cidade bigint NOT NULL,
    data_hora_registro timestamp without time zone DEFAULT now()
)
WITH (autovacuum_enabled='true');


ALTER TABLE tb_endereco OWNER TO postgres;

--
-- TOC entry 194 (class 1259 OID 31041)
-- Name: tb_estado; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE tb_estado (
    id_estado bigint DEFAULT nextval('sq_pkey_estado'::regclass) NOT NULL,
    nome_estado character varying(32) NOT NULL,
    mesorregiao character varying(32) NOT NULL,
    uf character varying(2) NOT NULL,
    data_hora_registro timestamp without time zone DEFAULT now()
)
WITH (autovacuum_enabled='true');


ALTER TABLE tb_estado OWNER TO postgres;

--
-- TOC entry 186 (class 1259 OID 30998)
-- Name: tb_evapotranspiracao; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE tb_evapotranspiracao (
    id_evapotranspiracao bigint DEFAULT nextval('sq_pkey_evapotranspiracao'::regclass) NOT NULL,
    unidade_medida character varying(10) NOT NULL,
    data_evapotranspiracao date NOT NULL,
    qtidade_evapo numeric(4,2) NOT NULL,
    id_cliente bigint NOT NULL,
    id_modeloequipamentoevapo bigint,
    data_hora_registro timestamp without time zone DEFAULT now()
)
WITH (autovacuum_enabled='true');


ALTER TABLE tb_evapotranspiracao OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 31123)
-- Name: tb_gastoenergia; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE tb_gastoenergia (
    id_gastoenergia bigint DEFAULT nextval('sq_pkey_gastoenergia'::regclass) NOT NULL,
    possui_irrigacao_noturna boolean,
    custo_energia_kwh character varying(64),
    data_cadastro date NOT NULL
)
WITH (autovacuum_enabled='true');


ALTER TABLE tb_gastoenergia OWNER TO postgres;

--
-- TOC entry 2327 (class 0 OID 0)
-- Dependencies: 210
-- Name: COLUMN tb_gastoenergia.custo_energia_kwh; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN tb_gastoenergia.custo_energia_kwh IS 'Custo da energia por Quilowatt-hora pago na região.';


--
-- TOC entry 200 (class 1259 OID 31074)
-- Name: tb_irrigacao; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE tb_irrigacao (
    id_irrigacao bigint DEFAULT nextval('sq_pkey_irrigacao'::regclass) NOT NULL,
    area_irrigada character varying(20) NOT NULL,
    lamina_agua integer,
    tempo_irrigacao character varying(10),
    cultivar character varying(30),
    motor_cv character varying(10),
    id_cliente bigint NOT NULL,
    id_modeloirrigacao bigint,
    id_gastoenergia bigint,
    data_hora_registro timestamp without time zone DEFAULT now()
)
WITH (autovacuum_enabled='true');


ALTER TABLE tb_irrigacao OWNER TO postgres;

--
-- TOC entry 2328 (class 0 OID 0)
-- Dependencies: 200
-- Name: COLUMN tb_irrigacao.area_irrigada; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN tb_irrigacao.area_irrigada IS 'Tamanho da área em Hectare (ha).';


--
-- TOC entry 2329 (class 0 OID 0)
-- Dependencies: 200
-- Name: COLUMN tb_irrigacao.lamina_agua; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN tb_irrigacao.lamina_agua IS 'Necessidade de água diária (irrigação - mm de chuva).';


--
-- TOC entry 2330 (class 0 OID 0)
-- Dependencies: 200
-- Name: COLUMN tb_irrigacao.tempo_irrigacao; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN tb_irrigacao.tempo_irrigacao IS 'Quantidade em Horas de acordo com recomendação.';


--
-- TOC entry 2331 (class 0 OID 0)
-- Dependencies: 200
-- Name: COLUMN tb_irrigacao.motor_cv; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN tb_irrigacao.motor_cv IS 'Qual o tamanho do motor em CV';


--
-- TOC entry 198 (class 1259 OID 31060)
-- Name: tb_log_registros; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE tb_log_registros (
    id_log_registros bigint DEFAULT nextval('sq_pkey_log_registros'::regclass) NOT NULL,
    idcliente integer NOT NULL,
    tabela character varying(64) NOT NULL,
    tipo_log character varying(32) NOT NULL,
    descricao character varying(256) NOT NULL,
    id_temperatura bigint,
    id_umidade bigint,
    id_evapotranspiracao bigint,
    id_pluviometria bigint,
    id_irrigacao bigint,
    data_hora_registro timestamp without time zone DEFAULT now()
)
WITH (autovacuum_enabled='true');


ALTER TABLE tb_log_registros OWNER TO postgres;

--
-- TOC entry 2332 (class 0 OID 0)
-- Dependencies: 198
-- Name: COLUMN tb_log_registros.tipo_log; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN tb_log_registros.tipo_log IS 'Update
Exclusão';


--
-- TOC entry 192 (class 1259 OID 31032)
-- Name: tb_login; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE tb_login (
    id_login bigint DEFAULT nextval('sq_pkey_login'::regclass) NOT NULL,
    login character varying(32) NOT NULL,
    senha character varying(32) NOT NULL,
    email character varying(64) NOT NULL,
    perfil character varying(32) NOT NULL,
    data_hora_registro timestamp without time zone DEFAULT now()
)
WITH (autovacuum_enabled='true');


ALTER TABLE tb_login OWNER TO postgres;

--
-- TOC entry 208 (class 1259 OID 31114)
-- Name: tb_modeloequipamentoevapo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE tb_modeloequipamentoevapo (
    id_modeloequipamentoevapo bigint DEFAULT nextval('sq_pkey_modeloequipamentoevapo'::regclass) NOT NULL,
    modelo_descricao character varying(64),
    data_hora_registro timestamp without time zone DEFAULT now()
)
WITH (autovacuum_enabled='true');


ALTER TABLE tb_modeloequipamentoevapo OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 31105)
-- Name: tb_modeloirrigacao; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE tb_modeloirrigacao (
    id_modeloirrigacao bigint DEFAULT nextval('sq_pkey_modeloirrigacao'::regclass) NOT NULL,
    modelo_descricao character varying(64),
    data_hora_registro timestamp without time zone DEFAULT now()
)
WITH (autovacuum_enabled='true');


ALTER TABLE tb_modeloirrigacao OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 31096)
-- Name: tb_ocorrencias; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE tb_ocorrencias (
    id_ocorrencia bigint DEFAULT nextval('sq_pkey_ocorrencia'::regclass) NOT NULL,
    granizo boolean,
    faltou_energia boolean,
    data_hora_registro timestamp without time zone DEFAULT now()
)
WITH (autovacuum_enabled='true');


ALTER TABLE tb_ocorrencias OWNER TO postgres;

--
-- TOC entry 188 (class 1259 OID 31009)
-- Name: tb_pluviometria; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE tb_pluviometria (
    id_pluviometria bigint DEFAULT nextval('sq_pkey_pluviometria'::regclass) NOT NULL,
    unidade_medida character varying(10) NOT NULL,
    data_pluviometria date NOT NULL,
    qtidade_chuva numeric(5,2) NOT NULL,
    id_cliente bigint NOT NULL,
    id_ocorrencia bigint,
    data_hora_registro timestamp without time zone DEFAULT now()
)
WITH (autovacuum_enabled='true');


ALTER TABLE tb_pluviometria OWNER TO postgres;

--
-- TOC entry 212 (class 1259 OID 48527)
-- Name: tb_temparduino; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE tb_temparduino (
    id_temparduino bigint DEFAULT nextval('sq_pkey_temparduino'::regclass) NOT NULL,
    temp_maxima numeric(5,2),
    temp_minima numeric(5,2),
    temp_atual numeric(5,2),
    data_hora_registro timestamp without time zone DEFAULT now()
)
WITH (autovacuum_enabled='true');


ALTER TABLE tb_temparduino OWNER TO postgres;

--
-- TOC entry 182 (class 1259 OID 30978)
-- Name: tb_temperatura; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE tb_temperatura (
    id_temperatura bigint DEFAULT nextval('sq_pkey_temperatura'::regclass) NOT NULL,
    unidade_medida character varying(10) NOT NULL,
    data_temperatura date NOT NULL,
    temp_maxima numeric(4,2) NOT NULL,
    temp_minima numeric(4,2) NOT NULL,
    id_cliente bigint NOT NULL,
    data_hora_registro timestamp without time zone DEFAULT now()
)
WITH (autovacuum_enabled='true');


ALTER TABLE tb_temperatura OWNER TO postgres;

--
-- TOC entry 184 (class 1259 OID 30988)
-- Name: tb_umidade; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE tb_umidade (
    id_umidade bigint DEFAULT nextval('sq_pkey_umidade'::regclass) NOT NULL,
    unidade_medida character varying(10) NOT NULL,
    data_umidade date NOT NULL,
    umidade_maxima numeric(4,2) NOT NULL,
    umidade_minima numeric(4,2) NOT NULL,
    id_cliente bigint NOT NULL,
    data_hora_registro timestamp without time zone DEFAULT now()
)
WITH (autovacuum_enabled='true');


ALTER TABLE tb_umidade OWNER TO postgres;

--
-- TOC entry 2333 (class 0 OID 0)
-- Dependencies: 201
-- Name: sq_pkey_cidade; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('sq_pkey_cidade', 56, true);


--
-- TOC entry 2334 (class 0 OID 0)
-- Dependencies: 189
-- Name: sq_pkey_cliente; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('sq_pkey_cliente', 12, true);


--
-- TOC entry 2335 (class 0 OID 0)
-- Dependencies: 195
-- Name: sq_pkey_endereco; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('sq_pkey_endereco', 56, true);


--
-- TOC entry 2336 (class 0 OID 0)
-- Dependencies: 193
-- Name: sq_pkey_estado; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('sq_pkey_estado', 56, true);


--
-- TOC entry 2337 (class 0 OID 0)
-- Dependencies: 185
-- Name: sq_pkey_evapotranspiracao; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('sq_pkey_evapotranspiracao', 13, true);


--
-- TOC entry 2338 (class 0 OID 0)
-- Dependencies: 209
-- Name: sq_pkey_gastoenergia; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('sq_pkey_gastoenergia', 1, false);


--
-- TOC entry 2339 (class 0 OID 0)
-- Dependencies: 199
-- Name: sq_pkey_irrigacao; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('sq_pkey_irrigacao', 1, false);


--
-- TOC entry 2340 (class 0 OID 0)
-- Dependencies: 197
-- Name: sq_pkey_log_registros; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('sq_pkey_log_registros', 1, false);


--
-- TOC entry 2341 (class 0 OID 0)
-- Dependencies: 191
-- Name: sq_pkey_login; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('sq_pkey_login', 3, true);


--
-- TOC entry 2342 (class 0 OID 0)
-- Dependencies: 207
-- Name: sq_pkey_modeloequipamentoevapo; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('sq_pkey_modeloequipamentoevapo', 1, true);


--
-- TOC entry 2343 (class 0 OID 0)
-- Dependencies: 205
-- Name: sq_pkey_modeloirrigacao; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('sq_pkey_modeloirrigacao', 1, false);


--
-- TOC entry 2344 (class 0 OID 0)
-- Dependencies: 203
-- Name: sq_pkey_ocorrencia; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('sq_pkey_ocorrencia', 1, false);


--
-- TOC entry 2345 (class 0 OID 0)
-- Dependencies: 187
-- Name: sq_pkey_pluviometria; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('sq_pkey_pluviometria', 1, false);


--
-- TOC entry 2346 (class 0 OID 0)
-- Dependencies: 211
-- Name: sq_pkey_temparduino; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('sq_pkey_temparduino', 2, true);


--
-- TOC entry 2347 (class 0 OID 0)
-- Dependencies: 181
-- Name: sq_pkey_temperatura; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('sq_pkey_temperatura', 85, true);


--
-- TOC entry 2348 (class 0 OID 0)
-- Dependencies: 183
-- Name: sq_pkey_umidade; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('sq_pkey_umidade', 1, false);


--
-- TOC entry 2307 (class 0 OID 31086)
-- Dependencies: 202
-- Data for Name: tb_cidade; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO tb_cidade (id_cidade, nome_cidade, id_estado, data_hora_registro) VALUES (1, 'Dionísio Cerqueira', 1, '2019-05-27 21:44:05.053807');
INSERT INTO tb_cidade (id_cidade, nome_cidade, id_estado, data_hora_registro) VALUES (2, 'Marema', 1, '2019-05-27 21:44:05.053807');
INSERT INTO tb_cidade (id_cidade, nome_cidade, id_estado, data_hora_registro) VALUES (47, 'Ribeirão Claro', 47, '2019-06-23 22:44:45.629596');
INSERT INTO tb_cidade (id_cidade, nome_cidade, id_estado, data_hora_registro) VALUES (49, 'Jacarézinho', 49, '2019-06-24 00:33:02.100042');
INSERT INTO tb_cidade (id_cidade, nome_cidade, id_estado, data_hora_registro) VALUES (50, 'Jacarézinho', 50, '2019-06-24 11:14:22.135429');
INSERT INTO tb_cidade (id_cidade, nome_cidade, id_estado, data_hora_registro) VALUES (51, 'Poços de Caldas', 51, '2019-06-24 14:15:39.287428');
INSERT INTO tb_cidade (id_cidade, nome_cidade, id_estado, data_hora_registro) VALUES (52, 'City', 52, '2019-06-24 17:38:39.877299');
INSERT INTO tb_cidade (id_cidade, nome_cidade, id_estado, data_hora_registro) VALUES (53, 'asdsadasf', 53, '2019-06-24 17:44:42.605053');
INSERT INTO tb_cidade (id_cidade, nome_cidade, id_estado, data_hora_registro) VALUES (54, 'Vitorino', 54, '2019-06-24 18:09:49.919359');
INSERT INTO tb_cidade (id_cidade, nome_cidade, id_estado, data_hora_registro) VALUES (55, 'Veneza', 55, '2019-07-17 21:06:50.831092');
INSERT INTO tb_cidade (id_cidade, nome_cidade, id_estado, data_hora_registro) VALUES (56, 'Veneza', 56, '2020-01-26 12:17:05.495188');


--
-- TOC entry 2295 (class 0 OID 31020)
-- Dependencies: 190
-- Data for Name: tb_cliente; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO tb_cliente (id_cliente, nome, sobrenome, situacao, id_endereco, id_login, id_estado, data_hora_registro) VALUES (2, 'Claudecir', 'Lunardi', 'Ativo', 2, 1, 1, '2019-05-27 21:45:16.522572');
INSERT INTO tb_cliente (id_cliente, nome, sobrenome, situacao, id_endereco, id_login, id_estado, data_hora_registro) VALUES (3, 'Adilson', 'Lima', 'Ativo', 47, 1, 47, '2019-06-23 22:44:45.63268');
INSERT INTO tb_cliente (id_cliente, nome, sobrenome, situacao, id_endereco, id_login, id_estado, data_hora_registro) VALUES (5, 'Nélio', 'Martins', 'Ativo', 49, 1, 49, '2019-06-24 00:33:02.103761');
INSERT INTO tb_cliente (id_cliente, nome, sobrenome, situacao, id_endereco, id_login, id_estado, data_hora_registro) VALUES (6, 'Laércio', 'Oliveira', 'Ativo', 50, 1, 50, '2019-06-24 11:14:22.15544');
INSERT INTO tb_cliente (id_cliente, nome, sobrenome, situacao, id_endereco, id_login, id_estado, data_hora_registro) VALUES (7, 'Francisco', 'Assis', 'Ativo', 51, 2, 51, '2019-06-24 14:15:39.309793');
INSERT INTO tb_cliente (id_cliente, nome, sobrenome, situacao, id_endereco, id_login, id_estado, data_hora_registro) VALUES (1, 'Ivan', 'Mallmann', 'Ativo', 1, 1, 1, '2019-05-27 21:45:16.522572');
INSERT INTO tb_cliente (id_cliente, nome, sobrenome, situacao, id_endereco, id_login, id_estado, data_hora_registro) VALUES (8, 'Adilsonteste', 'Lima', 'Ativo', 52, 2, 52, '2019-06-24 17:38:39.904869');
INSERT INTO tb_cliente (id_cliente, nome, sobrenome, situacao, id_endereco, id_login, id_estado, data_hora_registro) VALUES (9, 'saasdg', 'sdgsdg', 'Ativo', 53, 2, 53, '2019-06-24 17:44:42.608679');
INSERT INTO tb_cliente (id_cliente, nome, sobrenome, situacao, id_endereco, id_login, id_estado, data_hora_registro) VALUES (10, 'Clienteteste', 'sobrenome teste', 'Ativo', 54, 1, 54, '2019-06-24 18:09:49.924004');
INSERT INTO tb_cliente (id_cliente, nome, sobrenome, situacao, id_endereco, id_login, id_estado, data_hora_registro) VALUES (11, 'MANDRIK', 'RUFFATTO', 'Ativo', 55, 1, 55, '2019-07-17 21:06:50.873577');
INSERT INTO tb_cliente (id_cliente, nome, sobrenome, situacao, id_endereco, id_login, id_estado, data_hora_registro) VALUES (12, 'Micuim', 'Lindo', 'Ativo', 56, 3, 56, '2020-01-26 12:17:05.507417');


--
-- TOC entry 2301 (class 0 OID 31050)
-- Dependencies: 196
-- Data for Name: tb_endereco; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO tb_endereco (id_endereco, rua, numero, id_cidade, data_hora_registro) VALUES (47, 'Dr. Xaxier', '1234', 47, '2019-06-23 22:44:45.631268');
INSERT INTO tb_endereco (id_endereco, rua, numero, id_cidade, data_hora_registro) VALUES (1, 'Não Informado', 'Não Informado', 1, '2019-05-27 21:44:09.555455');
INSERT INTO tb_endereco (id_endereco, rua, numero, id_cidade, data_hora_registro) VALUES (2, 'Não Informado', 'Não Informado', 2, '2019-05-27 21:44:09.555455');
INSERT INTO tb_endereco (id_endereco, rua, numero, id_cidade, data_hora_registro) VALUES (49, 'interior', 'Não Informado', 49, '2019-06-24 00:33:02.102364');
INSERT INTO tb_endereco (id_endereco, rua, numero, id_cidade, data_hora_registro) VALUES (50, 'interior', 'Não Informado', 50, '2019-06-24 11:14:22.145612');
INSERT INTO tb_endereco (id_endereco, rua, numero, id_cidade, data_hora_registro) VALUES (51, 'RuaMinas', 'num', 51, '2019-06-24 14:15:39.298651');
INSERT INTO tb_endereco (id_endereco, rua, numero, id_cidade, data_hora_registro) VALUES (52, 'rua', 'num', 52, '2019-06-24 17:38:39.891903');
INSERT INTO tb_endereco (id_endereco, rua, numero, id_cidade, data_hora_registro) VALUES (53, 'sfsdf', 'safsdg', 53, '2019-06-24 17:44:42.607482');
INSERT INTO tb_endereco (id_endereco, rua, numero, id_cidade, data_hora_registro) VALUES (54, 'Fracaro', '312', 54, '2019-06-24 18:09:49.922398');
INSERT INTO tb_endereco (id_endereco, rua, numero, id_cidade, data_hora_registro) VALUES (55, 'Fracaro', '312', 55, '2019-07-17 21:06:50.855737');
INSERT INTO tb_endereco (id_endereco, rua, numero, id_cidade, data_hora_registro) VALUES (56, 'Centro', '100', 56, '2020-01-26 12:17:05.501522');


--
-- TOC entry 2299 (class 0 OID 31041)
-- Dependencies: 194
-- Data for Name: tb_estado; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO tb_estado (id_estado, nome_estado, mesorregiao, uf, data_hora_registro) VALUES (1, 'Santa Catarina', 'Oeste Catarinense', 'SC', '2019-05-27 21:44:00.449478');
INSERT INTO tb_estado (id_estado, nome_estado, mesorregiao, uf, data_hora_registro) VALUES (47, 'Paraná', 'Norte pioneiro', 'PR', '2019-06-23 22:44:45.622057');
INSERT INTO tb_estado (id_estado, nome_estado, mesorregiao, uf, data_hora_registro) VALUES (49, 'Paraná', 'Norte Pioneiro', 'PR', '2019-06-24 00:33:02.094478');
INSERT INTO tb_estado (id_estado, nome_estado, mesorregiao, uf, data_hora_registro) VALUES (50, 'Paraná', 'Norte Pioneiro', 'PR', '2019-06-24 11:14:22.12823');
INSERT INTO tb_estado (id_estado, nome_estado, mesorregiao, uf, data_hora_registro) VALUES (51, 'Minas Gerais', 'Triangulo', 'MG', '2019-06-24 14:15:39.273973');
INSERT INTO tb_estado (id_estado, nome_estado, mesorregiao, uf, data_hora_registro) VALUES (52, 'Paraíba', 'Mesoteste', 'PA', '2019-06-24 17:38:39.862159');
INSERT INTO tb_estado (id_estado, nome_estado, mesorregiao, uf, data_hora_registro) VALUES (53, 'Acre', 'asfasdgdsfg', 'AC', '2019-06-24 17:44:42.595865');
INSERT INTO tb_estado (id_estado, nome_estado, mesorregiao, uf, data_hora_registro) VALUES (54, 'Paraná', 'Sudoeste', 'PR', '2019-06-24 18:09:49.916933');
INSERT INTO tb_estado (id_estado, nome_estado, mesorregiao, uf, data_hora_registro) VALUES (55, 'Paraná', 'MesoTeste', 'PR', '2019-07-17 21:06:50.811814');
INSERT INTO tb_estado (id_estado, nome_estado, mesorregiao, uf, data_hora_registro) VALUES (56, 'Paraná', 'Sudoeste', 'PR', '2020-01-26 12:17:05.490644');


--
-- TOC entry 2291 (class 0 OID 30998)
-- Dependencies: 186
-- Data for Name: tb_evapotranspiracao; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO tb_evapotranspiracao (id_evapotranspiracao, unidade_medida, data_evapotranspiracao, qtidade_evapo, id_cliente, id_modeloequipamentoevapo, data_hora_registro) VALUES (2, 'mm', '2019-06-01', 3.00, 1, 1, '2019-06-02 11:53:01.367414');
INSERT INTO tb_evapotranspiracao (id_evapotranspiracao, unidade_medida, data_evapotranspiracao, qtidade_evapo, id_cliente, id_modeloequipamentoevapo, data_hora_registro) VALUES (3, 'mm', '2019-06-02', 3.80, 1, 1, '2019-06-02 12:08:13.494412');
INSERT INTO tb_evapotranspiracao (id_evapotranspiracao, unidade_medida, data_evapotranspiracao, qtidade_evapo, id_cliente, id_modeloequipamentoevapo, data_hora_registro) VALUES (4, 'mm', '2019-06-09', 5.00, 1, 1, '2019-06-09 06:41:54.566365');
INSERT INTO tb_evapotranspiracao (id_evapotranspiracao, unidade_medida, data_evapotranspiracao, qtidade_evapo, id_cliente, id_modeloequipamentoevapo, data_hora_registro) VALUES (7, 'mm', '2019-06-12', 5.00, 1, 1, '2019-06-17 21:04:29.154479');
INSERT INTO tb_evapotranspiracao (id_evapotranspiracao, unidade_medida, data_evapotranspiracao, qtidade_evapo, id_cliente, id_modeloequipamentoevapo, data_hora_registro) VALUES (8, 'mm', '2019-06-23', 6.50, 2, 1, '2019-06-23 21:38:56.477914');
INSERT INTO tb_evapotranspiracao (id_evapotranspiracao, unidade_medida, data_evapotranspiracao, qtidade_evapo, id_cliente, id_modeloequipamentoevapo, data_hora_registro) VALUES (9, 'mm', '2019-06-24', 7.20, 6, 1, '2019-06-24 13:36:56.091997');
INSERT INTO tb_evapotranspiracao (id_evapotranspiracao, unidade_medida, data_evapotranspiracao, qtidade_evapo, id_cliente, id_modeloequipamentoevapo, data_hora_registro) VALUES (10, 'mm', '2019-06-24', 6.60, 5, 1, '2019-06-24 13:37:19.836103');
INSERT INTO tb_evapotranspiracao (id_evapotranspiracao, unidade_medida, data_evapotranspiracao, qtidade_evapo, id_cliente, id_modeloequipamentoevapo, data_hora_registro) VALUES (12, 'mm', '2019-06-24', 6.00, 9, 1, '2019-06-24 18:05:05.915645');
INSERT INTO tb_evapotranspiracao (id_evapotranspiracao, unidade_medida, data_evapotranspiracao, qtidade_evapo, id_cliente, id_modeloequipamentoevapo, data_hora_registro) VALUES (13, 'mm', '2019-06-30', 4.00, 10, 1, '2019-06-30 15:26:17.37961');
INSERT INTO tb_evapotranspiracao (id_evapotranspiracao, unidade_medida, data_evapotranspiracao, qtidade_evapo, id_cliente, id_modeloequipamentoevapo, data_hora_registro) VALUES (11, 'mm', '2019-06-13', 6.70, 1, 1, '2019-06-24 14:52:40.576624');


--
-- TOC entry 2315 (class 0 OID 31123)
-- Dependencies: 210
-- Data for Name: tb_gastoenergia; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2305 (class 0 OID 31074)
-- Dependencies: 200
-- Data for Name: tb_irrigacao; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2303 (class 0 OID 31060)
-- Dependencies: 198
-- Data for Name: tb_log_registros; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2297 (class 0 OID 31032)
-- Dependencies: 192
-- Data for Name: tb_login; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO tb_login (id_login, login, senha, email, perfil, data_hora_registro) VALUES (1, 'adilson', '1', 'adilson@gmail.com', 'admin', '2019-05-27 21:45:11.243493');
INSERT INTO tb_login (id_login, login, senha, email, perfil, data_hora_registro) VALUES (2, 'jucabala', '1', 'jucabala@gmail.com', 'user', '2019-06-09 18:29:14.993046');
INSERT INTO tb_login (id_login, login, senha, email, perfil, data_hora_registro) VALUES (3, 'encrypted', 'c4ca4238a0b923820dcc509a6f75849b', 'adilson@gmail.com', 'admin', '2020-01-26 11:08:13.460534');


--
-- TOC entry 2313 (class 0 OID 31114)
-- Dependencies: 208
-- Data for Name: tb_modeloequipamentoevapo; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO tb_modeloequipamentoevapo (id_modeloequipamentoevapo, modelo_descricao, data_hora_registro) VALUES (1, 'Priché', '2019-06-02 11:52:33.139705');


--
-- TOC entry 2311 (class 0 OID 31105)
-- Dependencies: 206
-- Data for Name: tb_modeloirrigacao; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2309 (class 0 OID 31096)
-- Dependencies: 204
-- Data for Name: tb_ocorrencias; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2293 (class 0 OID 31009)
-- Dependencies: 188
-- Data for Name: tb_pluviometria; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2317 (class 0 OID 48527)
-- Dependencies: 212
-- Data for Name: tb_temparduino; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO tb_temparduino (id_temparduino, temp_maxima, temp_minima, temp_atual, data_hora_registro) VALUES (1, NULL, NULL, 23.00, '2019-06-30 11:57:02.997231');
INSERT INTO tb_temparduino (id_temparduino, temp_maxima, temp_minima, temp_atual, data_hora_registro) VALUES (2, NULL, NULL, 25.00, '2019-06-30 15:22:34.231762');


--
-- TOC entry 2287 (class 0 OID 30978)
-- Dependencies: 182
-- Data for Name: tb_temperatura; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO tb_temperatura (id_temperatura, unidade_medida, data_temperatura, temp_maxima, temp_minima, id_cliente, data_hora_registro) VALUES (81, '°C', '2019-06-30', 30.00, 10.00, 10, '2019-06-30 02:57:47.805768');
INSERT INTO tb_temperatura (id_temperatura, unidade_medida, data_temperatura, temp_maxima, temp_minima, id_cliente, data_hora_registro) VALUES (5, '°C', '2018-01-06', 31.50, 20.45, 1, '2019-06-23 23:38:03.561041');
INSERT INTO tb_temperatura (id_temperatura, unidade_medida, data_temperatura, temp_maxima, temp_minima, id_cliente, data_hora_registro) VALUES (82, '°C', '2019-07-01', 10.00, 10.00, 8, '2019-07-06 09:25:18.106262');
INSERT INTO tb_temperatura (id_temperatura, unidade_medida, data_temperatura, temp_maxima, temp_minima, id_cliente, data_hora_registro) VALUES (83, '°C', '2019-09-02', 19.00, 12.00, 11, '2019-09-02 12:07:04.985359');
INSERT INTO tb_temperatura (id_temperatura, unidade_medida, data_temperatura, temp_maxima, temp_minima, id_cliente, data_hora_registro) VALUES (84, '°C', '2020-01-26', 27.30, 23.90, 12, '2020-01-26 12:18:31.658637');
INSERT INTO tb_temperatura (id_temperatura, unidade_medida, data_temperatura, temp_maxima, temp_minima, id_cliente, data_hora_registro) VALUES (85, '°C', '2020-02-02', 28.00, 20.00, 11, '2020-02-02 14:05:12.25154');
INSERT INTO tb_temperatura (id_temperatura, unidade_medida, data_temperatura, temp_maxima, temp_minima, id_cliente, data_hora_registro) VALUES (1, '°C', '2018-01-02', 23.90, 22.30, 1, '2019-06-23 23:38:03.561041');
INSERT INTO tb_temperatura (id_temperatura, unidade_medida, data_temperatura, temp_maxima, temp_minima, id_cliente, data_hora_registro) VALUES (2, '°C', '2018-01-03', 21.30, 19.90, 1, '2019-06-23 23:38:03.561041');
INSERT INTO tb_temperatura (id_temperatura, unidade_medida, data_temperatura, temp_maxima, temp_minima, id_cliente, data_hora_registro) VALUES (3, '°C', '2018-01-04', 28.90, 17.40, 1, '2019-06-23 23:38:03.561041');
INSERT INTO tb_temperatura (id_temperatura, unidade_medida, data_temperatura, temp_maxima, temp_minima, id_cliente, data_hora_registro) VALUES (4, '°C', '2018-01-05', 30.20, 18.90, 1, '2019-06-23 23:38:03.561041');
INSERT INTO tb_temperatura (id_temperatura, unidade_medida, data_temperatura, temp_maxima, temp_minima, id_cliente, data_hora_registro) VALUES (6, '°C', '2018-01-07', 30.30, 20.50, 1, '2019-06-23 23:38:03.561041');
INSERT INTO tb_temperatura (id_temperatura, unidade_medida, data_temperatura, temp_maxima, temp_minima, id_cliente, data_hora_registro) VALUES (7, '°C', '2018-01-08', 31.50, 21.10, 1, '2019-06-23 23:38:03.561041');
INSERT INTO tb_temperatura (id_temperatura, unidade_medida, data_temperatura, temp_maxima, temp_minima, id_cliente, data_hora_registro) VALUES (8, '°C', '2018-01-09', 31.20, 19.80, 1, '2019-06-23 23:38:03.561041');
INSERT INTO tb_temperatura (id_temperatura, unidade_medida, data_temperatura, temp_maxima, temp_minima, id_cliente, data_hora_registro) VALUES (9, '°C', '2018-01-10', 28.20, 21.30, 1, '2019-06-23 23:38:03.561041');
INSERT INTO tb_temperatura (id_temperatura, unidade_medida, data_temperatura, temp_maxima, temp_minima, id_cliente, data_hora_registro) VALUES (10, '°C', '2018-01-11', 26.60, 21.50, 1, '2019-06-23 23:38:03.561041');
INSERT INTO tb_temperatura (id_temperatura, unidade_medida, data_temperatura, temp_maxima, temp_minima, id_cliente, data_hora_registro) VALUES (11, '°C', '2018-01-12', 27.30, 21.00, 1, '2019-06-23 23:38:03.561041');
INSERT INTO tb_temperatura (id_temperatura, unidade_medida, data_temperatura, temp_maxima, temp_minima, id_cliente, data_hora_registro) VALUES (12, '°C', '2018-01-13', 29.50, 21.40, 1, '2019-06-23 23:38:03.561041');
INSERT INTO tb_temperatura (id_temperatura, unidade_medida, data_temperatura, temp_maxima, temp_minima, id_cliente, data_hora_registro) VALUES (13, '°C', '2018-01-14', 25.90, 22.10, 1, '2019-06-23 23:38:03.561041');
INSERT INTO tb_temperatura (id_temperatura, unidade_medida, data_temperatura, temp_maxima, temp_minima, id_cliente, data_hora_registro) VALUES (14, '°C', '2018-01-15', 26.00, 22.00, 1, '2019-06-23 23:38:03.561041');
INSERT INTO tb_temperatura (id_temperatura, unidade_medida, data_temperatura, temp_maxima, temp_minima, id_cliente, data_hora_registro) VALUES (15, '°C', '2018-01-16', 27.10, 22.10, 1, '2019-06-23 23:38:03.561041');
INSERT INTO tb_temperatura (id_temperatura, unidade_medida, data_temperatura, temp_maxima, temp_minima, id_cliente, data_hora_registro) VALUES (16, '°C', '2018-01-17', 27.80, 22.10, 1, '2019-06-23 23:38:03.561041');
INSERT INTO tb_temperatura (id_temperatura, unidade_medida, data_temperatura, temp_maxima, temp_minima, id_cliente, data_hora_registro) VALUES (17, '°C', '2018-01-18', 29.10, 21.40, 1, '2019-06-23 23:38:03.561041');
INSERT INTO tb_temperatura (id_temperatura, unidade_medida, data_temperatura, temp_maxima, temp_minima, id_cliente, data_hora_registro) VALUES (18, '°C', '2018-01-19', 30.40, 21.70, 1, '2019-06-23 23:38:03.561041');
INSERT INTO tb_temperatura (id_temperatura, unidade_medida, data_temperatura, temp_maxima, temp_minima, id_cliente, data_hora_registro) VALUES (19, '°C', '2018-01-20', 27.90, 21.80, 1, '2019-06-23 23:38:03.561041');
INSERT INTO tb_temperatura (id_temperatura, unidade_medida, data_temperatura, temp_maxima, temp_minima, id_cliente, data_hora_registro) VALUES (20, '°C', '2018-01-21', 23.90, 21.80, 1, '2019-06-23 23:38:03.561041');
INSERT INTO tb_temperatura (id_temperatura, unidade_medida, data_temperatura, temp_maxima, temp_minima, id_cliente, data_hora_registro) VALUES (21, '°C', '2018-01-22', 30.00, 21.60, 1, '2019-06-23 23:38:03.561041');
INSERT INTO tb_temperatura (id_temperatura, unidade_medida, data_temperatura, temp_maxima, temp_minima, id_cliente, data_hora_registro) VALUES (22, '°C', '2018-01-23', 30.10, 21.40, 1, '2019-06-23 23:38:03.561041');
INSERT INTO tb_temperatura (id_temperatura, unidade_medida, data_temperatura, temp_maxima, temp_minima, id_cliente, data_hora_registro) VALUES (23, '°C', '2018-01-24', 32.00, 20.70, 1, '2019-06-23 23:38:03.561041');
INSERT INTO tb_temperatura (id_temperatura, unidade_medida, data_temperatura, temp_maxima, temp_minima, id_cliente, data_hora_registro) VALUES (24, '°C', '2018-01-25', 31.30, 20.80, 1, '2019-06-23 23:38:03.561041');
INSERT INTO tb_temperatura (id_temperatura, unidade_medida, data_temperatura, temp_maxima, temp_minima, id_cliente, data_hora_registro) VALUES (25, '°C', '2018-01-26', 29.30, 21.80, 1, '2019-06-23 23:38:03.561041');
INSERT INTO tb_temperatura (id_temperatura, unidade_medida, data_temperatura, temp_maxima, temp_minima, id_cliente, data_hora_registro) VALUES (27, '°C', '2018-01-28', 29.80, 21.70, 1, '2019-06-23 23:38:03.561041');
INSERT INTO tb_temperatura (id_temperatura, unidade_medida, data_temperatura, temp_maxima, temp_minima, id_cliente, data_hora_registro) VALUES (28, '°C', '2018-01-29', 30.20, 21.80, 1, '2019-06-23 23:38:03.561041');
INSERT INTO tb_temperatura (id_temperatura, unidade_medida, data_temperatura, temp_maxima, temp_minima, id_cliente, data_hora_registro) VALUES (29, '°C', '2018-01-30', 29.80, 20.00, 1, '2019-06-23 23:38:03.561041');
INSERT INTO tb_temperatura (id_temperatura, unidade_medida, data_temperatura, temp_maxima, temp_minima, id_cliente, data_hora_registro) VALUES (30, '°C', '2018-01-31', 30.90, 20.00, 1, '2019-06-23 23:38:03.561041');
INSERT INTO tb_temperatura (id_temperatura, unidade_medida, data_temperatura, temp_maxima, temp_minima, id_cliente, data_hora_registro) VALUES (31, '°C', '2018-02-01', 31.30, 19.60, 1, '2019-06-23 23:38:03.561041');
INSERT INTO tb_temperatura (id_temperatura, unidade_medida, data_temperatura, temp_maxima, temp_minima, id_cliente, data_hora_registro) VALUES (32, '°C', '2018-02-02', 31.60, 19.10, 1, '2019-06-23 23:38:03.561041');
INSERT INTO tb_temperatura (id_temperatura, unidade_medida, data_temperatura, temp_maxima, temp_minima, id_cliente, data_hora_registro) VALUES (33, '°C', '2018-02-03', 31.90, 18.20, 1, '2019-06-23 23:38:03.561041');
INSERT INTO tb_temperatura (id_temperatura, unidade_medida, data_temperatura, temp_maxima, temp_minima, id_cliente, data_hora_registro) VALUES (34, '°C', '2018-02-04', 31.70, 18.50, 1, '2019-06-23 23:38:03.561041');
INSERT INTO tb_temperatura (id_temperatura, unidade_medida, data_temperatura, temp_maxima, temp_minima, id_cliente, data_hora_registro) VALUES (35, '°C', '2018-02-05', 31.90, 18.90, 1, '2019-06-23 23:38:03.561041');
INSERT INTO tb_temperatura (id_temperatura, unidade_medida, data_temperatura, temp_maxima, temp_minima, id_cliente, data_hora_registro) VALUES (36, '°C', '2018-02-06', 31.80, 18.90, 1, '2019-06-23 23:38:03.561041');
INSERT INTO tb_temperatura (id_temperatura, unidade_medida, data_temperatura, temp_maxima, temp_minima, id_cliente, data_hora_registro) VALUES (37, '°C', '2018-02-07', 32.30, 20.10, 1, '2019-06-23 23:38:03.561041');
INSERT INTO tb_temperatura (id_temperatura, unidade_medida, data_temperatura, temp_maxima, temp_minima, id_cliente, data_hora_registro) VALUES (38, '°C', '2018-02-08', 31.20, 20.10, 1, '2019-06-23 23:38:03.561041');
INSERT INTO tb_temperatura (id_temperatura, unidade_medida, data_temperatura, temp_maxima, temp_minima, id_cliente, data_hora_registro) VALUES (39, '°C', '2018-02-09', 32.90, 21.50, 1, '2019-06-23 23:38:03.561041');
INSERT INTO tb_temperatura (id_temperatura, unidade_medida, data_temperatura, temp_maxima, temp_minima, id_cliente, data_hora_registro) VALUES (40, '°C', '2018-02-10', 30.10, 21.70, 1, '2019-06-23 23:38:03.561041');
INSERT INTO tb_temperatura (id_temperatura, unidade_medida, data_temperatura, temp_maxima, temp_minima, id_cliente, data_hora_registro) VALUES (41, '°C', '2018-02-11', 29.30, 22.80, 1, '2019-06-23 23:38:03.561041');
INSERT INTO tb_temperatura (id_temperatura, unidade_medida, data_temperatura, temp_maxima, temp_minima, id_cliente, data_hora_registro) VALUES (42, '°C', '2018-02-12', 29.30, 19.10, 1, '2019-06-23 23:38:03.561041');
INSERT INTO tb_temperatura (id_temperatura, unidade_medida, data_temperatura, temp_maxima, temp_minima, id_cliente, data_hora_registro) VALUES (43, '°C', '2018-02-13', 29.30, 17.60, 1, '2019-06-23 23:38:03.561041');
INSERT INTO tb_temperatura (id_temperatura, unidade_medida, data_temperatura, temp_maxima, temp_minima, id_cliente, data_hora_registro) VALUES (44, '°C', '2018-02-14', 28.50, 18.30, 1, '2019-06-23 23:38:03.561041');
INSERT INTO tb_temperatura (id_temperatura, unidade_medida, data_temperatura, temp_maxima, temp_minima, id_cliente, data_hora_registro) VALUES (45, '°C', '2018-02-15', 29.10, 17.90, 1, '2019-06-23 23:38:03.561041');
INSERT INTO tb_temperatura (id_temperatura, unidade_medida, data_temperatura, temp_maxima, temp_minima, id_cliente, data_hora_registro) VALUES (46, '°C', '2018-02-16', 30.00, 19.10, 1, '2019-06-23 23:38:03.561041');
INSERT INTO tb_temperatura (id_temperatura, unidade_medida, data_temperatura, temp_maxima, temp_minima, id_cliente, data_hora_registro) VALUES (47, '°C', '2018-02-17', 32.30, 19.10, 1, '2019-06-23 23:38:03.561041');
INSERT INTO tb_temperatura (id_temperatura, unidade_medida, data_temperatura, temp_maxima, temp_minima, id_cliente, data_hora_registro) VALUES (48, '°C', '2018-02-18', 29.10, 20.20, 1, '2019-06-23 23:38:03.561041');
INSERT INTO tb_temperatura (id_temperatura, unidade_medida, data_temperatura, temp_maxima, temp_minima, id_cliente, data_hora_registro) VALUES (49, '°C', '2018-02-19', 27.20, 21.30, 1, '2019-06-23 23:38:03.561041');
INSERT INTO tb_temperatura (id_temperatura, unidade_medida, data_temperatura, temp_maxima, temp_minima, id_cliente, data_hora_registro) VALUES (50, '°C', '2018-02-20', 24.30, 20.90, 1, '2019-06-23 23:38:03.561041');
INSERT INTO tb_temperatura (id_temperatura, unidade_medida, data_temperatura, temp_maxima, temp_minima, id_cliente, data_hora_registro) VALUES (51, '°C', '2018-02-21', 26.70, 18.70, 1, '2019-06-23 23:38:03.561041');
INSERT INTO tb_temperatura (id_temperatura, unidade_medida, data_temperatura, temp_maxima, temp_minima, id_cliente, data_hora_registro) VALUES (52, '°C', '2018-02-22', 28.60, 18.00, 1, '2019-06-23 23:38:03.561041');
INSERT INTO tb_temperatura (id_temperatura, unidade_medida, data_temperatura, temp_maxima, temp_minima, id_cliente, data_hora_registro) VALUES (53, '°C', '2018-02-23', 27.00, 16.10, 1, '2019-06-23 23:38:03.561041');
INSERT INTO tb_temperatura (id_temperatura, unidade_medida, data_temperatura, temp_maxima, temp_minima, id_cliente, data_hora_registro) VALUES (54, '°C', '2018-02-24', 29.30, 16.50, 1, '2019-06-23 23:38:03.561041');
INSERT INTO tb_temperatura (id_temperatura, unidade_medida, data_temperatura, temp_maxima, temp_minima, id_cliente, data_hora_registro) VALUES (55, '°C', '2018-02-25', 30.50, 18.90, 1, '2019-06-23 23:38:03.561041');
INSERT INTO tb_temperatura (id_temperatura, unidade_medida, data_temperatura, temp_maxima, temp_minima, id_cliente, data_hora_registro) VALUES (56, '°C', '2018-02-26', 31.30, 20.10, 1, '2019-06-23 23:38:03.561041');
INSERT INTO tb_temperatura (id_temperatura, unidade_medida, data_temperatura, temp_maxima, temp_minima, id_cliente, data_hora_registro) VALUES (57, '°C', '2018-02-27', 31.50, 19.80, 1, '2019-06-23 23:38:03.561041');
INSERT INTO tb_temperatura (id_temperatura, unidade_medida, data_temperatura, temp_maxima, temp_minima, id_cliente, data_hora_registro) VALUES (58, '°C', '2018-02-28', 29.20, 21.50, 1, '2019-06-23 23:38:03.561041');
INSERT INTO tb_temperatura (id_temperatura, unidade_medida, data_temperatura, temp_maxima, temp_minima, id_cliente, data_hora_registro) VALUES (59, '°C', '2018-03-01', 29.30, 22.70, 1, '2019-06-23 23:38:03.561041');
INSERT INTO tb_temperatura (id_temperatura, unidade_medida, data_temperatura, temp_maxima, temp_minima, id_cliente, data_hora_registro) VALUES (60, '°C', '2018-03-02', 30.40, 22.30, 1, '2019-06-23 23:38:03.561041');
INSERT INTO tb_temperatura (id_temperatura, unidade_medida, data_temperatura, temp_maxima, temp_minima, id_cliente, data_hora_registro) VALUES (61, '°C', '2018-03-03', 31.70, 23.10, 1, '2019-06-23 23:38:03.561041');
INSERT INTO tb_temperatura (id_temperatura, unidade_medida, data_temperatura, temp_maxima, temp_minima, id_cliente, data_hora_registro) VALUES (62, '°C', '2018-03-04', 30.20, 21.00, 1, '2019-06-23 23:38:03.561041');
INSERT INTO tb_temperatura (id_temperatura, unidade_medida, data_temperatura, temp_maxima, temp_minima, id_cliente, data_hora_registro) VALUES (63, '°C', '2018-03-05', 30.40, 22.10, 1, '2019-06-23 23:38:03.561041');
INSERT INTO tb_temperatura (id_temperatura, unidade_medida, data_temperatura, temp_maxima, temp_minima, id_cliente, data_hora_registro) VALUES (64, '°C', '2018-03-06', 28.50, 21.20, 1, '2019-06-23 23:38:03.561041');
INSERT INTO tb_temperatura (id_temperatura, unidade_medida, data_temperatura, temp_maxima, temp_minima, id_cliente, data_hora_registro) VALUES (65, '°C', '2018-03-07', 27.60, 16.50, 1, '2019-06-23 23:38:03.561041');
INSERT INTO tb_temperatura (id_temperatura, unidade_medida, data_temperatura, temp_maxima, temp_minima, id_cliente, data_hora_registro) VALUES (66, '°C', '2018-03-08', 30.20, 16.60, 1, '2019-06-23 23:38:03.561041');
INSERT INTO tb_temperatura (id_temperatura, unidade_medida, data_temperatura, temp_maxima, temp_minima, id_cliente, data_hora_registro) VALUES (67, '°C', '2018-03-09', 29.50, 18.20, 1, '2019-06-23 23:38:03.561041');
INSERT INTO tb_temperatura (id_temperatura, unidade_medida, data_temperatura, temp_maxima, temp_minima, id_cliente, data_hora_registro) VALUES (68, '°C', '2018-03-10', 31.10, 20.60, 1, '2019-06-23 23:38:03.561041');
INSERT INTO tb_temperatura (id_temperatura, unidade_medida, data_temperatura, temp_maxima, temp_minima, id_cliente, data_hora_registro) VALUES (69, '°C', '2018-03-11', 32.30, 21.30, 1, '2019-06-23 23:38:03.561041');
INSERT INTO tb_temperatura (id_temperatura, unidade_medida, data_temperatura, temp_maxima, temp_minima, id_cliente, data_hora_registro) VALUES (70, '°C', '2018-03-12', 32.10, 20.10, 1, '2019-06-23 23:39:28.705644');
INSERT INTO tb_temperatura (id_temperatura, unidade_medida, data_temperatura, temp_maxima, temp_minima, id_cliente, data_hora_registro) VALUES (72, '°C', '2019-06-23', 30.00, 15.00, 2, '2019-06-23 23:40:33.319731');
INSERT INTO tb_temperatura (id_temperatura, unidade_medida, data_temperatura, temp_maxima, temp_minima, id_cliente, data_hora_registro) VALUES (71, '°C', '2019-06-01', 25.00, 15.00, 1, '2019-06-23 23:38:58.272611');
INSERT INTO tb_temperatura (id_temperatura, unidade_medida, data_temperatura, temp_maxima, temp_minima, id_cliente, data_hora_registro) VALUES (73, '°C', '2019-06-01', 26.50, 18.40, 6, '2019-06-24 11:18:23.915149');
INSERT INTO tb_temperatura (id_temperatura, unidade_medida, data_temperatura, temp_maxima, temp_minima, id_cliente, data_hora_registro) VALUES (75, '°C', '2019-06-02', 28.00, 18.00, 1, '2019-06-24 14:59:54.291206');
INSERT INTO tb_temperatura (id_temperatura, unidade_medida, data_temperatura, temp_maxima, temp_minima, id_cliente, data_hora_registro) VALUES (76, '°C', '2019-06-24', 30.00, 20.00, 7, '2019-06-24 17:36:44.507838');
INSERT INTO tb_temperatura (id_temperatura, unidade_medida, data_temperatura, temp_maxima, temp_minima, id_cliente, data_hora_registro) VALUES (77, '°C', '2019-06-24', 40.00, 10.00, 8, '2019-06-24 17:39:08.309914');
INSERT INTO tb_temperatura (id_temperatura, unidade_medida, data_temperatura, temp_maxima, temp_minima, id_cliente, data_hora_registro) VALUES (79, '°C', '2019-06-24', 30.00, 10.00, 1, '2019-06-24 17:48:53.681506');
INSERT INTO tb_temperatura (id_temperatura, unidade_medida, data_temperatura, temp_maxima, temp_minima, id_cliente, data_hora_registro) VALUES (80, '°C', '2019-06-24', 30.50, 10.30, 9, '2019-06-24 18:03:39.600337');


--
-- TOC entry 2289 (class 0 OID 30988)
-- Dependencies: 184
-- Data for Name: tb_umidade; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2142 (class 2606 OID 31093)
-- Name: pkey_cidade; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tb_cidade
    ADD CONSTRAINT pkey_cidade PRIMARY KEY (id_cidade);


--
-- TOC entry 2120 (class 2606 OID 31029)
-- Name: pkey_cliente; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tb_cliente
    ADD CONSTRAINT pkey_cliente PRIMARY KEY (id_cliente);


--
-- TOC entry 2127 (class 2606 OID 31057)
-- Name: pkey_endereco; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tb_endereco
    ADD CONSTRAINT pkey_endereco PRIMARY KEY (id_endereco);


--
-- TOC entry 2124 (class 2606 OID 31047)
-- Name: pkey_estado; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tb_estado
    ADD CONSTRAINT pkey_estado PRIMARY KEY (id_estado);


--
-- TOC entry 2111 (class 2606 OID 31006)
-- Name: pkey_evapotranspiracao; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tb_evapotranspiracao
    ADD CONSTRAINT pkey_evapotranspiracao PRIMARY KEY (id_evapotranspiracao);


--
-- TOC entry 2150 (class 2606 OID 31128)
-- Name: pkey_gastoenergia; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tb_gastoenergia
    ADD CONSTRAINT pkey_gastoenergia PRIMARY KEY (id_gastoenergia);


--
-- TOC entry 2139 (class 2606 OID 31083)
-- Name: pkey_irrigacao; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tb_irrigacao
    ADD CONSTRAINT pkey_irrigacao PRIMARY KEY (id_irrigacao);


--
-- TOC entry 2134 (class 2606 OID 31071)
-- Name: pkey_log_registros; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tb_log_registros
    ADD CONSTRAINT pkey_log_registros PRIMARY KEY (id_log_registros);


--
-- TOC entry 2122 (class 2606 OID 31038)
-- Name: pkey_login; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tb_login
    ADD CONSTRAINT pkey_login PRIMARY KEY (id_login);


--
-- TOC entry 2148 (class 2606 OID 31120)
-- Name: pkey_modeloequipamentoevapo; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tb_modeloequipamentoevapo
    ADD CONSTRAINT pkey_modeloequipamentoevapo PRIMARY KEY (id_modeloequipamentoevapo);


--
-- TOC entry 2146 (class 2606 OID 31111)
-- Name: pkey_modeloirrigacao; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tb_modeloirrigacao
    ADD CONSTRAINT pkey_modeloirrigacao PRIMARY KEY (id_modeloirrigacao);


--
-- TOC entry 2144 (class 2606 OID 31102)
-- Name: pkey_ocorrencias; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tb_ocorrencias
    ADD CONSTRAINT pkey_ocorrencias PRIMARY KEY (id_ocorrencia);


--
-- TOC entry 2115 (class 2606 OID 31017)
-- Name: pkey_pluviometria; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tb_pluviometria
    ADD CONSTRAINT pkey_pluviometria PRIMARY KEY (id_pluviometria);


--
-- TOC entry 2152 (class 2606 OID 48533)
-- Name: pkey_temparduino; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tb_temparduino
    ADD CONSTRAINT pkey_temparduino PRIMARY KEY (id_temparduino);


--
-- TOC entry 2104 (class 2606 OID 30985)
-- Name: pkey_temperatura; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tb_temperatura
    ADD CONSTRAINT pkey_temperatura PRIMARY KEY (id_temperatura);


--
-- TOC entry 2107 (class 2606 OID 30995)
-- Name: pkey_umidade; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tb_umidade
    ADD CONSTRAINT pkey_umidade PRIMARY KEY (id_umidade);


--
-- TOC entry 2140 (class 1259 OID 31091)
-- Name: ix_relationship1; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX ix_relationship1 ON tb_cidade USING btree (id_estado);


--
-- TOC entry 2128 (class 1259 OID 31066)
-- Name: ix_relationship10; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX ix_relationship10 ON tb_log_registros USING btree (id_umidade);


--
-- TOC entry 2129 (class 1259 OID 31067)
-- Name: ix_relationship11; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX ix_relationship11 ON tb_log_registros USING btree (id_evapotranspiracao);


--
-- TOC entry 2130 (class 1259 OID 31068)
-- Name: ix_relationship12; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX ix_relationship12 ON tb_log_registros USING btree (id_pluviometria);


--
-- TOC entry 2116 (class 1259 OID 31026)
-- Name: ix_relationship13; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX ix_relationship13 ON tb_cliente USING btree (id_login);


--
-- TOC entry 2131 (class 1259 OID 31069)
-- Name: ix_relationship14; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX ix_relationship14 ON tb_log_registros USING btree (id_irrigacao);


--
-- TOC entry 2117 (class 1259 OID 31027)
-- Name: ix_relationship15; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX ix_relationship15 ON tb_cliente USING btree (id_estado);


--
-- TOC entry 2125 (class 1259 OID 31055)
-- Name: ix_relationship18; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX ix_relationship18 ON tb_endereco USING btree (id_cidade);


--
-- TOC entry 2112 (class 1259 OID 31015)
-- Name: ix_relationship19; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX ix_relationship19 ON tb_pluviometria USING btree (id_ocorrencia);


--
-- TOC entry 2118 (class 1259 OID 31025)
-- Name: ix_relationship2; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX ix_relationship2 ON tb_cliente USING btree (id_endereco);


--
-- TOC entry 2135 (class 1259 OID 31080)
-- Name: ix_relationship20; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX ix_relationship20 ON tb_irrigacao USING btree (id_modeloirrigacao);


--
-- TOC entry 2108 (class 1259 OID 31004)
-- Name: ix_relationship21; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX ix_relationship21 ON tb_evapotranspiracao USING btree (id_modeloequipamentoevapo);


--
-- TOC entry 2136 (class 1259 OID 31081)
-- Name: ix_relationship23; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX ix_relationship23 ON tb_irrigacao USING btree (id_gastoenergia);


--
-- TOC entry 2102 (class 1259 OID 30983)
-- Name: ix_relationship3; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX ix_relationship3 ON tb_temperatura USING btree (id_cliente);


--
-- TOC entry 2105 (class 1259 OID 30993)
-- Name: ix_relationship4; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX ix_relationship4 ON tb_umidade USING btree (id_cliente);


--
-- TOC entry 2109 (class 1259 OID 31003)
-- Name: ix_relationship5; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX ix_relationship5 ON tb_evapotranspiracao USING btree (id_cliente);


--
-- TOC entry 2113 (class 1259 OID 31014)
-- Name: ix_relationship6; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX ix_relationship6 ON tb_pluviometria USING btree (id_cliente);


--
-- TOC entry 2137 (class 1259 OID 31079)
-- Name: ix_relationship7; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX ix_relationship7 ON tb_irrigacao USING btree (id_cliente);


--
-- TOC entry 2132 (class 1259 OID 31065)
-- Name: ix_relationship9; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX ix_relationship9 ON tb_log_registros USING btree (id_temperatura);


--
-- TOC entry 2162 (class 2606 OID 31199)
-- Name: relationship1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tb_endereco
    ADD CONSTRAINT relationship1 FOREIGN KEY (id_cidade) REFERENCES tb_cidade(id_cidade);


--
-- TOC entry 2164 (class 2606 OID 31164)
-- Name: relationship10; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tb_log_registros
    ADD CONSTRAINT relationship10 FOREIGN KEY (id_umidade) REFERENCES tb_umidade(id_umidade);


--
-- TOC entry 2165 (class 2606 OID 31169)
-- Name: relationship11; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tb_log_registros
    ADD CONSTRAINT relationship11 FOREIGN KEY (id_evapotranspiracao) REFERENCES tb_evapotranspiracao(id_evapotranspiracao);


--
-- TOC entry 2166 (class 2606 OID 31174)
-- Name: relationship12; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tb_log_registros
    ADD CONSTRAINT relationship12 FOREIGN KEY (id_pluviometria) REFERENCES tb_pluviometria(id_pluviometria);


--
-- TOC entry 2160 (class 2606 OID 31179)
-- Name: relationship13; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tb_cliente
    ADD CONSTRAINT relationship13 FOREIGN KEY (id_login) REFERENCES tb_login(id_login);


--
-- TOC entry 2167 (class 2606 OID 31184)
-- Name: relationship14; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tb_log_registros
    ADD CONSTRAINT relationship14 FOREIGN KEY (id_irrigacao) REFERENCES tb_irrigacao(id_irrigacao);


--
-- TOC entry 2161 (class 2606 OID 31189)
-- Name: relationship15; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tb_cliente
    ADD CONSTRAINT relationship15 FOREIGN KEY (id_estado) REFERENCES tb_estado(id_estado);


--
-- TOC entry 2171 (class 2606 OID 31194)
-- Name: relationship16; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tb_cidade
    ADD CONSTRAINT relationship16 FOREIGN KEY (id_estado) REFERENCES tb_estado(id_estado);


--
-- TOC entry 2158 (class 2606 OID 31204)
-- Name: relationship19; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tb_pluviometria
    ADD CONSTRAINT relationship19 FOREIGN KEY (id_ocorrencia) REFERENCES tb_ocorrencias(id_ocorrencia);


--
-- TOC entry 2159 (class 2606 OID 31129)
-- Name: relationship2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tb_cliente
    ADD CONSTRAINT relationship2 FOREIGN KEY (id_endereco) REFERENCES tb_endereco(id_endereco);


--
-- TOC entry 2169 (class 2606 OID 31209)
-- Name: relationship20; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tb_irrigacao
    ADD CONSTRAINT relationship20 FOREIGN KEY (id_modeloirrigacao) REFERENCES tb_modeloirrigacao(id_modeloirrigacao);


--
-- TOC entry 2156 (class 2606 OID 31214)
-- Name: relationship21; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tb_evapotranspiracao
    ADD CONSTRAINT relationship21 FOREIGN KEY (id_modeloequipamentoevapo) REFERENCES tb_modeloequipamentoevapo(id_modeloequipamentoevapo);


--
-- TOC entry 2170 (class 2606 OID 31219)
-- Name: relationship23; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tb_irrigacao
    ADD CONSTRAINT relationship23 FOREIGN KEY (id_gastoenergia) REFERENCES tb_gastoenergia(id_gastoenergia);


--
-- TOC entry 2153 (class 2606 OID 31134)
-- Name: relationship3; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tb_temperatura
    ADD CONSTRAINT relationship3 FOREIGN KEY (id_cliente) REFERENCES tb_cliente(id_cliente);


--
-- TOC entry 2154 (class 2606 OID 31139)
-- Name: relationship4; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tb_umidade
    ADD CONSTRAINT relationship4 FOREIGN KEY (id_cliente) REFERENCES tb_cliente(id_cliente);


--
-- TOC entry 2155 (class 2606 OID 31144)
-- Name: relationship5; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tb_evapotranspiracao
    ADD CONSTRAINT relationship5 FOREIGN KEY (id_cliente) REFERENCES tb_cliente(id_cliente);


--
-- TOC entry 2157 (class 2606 OID 31149)
-- Name: relationship6; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tb_pluviometria
    ADD CONSTRAINT relationship6 FOREIGN KEY (id_cliente) REFERENCES tb_cliente(id_cliente);


--
-- TOC entry 2168 (class 2606 OID 31154)
-- Name: relationship7; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tb_irrigacao
    ADD CONSTRAINT relationship7 FOREIGN KEY (id_cliente) REFERENCES tb_cliente(id_cliente);


--
-- TOC entry 2163 (class 2606 OID 31159)
-- Name: relationship9; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tb_log_registros
    ADD CONSTRAINT relationship9 FOREIGN KEY (id_temperatura) REFERENCES tb_temperatura(id_temperatura);


--
-- TOC entry 2324 (class 0 OID 0)
-- Dependencies: 6
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2020-09-04 22:33:40

--
-- PostgreSQL database dump complete
--

