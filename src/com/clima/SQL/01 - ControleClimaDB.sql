

--    CREATE DATABASE  ControleClimaDB



-- Create tables section -------------------------------------------------

-- Table TB_temperatura

CREATE SEQUENCE public.sq_pkey_temperatura START 1;
CREATE TABLE TB_temperatura(
 id_temperatura BIGINT NOT NULL DEFAULT nextval('public.sq_pkey_temperatura'),
 unidade_medida Character varying(10) NOT NULL,
 data_temperatura DATE NOT NULL,
 temp_maxima Numeric(5,2) NOT NULL,
 temp_minima Numeric(5,2) NOT NULL,
 id_cliente Bigint NOT NULL,
 data_hora_registro Timestamp default current_timestamp
)
WITH (
 autovacuum_enabled=true)
;

-- Create indexes for table TB_temperatura

CREATE INDEX IX_Relationship3 ON TB_temperatura (id_cliente)
;

-- Add keys for table TB_temperatura

ALTER TABLE TB_temperatura ADD CONSTRAINT pkey_temperatura PRIMARY KEY (id_temperatura)
;

-- Table TB_umidade

CREATE SEQUENCE public.sq_pkey_umidade START 1;
CREATE TABLE TB_umidade(
 id_umidade BIGINT NOT NULL DEFAULT nextval('public.sq_pkey_umidade'),
 unidade_medida Character varying(10) NOT NULL,
 data_umidade DATE NOT NULL,
 umidade_maxima Numeric(4,2) NOT NULL,
 umidade_minima Numeric(4,2) NOT NULL,
 id_cliente Bigint NOT NULL,
 data_hora_registro Timestamp default current_timestamp
)
WITH (
 autovacuum_enabled=true)
;

-- Create indexes for table TB_umidade

CREATE INDEX IX_Relationship4 ON TB_umidade (id_cliente)
;

-- Add keys for table TB_umidade

ALTER TABLE TB_umidade ADD CONSTRAINT pkey_umidade PRIMARY KEY (id_umidade)
;

-- Table TB_evapotranspiracao

CREATE SEQUENCE public.sq_pkey_evapotranspiracao START 1;
CREATE TABLE TB_evapotranspiracao(
 id_evapotranspiracao Bigint NOT NULL DEFAULT nextval('public.sq_pkey_evapotranspiracao'),
 unidade_medida Character varying(10) NOT NULL,
 data_evapotranspiracao DATE NOT NULL,
 qtidade_evapo Numeric(4,2) NOT NULL,
 id_cliente Bigint NOT NULL,
 id_modeloEquipamentoEvapo Bigint,
 data_hora_registro Timestamp default current_timestamp
)
WITH (
 autovacuum_enabled=true)
;

-- Create indexes for table TB_evapotranspiracao

CREATE INDEX IX_Relationship5 ON TB_evapotranspiracao (id_cliente)
;

CREATE INDEX IX_Relationship21 ON TB_evapotranspiracao (id_modeloEquipamentoEvapo)
;

-- Add keys for table TB_evapotranspiracao

ALTER TABLE TB_evapotranspiracao ADD CONSTRAINT pkey_evapotranspiracao PRIMARY KEY (id_evapotranspiracao)
;

-- Table TB_pluviometria

CREATE SEQUENCE public.sq_pkey_pluviometria START 1;
CREATE TABLE TB_pluviometria(
 id_pluviometria Bigint NOT NULL DEFAULT nextval('public.sq_pkey_pluviometria'),
 unidade_medida Character varying(10) NOT NULL,
 data_pluviometria DATE NOT NULL,
 qtidade_chuva Numeric(5,2) NOT NULL,
 id_cliente Bigint NOT NULL,
 id_ocorrencia Bigint,
 data_hora_registro Timestamp default current_timestamp
)
WITH (
 autovacuum_enabled=true)
;

-- Create indexes for table TB_pluviometria

CREATE INDEX IX_Relationship6 ON TB_pluviometria (id_cliente)
;

CREATE INDEX IX_Relationship19 ON TB_pluviometria (id_ocorrencia)
;

-- Add keys for table TB_pluviometria

ALTER TABLE TB_pluviometria ADD CONSTRAINT pkey_pluviometria PRIMARY KEY (id_pluviometria)
;

-- Table TB_cliente

