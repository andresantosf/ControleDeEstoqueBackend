package com.estoque.api.Entity;

import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "tb_status_equipamento")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class StatusEquipamento {
    @Id
    @GeneratedValue
    @Column(name = "id_status_equipamento")
    private UUID id;

    @Column(name = "nome_status_equipamento")
    private String nomeStatusEquipamento;

    @Column(name = "descricao_status_equipamento")
    private String descricaoStatusEquipamento;
    
    @Column(name = "created_at")
    private Date created_at;
}
