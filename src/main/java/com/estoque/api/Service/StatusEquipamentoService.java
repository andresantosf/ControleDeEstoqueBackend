package com.estoque.api.Service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.estoque.api.Entity.StatusEquipamento;
import com.estoque.api.Entity.DTOs.StatusEquipamentoDTO;
import com.estoque.api.Entity.DTOs.StatusEquipamentoPageDTO;
import com.estoque.api.Entity.mapper.StatusEquipamentoMapper;
import com.estoque.api.Repository.StatusEquipamentoRepository;

@Service
public class StatusEquipamentoService {

    @Autowired
    private StatusEquipamentoRepository repository;

    @Autowired
    private StatusEquipamentoMapper tipoEquipamentoMapper;
    
    public StatusEquipamento createStatusEquipamento(StatusEquipamentoDTO data){
        StatusEquipamento newStatusEquipamento = new StatusEquipamento();

        newStatusEquipamento.setNomeStatusEquipamento(data.nomeStatusEquipamento());
        newStatusEquipamento.setDescricaoStatusEquipamento(data.descricaoStatusEquipamento());
        newStatusEquipamento.setCreated_at(data.created_at());

        repository.save(newStatusEquipamento);
        return newStatusEquipamento;
    }

    public List<StatusEquipamento> getAllStatus() {
        return this.repository.findAll();
    }

    public StatusEquipamentoPageDTO getAllStatusEquipamento(int page, int size){
        PageRequest pageable = PageRequest.of(page, size);
        Page<StatusEquipamento> tipoEquipamentoPage = this.repository.findAll(pageable);

        List<StatusEquipamentoDTO> listaStatusEquipamentos = tipoEquipamentoPage.map(tipoEquipamento -> new StatusEquipamentoDTO(
            tipoEquipamento.getId(), 
            tipoEquipamento.getNomeStatusEquipamento(), 
            tipoEquipamento.getDescricaoStatusEquipamento(), 
            tipoEquipamento.getCreated_at())).toList();
            
        return new StatusEquipamentoPageDTO(listaStatusEquipamentos, tipoEquipamentoPage.getTotalElements(), tipoEquipamentoPage.getTotalPages());
    }

    public void deleteStatusEquipamento(UUID uuid){
        repository.deleteById(uuid);
    }

    public StatusEquipamentoDTO findById(UUID id) {
        return repository.findById(id).map(tipoEquipamentoMapper::toDTO)
            .orElseThrow();
    }


    public StatusEquipamentoDTO update(UUID id, StatusEquipamentoDTO tipoEquipamentoDTO) {

        return repository.findById(id)
            .map(recordFound -> {
            recordFound.setNomeStatusEquipamento(tipoEquipamentoDTO.nomeStatusEquipamento());
            recordFound.setDescricaoStatusEquipamento(tipoEquipamentoDTO.descricaoStatusEquipamento());

            return tipoEquipamentoMapper.toDTO(repository.save(recordFound));
            })
            .orElseThrow();
    }

}
