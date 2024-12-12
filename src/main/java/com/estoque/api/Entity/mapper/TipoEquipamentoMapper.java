package com.estoque.api.Entity.mapper;


import org.springframework.stereotype.Component;

import com.estoque.api.Entity.TipoEquipamento;
import com.estoque.api.Entity.DTOs.TipoEquipamentoDTO;

@Component
public class TipoEquipamentoMapper {

  public TipoEquipamentoDTO toDTO(TipoEquipamento tipoEquipamento) {
    if (tipoEquipamento == null) {
      return null;
    }

    return new TipoEquipamentoDTO(tipoEquipamento.getId(), tipoEquipamento.getNomeTipoEquipamento(), tipoEquipamento.getDescricaoTipoEquipamento(), tipoEquipamento.getCreated_at());
  }

  public TipoEquipamento toEntity(TipoEquipamentoDTO tipoEquipamentoDTO) {
    if (tipoEquipamentoDTO == null) {
      return null;
    }

    TipoEquipamento tipoEquipamento = new TipoEquipamento();
    if (tipoEquipamentoDTO.id() != null) {
      tipoEquipamento.setId(tipoEquipamentoDTO.id());
    }

    tipoEquipamento.setNomeTipoEquipamento(tipoEquipamentoDTO.nomeTipoEquipamento());
    tipoEquipamento.setDescricaoTipoEquipamento(tipoEquipamentoDTO.descricaoTipoEquipamento());

    return tipoEquipamento;
  }

}
