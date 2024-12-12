package com.estoque.api.Service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.estoque.api.Entity.StatusEquipamento;
import com.estoque.api.Entity.TipoEquipamento;
import com.estoque.api.Entity.DTOs.TipoEquipamentoDTO;
import com.estoque.api.Entity.DTOs.TipoEquipamentoPageDTO;
import com.estoque.api.Entity.mapper.TipoEquipamentoMapper;
import com.estoque.api.Repository.TipoEquipamentoRepository;

@Service
public class TipoEquipamentoService {

    @Autowired
    private TipoEquipamentoRepository repository;

    @Autowired
    private TipoEquipamentoMapper tipoEquipamentoMapper;
    
    public TipoEquipamento createTipoEquipamento(TipoEquipamentoDTO data){
        TipoEquipamento newTipoEquipamento = new TipoEquipamento();

        newTipoEquipamento.setNomeTipoEquipamento(data.nomeTipoEquipamento());
        newTipoEquipamento.setDescricaoTipoEquipamento(data.descricaoTipoEquipamento());
        newTipoEquipamento.setCreated_at(data.date());

        repository.save(newTipoEquipamento);
        return newTipoEquipamento;
    }
    
    public List<TipoEquipamento> getAllTipoEquipamento() {
        return this.repository.findAll();
    }

    public TipoEquipamentoPageDTO getAllTipoEquipamento(int page, int size){
        PageRequest pageable = PageRequest.of(page, size);
        Page<TipoEquipamento> tipoEquipamentoPage = this.repository.findAll(pageable);

        List<TipoEquipamentoDTO> listaTipoEquipamentos = tipoEquipamentoPage.map(tipoEquipamento -> new TipoEquipamentoDTO(
            tipoEquipamento.getId(), 
            tipoEquipamento.getNomeTipoEquipamento(), 
            tipoEquipamento.getDescricaoTipoEquipamento(), 
            tipoEquipamento.getCreated_at())).toList();
            
        return new TipoEquipamentoPageDTO(listaTipoEquipamentos, tipoEquipamentoPage.getTotalElements(), tipoEquipamentoPage.getTotalPages());
    }

    public void deleteTipoEquipamento(UUID uuid){
        repository.deleteById(uuid);
    }

    public TipoEquipamentoDTO findById(UUID id) {
        return repository.findById(id).map(tipoEquipamentoMapper::toDTO)
            .orElseThrow();
    }


    public TipoEquipamentoDTO update(UUID id, TipoEquipamentoDTO tipoEquipamentoDTO) {

        return repository.findById(id)
            .map(recordFound -> {
            recordFound.setNomeTipoEquipamento(tipoEquipamentoDTO.nomeTipoEquipamento());
            recordFound.setDescricaoTipoEquipamento(tipoEquipamentoDTO.descricaoTipoEquipamento());

            return tipoEquipamentoMapper.toDTO(repository.save(recordFound));
            })
            .orElseThrow();
    }

}
