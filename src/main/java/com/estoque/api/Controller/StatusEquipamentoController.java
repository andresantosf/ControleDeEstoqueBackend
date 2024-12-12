package com.estoque.api.Controller;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.estoque.api.Entity.StatusEquipamento;
import com.estoque.api.Entity.DTOs.StatusEquipamentoDTO;
import com.estoque.api.Entity.DTOs.StatusEquipamentoPageDTO;
import com.estoque.api.Service.StatusEquipamentoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/api/statusEquipamento")
public class StatusEquipamentoController {
    @Autowired
    private StatusEquipamentoService statusEquipamentoService;

    @PostMapping
    public ResponseEntity<StatusEquipamento> create(
        @RequestBody StatusEquipamentoDTO statusEquipamento
    ){
        StatusEquipamentoDTO statusEquipamentoDTO = new StatusEquipamentoDTO(
            null, 
            statusEquipamento.nomeStatusEquipamento(),
            statusEquipamento.descricaoStatusEquipamento(), 
            new Date());
        StatusEquipamento newStatusEquipamento = this.statusEquipamentoService.createStatusEquipamento(statusEquipamentoDTO);

        return ResponseEntity.ok(newStatusEquipamento);
    }
        
    @GetMapping("/{id}")
    public StatusEquipamentoDTO findById(@PathVariable UUID id) {
        return this.statusEquipamentoService.findById(id);
    }

    @PutMapping("/{id}")
    public StatusEquipamentoDTO update(@PathVariable UUID id, @RequestBody StatusEquipamentoDTO statusEquipamento) {
        return this.statusEquipamentoService.update(id, statusEquipamento);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        this.statusEquipamentoService.deleteStatusEquipamento(id);
    }

    @GetMapping("/list")
    public ResponseEntity<List<StatusEquipamento>> getAllStatus() {
        List<StatusEquipamento> statusList = statusEquipamentoService.getAllStatus();
        return ResponseEntity.ok(statusList);
    }
    
    @GetMapping
    public ResponseEntity<StatusEquipamentoPageDTO> listPageStatusEquipamento(
        @RequestParam(defaultValue = "0") int page, 
        @RequestParam(defaultValue = "10") int size){
            StatusEquipamentoPageDTO allStatusEquipamento = this.statusEquipamentoService.getAllStatusEquipamento(page, size);
            return ResponseEntity.ok(allStatusEquipamento);
    }
}
