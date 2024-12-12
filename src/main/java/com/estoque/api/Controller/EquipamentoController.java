package com.estoque.api.Controller;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.estoque.api.Entity.Equipamento;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/api/equipamento")
public class EquipamentoController {/*
    @Autowired
    private EquipamentoService equipamentoService;

    @PostMapping
    public ResponseEntity<Equipamento> create(
        @RequestBody EquipamentoDTO equipamento
    ){
        EquipamentoDTO equipamentoDTO = new EquipamentoDTO(
            null, 
            equipamento.nomeEquipamento(),
            equipamento.descricaoEquipamento(), 
            new Date());
        Equipamento newEquipamento = this.equipamentoService.createEquipamento(equipamentoDTO);

        return ResponseEntity.ok(newEquipamento);
    }
        
    @GetMapping("/{id}")
    public EquipamentoDTO findById(@PathVariable UUID id) {
        return this.equipamentoService.findById(id);
    }

    @PutMapping("/{id}")
    public EquipamentoDTO update(@PathVariable UUID id, @RequestBody EquipamentoDTO equipamento) {
        return this.equipamentoService.update(id, equipamento);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        this.equipamentoService.deleteEquipamento(id);
    }

    
    @GetMapping
    public ResponseEntity<EquipamentoPageDTO> listAllEquipamento(
        @RequestParam(defaultValue = "0") int page, 
        @RequestParam(defaultValue = "10") int size){
            //
            EquipamentoPageDTO allEquipamento = this.equipamentoService.getAllEquipamento(page, size);
            return ResponseEntity.ok(allEquipamento);
    } */
}
