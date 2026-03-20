package com.teste.Treino.controller;

import com.teste.Treino.dto.DietaDtos.DietaRequestDto;
import com.teste.Treino.dto.DietaDtos.DietaResponseDto;
import com.teste.Treino.model.Dieta;
import com.teste.Treino.service.DietaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dieta")
public class DietaController {

    private final DietaService service;

    public DietaController(DietaService dietaService) {
        this.service = dietaService;
    }

    @PostMapping
    public DietaResponseDto salvar (@RequestBody DietaRequestDto dietaRequestDto){
        return service.salvar(dietaRequestDto);
    }

    @GetMapping
    public List<DietaResponseDto> listarTodos (){
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public DietaResponseDto listarPorId (@PathVariable long id) {
        return service.listarPorId(id);
    }

    @PutMapping("/{id}")
    public DietaResponseDto atualizar (@RequestBody DietaRequestDto dietaRequestDto , @PathVariable long id){
        return service.atualizar(id , dietaRequestDto);
    }

    @DeleteMapping("/{id}")
    public void deletar (@PathVariable long id){
        service.deletar(id);
    }
}
