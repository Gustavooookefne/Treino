package com.teste.Treino.controller;

import com.teste.Treino.dto.TreinoDtos.TreinoRequestDto;
import com.teste.Treino.dto.TreinoDtos.TreinoResponseDto;
import com.teste.Treino.model.Treino;
import com.teste.Treino.service.TreinoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/treino")
public class TreinoController {

    private final TreinoService service;

    public TreinoController(TreinoService service) {
        this.service = service;
    }

    @PostMapping
    public TreinoResponseDto salvar (@RequestBody TreinoRequestDto treinoRequestDto){
        return service.salvar(treinoRequestDto);
    }

    @GetMapping
    public List<TreinoResponseDto> listarTodos(){
        return service.listarTreinos();
    }

    @GetMapping("/{id}")
    public TreinoResponseDto listarPorId (@PathVariable long id) {
        return service.listarPorId(id);
    }

    @PutMapping("/{id}")
    public TreinoResponseDto atualizar (@RequestBody TreinoRequestDto treinoRequestDto , @PathVariable long id){
        return service.atualizar(id, treinoRequestDto);
    }

    @DeleteMapping("/{id}")
    public void deletar (@PathVariable long id){
        service.deletarTreino(id);
    }
}
