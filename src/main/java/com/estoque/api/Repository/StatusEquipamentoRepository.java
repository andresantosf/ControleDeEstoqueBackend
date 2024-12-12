package com.estoque.api.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estoque.api.Entity.StatusEquipamento;

public interface StatusEquipamentoRepository extends JpaRepository<StatusEquipamento, UUID>{
    
}
