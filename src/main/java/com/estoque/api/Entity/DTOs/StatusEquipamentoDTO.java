package com.estoque.api.Entity.DTOs;

import java.util.Date;
import java.util.UUID;

public record StatusEquipamentoDTO(
    UUID id,
    String nomeStatusEquipamento,
    String descricaoStatusEquipamento,
    Date created_at) {     
    
}