CREATE SEQUENCE public.sq_pkey_cliente START 1;
CREATE TABLE TB_cliente(
 id_cliente Bigint NOT NULL DEFAULT nextval('public.sq_pkey_cliente'),
 nome Character varying(64) NOT NULL,
 sobrenome Character varying(64) NOT NULL,
 situacao Character varying(32) NOT NULL,
 id_endereco Bigint NOT NULL,
 id_login Bigint NOT NULL,
 id_estado Bigint NOT NULL,
 data_hora_registro Timestamp default current_timestamp
)
WITH (
 autovacuum_enabled=true)
;
COMMENT ON COLUMN TB_cliente.situacao IS 'Ativo,
Inativo'
;

-- Create indexes for table TB_cliente

CREATE INDEX IX_Relationship2 ON TB_cliente (id_endereco)
;

CREATE INDEX IX_Relationship13 ON TB_cliente (id_login)
;

CREATE INDEX IX_Relationship15 ON TB_cliente (id_estado)
;

-- Add keys for table TB_cliente

ALTER TABLE TB_cliente ADD CONSTRAINT pkey_cliente PRIMARY KEY (id_cliente)
;

-- Table TB_login

CREATE SEQUENCE public.sq_pkey_login START 1;
CREATE TABLE TB_login(
 id_login Bigint NOT NULL DEFAULT nextval('public.sq_pkey_login'),
 login Character varying(32) NOT NULL,
 senha Character varying(32) NOT NULL,
 email Character varying(64) NOT NULL,
 Perfil Character varying(32) NOT NULL,
 data_hora_registro Timestamp default current_timestamp
)
WITH (
 autovacuum_enabled=true)
;

-- Add keys for table TB_login

ALTER TABLE TB_login ADD CONSTRAINT pkey_login PRIMARY KEY (id_login)
;

-- Table TB_estado

CREATE SEQUENCE public.sq_pkey_estado START 1;
CREATE TABLE TB_estado(
 id_estado Bigint NOT NULL DEFAULT nextval('public.sq_pkey_estado'),
 nome_estado Character varying(32) NOT NULL,
 mesorregiao Character varying(32) NOT NULL,
 UF Character varying(2) NOT NULL,
 data_hora_registro Timestamp default current_timestamp
)
WITH (
 autovacuum_enabled=true)
;

-- Add keys for table TB_estado

ALTER TABLE TB_estado ADD CONSTRAINT pkey_estado PRIMARY KEY (id_estado)
;

-- Table TB_endereco

CREATE SEQUENCE public.sq_pkey_endereco START 1;
CREATE TABLE TB_endereco(
 id_endereco Bigint NOT NULL DEFAULT nextval('public.sq_pkey_endereco'),
 rua Character varying(64),
 numero Character varying(32),
 --referencia Character varying(256),
 id_cidade Bigint NOT NULL,
 data_hora_registro Timestamp default current_timestamp
)
WITH (
 autovacuum_enabled=true)
;

-- Create indexes for table TB_endereco

CREATE INDEX IX_Relationship18 ON TB_endereco (id_cidade)
;

-- Add keys for table TB_endereco

ALTER TABLE TB_endereco ADD CONSTRAINT pkey_endereco PRIMARY KEY (id_endereco)
;

-- Table TB_log_registros

CREATE SEQUENCE public.sq_pkey_log_registros START 1;
CREATE TABLE TB_log_registros(
 id_log_registros Bigint NOT NULL DEFAULT nextval('public.sq_pkey_log_registros'),
 idCliente Integer NOT NULL,
 tabela Character varying(64) NOT NULL,
 tipo_log Character varying(32) NOT NULL,
 descricao Character varying(256) NOT NULL,
 id_temperatura Bigint,
 id_umidade Bigint,
 id_evapotranspiracao Bigint,
 id_pluviometria Bigint,
 id_irrigacao Bigint,
 data_hora_registro Timestamp default current_timestamp
)
WITH (
 autovacuum_enabled=true)
;
COMMENT ON COLUMN TB_log_registros.tipo_log IS 'Update
Exclusão'
;

-- Create indexes for table TB_log_registros

CREATE INDEX IX_Relationship9 ON TB_log_registros (id_temperatura)
;

CREATE INDEX IX_Relationship10 ON TB_log_registros (id_umidade)
;

CREATE INDEX IX_Relationship11 ON TB_log_registros (id_evapotranspiracao)
;

CREATE INDEX IX_Relationship12 ON TB_log_registros (id_pluviometria)
;

CREATE INDEX IX_Relationship14 ON TB_log_registros (id_irrigacao)
;

-- Add keys for table TB_log_registros

