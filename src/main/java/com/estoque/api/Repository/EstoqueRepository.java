package com.estoque.api.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estoque.api.Entity.Equipamento;

public interface EstoqueRepository extends JpaRepository<Equipamento, UUID>{
    
}
