CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE tb_tipo_equipamento (
    id_tipo_equipamento UUID DEFAULT gen_random_uuid() Primary Key,
    nome_tipo_equipamento VARCHAR(100) NOT NULL, 
    descricao_tipo_equipamento VARCHAR(500) NOT NULL,
    created_at TIMESTAMP NOT NULL
)