ALTER TABLE TB_log_registros ADD CONSTRAINT pkey_log_registros PRIMARY KEY (id_log_registros)
;

-- Table TB_irrigacao

CREATE SEQUENCE public.sq_pkey_irrigacao START 1;
CREATE TABLE TB_irrigacao(
 id_irrigacao Bigint NOT NULL DEFAULT nextval('public.sq_pkey_irrigacao'),
 area_irrigada Character varying(20) NOT NULL,
 lamina_agua Integer,
 tempo_irrigacao Character varying(10),
 cultivar Character varying(30),
 motor_cv Character varying(10),
 id_cliente Bigint NOT NULL,
 id_modeloIrrigacao Bigint,
 id_gastoEnergia Bigint,
 data_hora_registro Timestamp default current_timestamp
)
WITH (
 autovacuum_enabled=true)
;
COMMENT ON COLUMN TB_irrigacao.area_irrigada IS 'Tamanho da área em Hectare (ha).'
;
COMMENT ON COLUMN TB_irrigacao.lamina_agua IS 'Necessidade de água diária (irrigação - mm de chuva).'
;
COMMENT ON COLUMN TB_irrigacao.tempo_irrigacao IS 'Quantidade em Horas de acordo com recomendação.'
;
COMMENT ON COLUMN TB_irrigacao.motor_cv IS 'Qual o tamanho do motor em CV'
;

-- Create indexes for table TB_irrigacao

CREATE INDEX IX_Relationship7 ON TB_irrigacao (id_cliente)
;

CREATE INDEX IX_Relationship20 ON TB_irrigacao (id_modeloIrrigacao)
;

CREATE INDEX IX_Relationship23 ON TB_irrigacao (id_gastoEnergia)
;

-- Add keys for table TB_irrigacao

ALTER TABLE TB_irrigacao ADD CONSTRAINT pkey_irrigacao PRIMARY KEY (id_irrigacao)
;

-- Table TB_cidade

CREATE SEQUENCE public.sq_pkey_cidade START 1;
CREATE TABLE TB_cidade(
 id_cidade Bigint NOT NULL DEFAULT nextval('public.sq_pkey_cidade'),
 nome_cidade Character varying(64) NOT NULL,
 id_estado Bigint NOT NULL,
 data_hora_registro Timestamp default current_timestamp
)
WITH (
 autovacuum_enabled=true)
;

-- Create indexes for table TB_cidade

CREATE INDEX IX_Relationship1 ON TB_cidade (id_estado)
;

-- Add keys for table TB_cidade

ALTER TABLE TB_cidade ADD CONSTRAINT pkey_cidade PRIMARY KEY (id_cidade)
;

-- Table TB_ocorrencias

CREATE SEQUENCE public.sq_pkey_ocorrencia START 1;
CREATE TABLE TB_ocorrencias(
 id_ocorrencia Bigint NOT NULL DEFAULT nextval('public.sq_pkey_ocorrencia'),
 granizo Boolean,
 faltou_energia Boolean,
 data_hora_registro Timestamp default current_timestamp
)
WITH (
 autovacuum_enabled=true)
;

-- Add keys for table TB_ocorrencias

ALTER TABLE TB_ocorrencias ADD CONSTRAINT pkey_ocorrencias PRIMARY KEY (id_ocorrencia)
;

-- Table TB_modeloIrrigacao

CREATE SEQUENCE public.sq_pkey_modeloIrrigacao START 1;
CREATE TABLE TB_modeloIrrigacao(
 id_modeloIrrigacao Bigint NOT NULL DEFAULT nextval('public.sq_pkey_modeloIrrigacao'),
 modelo_descricao Character varying(64),
 data_hora_registro Timestamp default current_timestamp
)
WITH (
 autovacuum_enabled=true)
;

-- Add keys for table TB_modeloIrrigacao

ALTER TABLE TB_modeloIrrigacao ADD CONSTRAINT pkey_modeloIrrigacao PRIMARY KEY (id_modeloIrrigacao)
;

-- Table TB_modeloEquipamentoEvapo

CREATE SEQUENCE public.sq_pkey_modeloEquipamentoEvapo START 1;
CREATE TABLE TB_modeloEquipamentoEvapo(
 id_modeloEquipamentoEvapo Bigint NOT NULL DEFAULT nextval('public.sq_pkey_modeloEquipamentoEvapo'),
 modelo_descricao Character varying(64),
 data_hora_registro Timestamp default current_timestamp
)
WITH (
 autovacuum_enabled=true)
