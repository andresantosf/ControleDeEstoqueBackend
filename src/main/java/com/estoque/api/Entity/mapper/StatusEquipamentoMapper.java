package com.estoque.api.Entity.mapper;


import org.springframework.stereotype.Component;

import com.estoque.api.Entity.StatusEquipamento;
import com.estoque.api.Entity.DTOs.StatusEquipamentoDTO;

@Component
public class StatusEquipamentoMapper {

  public StatusEquipamentoDTO toDTO(StatusEquipamento tipoEquipamento) {
    if (tipoEquipamento == null) {
      return null;
    }

    return new StatusEquipamentoDTO(
      tipoEquipamento.getId(), 
      tipoEquipamento.getNomeStatusEquipamento(),
      tipoEquipamento.getDescricaoStatusEquipamento(), 
      tipoEquipamento.getCreated_at());
  }

  public StatusEquipamento toEntity(StatusEquipamentoDTO tipoEquipamentoDTO) {
    if (tipoEquipamentoDTO == null) {
      return null;
    }

    StatusEquipamento tipoEquipamento = new StatusEquipamento();
    if (tipoEquipamentoDTO.id() != null) {
      tipoEquipamento.setId(tipoEquipamentoDTO.id());
    }

    tipoEquipamento.setNomeStatusEquipamento(tipoEquipamentoDTO.nomeStatusEquipamento());
    tipoEquipamento.setDescricaoStatusEquipamento(tipoEquipamentoDTO.descricaoStatusEquipamento());

    return tipoEquipamento;
  }

}
