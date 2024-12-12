package com.estoque.api.Entity.DTOs;

import java.util.List;

public record StatusEquipamentoPageDTO(
    List<StatusEquipamentoDTO> statusEquipamento, 
    long totalElements, 
    int totalPages) {
}
