package com.estoque.api.Entity;

import java.security.Timestamp;
import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "tb_equipamento")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Equipamento {
    @Id
    @GeneratedValue
    @Column(name = "id_equipamento")
    private UUID id;

    @Column(name = "nome_do_equipamento")
    private String nome;

    @ManyToOne
    @JoinColumn(name = "id_tipo_equipamento")
    private TipoEquipamento tipoEquipamento;

    @ManyToOne
    @JoinColumn(name = "id_status_atual_equipamento")
    private StatusEquipamento statusAtualEquipamento;
    
    @Column(name = "numero_de_serie")
    private Integer numeroDeSerie;

    @Column(name = "created_at")
    private Timestamp created_at;
}
