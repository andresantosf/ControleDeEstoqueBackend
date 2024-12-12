CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE tb_erros_equipamento (
    id_erro_equipamento UUID DEFAULT gen_random_uuid() Primary Key,
    nome_erro_equipamento Varchar(100) NOT NULL,
    descricao_erro_equipamento Varchar(500) NOT NULL,
    created_at TIMESTAMP NOT NULL
)