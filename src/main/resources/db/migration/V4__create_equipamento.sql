CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE tb_equipamento (
    id_equipamento UUID DEFAULT gen_random_uuid() Primary Key,
    nome_do_equipamento Varchar(100) NOT NULL,
    numero_de_serie integer NOT NULL,
    id_tipo_equipamento UUID,
    id_status_atual_equipamento UUID,
    FOREIGN KEY (id_status_atual_equipamento) REFERENCES tb_status_equipamento(id_status_equipamento),
    FOREIGN KEY (id_tipo_equipamento) REFERENCES tb_tipo_equipamento(id_tipo_equipamento) ON DELETE CASCADE,
    created_at TIMESTAMP NOT NULL
)