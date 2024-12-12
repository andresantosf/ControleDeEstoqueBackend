CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE tb_historico_equipamentos (
    id_historico_equipamento UUID DEFAULT gen_random_uuid() Primary Key,
    data_mudanca_status TIMESTAMP NOT NULL,
    observacoes_historico VARCHAR(500) NOT NULL,
    id_equipamento UUID,
    id_status_equipamento UUID,
    id_erro_equipamento UUID,
    FOREIGN KEY (id_equipamento) REFERENCES tb_equipamento(id_equipamento),
    FOREIGN KEY (id_status_equipamento) REFERENCES tb_status_equipamento(id_status_equipamento),
    FOREIGN KEY (id_erro_equipamento) REFERENCES tb_erros_equipamento(id_erro_equipamento) 
)