;

-- Add keys for table TB_modeloEquipamentoEvapo

ALTER TABLE TB_modeloEquipamentoEvapo ADD CONSTRAINT pkey_modeloEquipamentoEvapo PRIMARY KEY (id_modeloEquipamentoEvapo)
;

-- Table TB_gastoEnergia

CREATE SEQUENCE public.sq_pkey_gastoEnergia START 1;
CREATE TABLE TB_gastoEnergia(
 id_gastoEnergia Bigint NOT NULL DEFAULT nextval('public.sq_pkey_gastoEnergia'),
 possui_irrigacao_noturna Boolean,
 custo_energia_kWh Character varying(64),
 data_cadastro  DATE NOT NULL
)
WITH (
 autovacuum_enabled=true)
;
COMMENT ON COLUMN TB_gastoEnergia.custo_energia_kWh IS 'Custo da energia por Quilowatt-hora pago na região.'
;
-- Add keys for table TB_gastoEnergia

ALTER TABLE TB_gastoEnergia ADD CONSTRAINT pkey_gastoEnergia PRIMARY KEY (id_gastoEnergia)
;
-- Create foreign keys (relationships) section ------------------------------------------------- 

ALTER TABLE TB_cliente ADD CONSTRAINT Relationship2 FOREIGN KEY (id_endereco) REFERENCES TB_endereco (id_endereco) ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE TB_temperatura ADD CONSTRAINT Relationship3 FOREIGN KEY (id_cliente) REFERENCES TB_cliente (id_cliente) ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE TB_umidade ADD CONSTRAINT Relationship4 FOREIGN KEY (id_cliente) REFERENCES TB_cliente (id_cliente) ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE TB_evapotranspiracao ADD CONSTRAINT Relationship5 FOREIGN KEY (id_cliente) REFERENCES TB_cliente (id_cliente) ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE TB_pluviometria ADD CONSTRAINT Relationship6 FOREIGN KEY (id_cliente) REFERENCES TB_cliente (id_cliente) ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE TB_irrigacao ADD CONSTRAINT Relationship7 FOREIGN KEY (id_cliente) REFERENCES TB_cliente (id_cliente) ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE TB_log_registros ADD CONSTRAINT Relationship9 FOREIGN KEY (id_temperatura) REFERENCES TB_temperatura (id_temperatura) ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE TB_log_registros ADD CONSTRAINT Relationship10 FOREIGN KEY (id_umidade) REFERENCES TB_umidade (id_umidade) ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE TB_log_registros ADD CONSTRAINT Relationship11 FOREIGN KEY (id_evapotranspiracao) REFERENCES TB_evapotranspiracao (id_evapotranspiracao) ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE TB_log_registros ADD CONSTRAINT Relationship12 FOREIGN KEY (id_pluviometria) REFERENCES TB_pluviometria (id_pluviometria) ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE TB_cliente ADD CONSTRAINT Relationship13 FOREIGN KEY (id_login) REFERENCES TB_login (id_login) ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE TB_log_registros ADD CONSTRAINT Relationship14 FOREIGN KEY (id_irrigacao) REFERENCES TB_irrigacao (id_irrigacao) ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE TB_cliente ADD CONSTRAINT Relationship15 FOREIGN KEY (id_estado) REFERENCES TB_estado (id_estado) ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE TB_cidade ADD CONSTRAINT Relationship16 FOREIGN KEY (id_estado) REFERENCES TB_estado (id_estado) ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE TB_endereco ADD CONSTRAINT Relationship1 FOREIGN KEY (id_cidade) REFERENCES TB_cidade (id_cidade) ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE TB_pluviometria ADD CONSTRAINT Relationship19 FOREIGN KEY (id_ocorrencia) REFERENCES TB_ocorrencias (id_ocorrencia) ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE TB_irrigacao ADD CONSTRAINT Relationship20 FOREIGN KEY (id_modeloIrrigacao) REFERENCES TB_modeloIrrigacao (id_modeloIrrigacao) ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE TB_evapotranspiracao ADD CONSTRAINT Relationship21 FOREIGN KEY (id_modeloEquipamentoEvapo) REFERENCES TB_modeloEquipamentoEvapo (id_modeloEquipamentoEvapo) ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE TB_irrigacao ADD CONSTRAINT Relationship23 FOREIGN KEY (id_gastoEnergia) REFERENCES TB_gastoEnergia (id_gastoEnergia) ON DELETE NO ACTION ON UPDATE NO ACTION
;






