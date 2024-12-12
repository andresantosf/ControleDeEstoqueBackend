CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE tb_status_equipamento (
    id_status_equipamento UUID DEFAULT gen_random_uuid() Primary Key,
    nome_status_equipamento Varchar(50) NOT NULL,
    descricao_status_equipamento Varchar(200),
    created_at TIMESTAMP NOT NULL
)