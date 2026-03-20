package com.teste.Treino.controller;

import com.teste.Treino.dto.UsuarioDtos.UsuarioRequestDto;
import com.teste.Treino.dto.UsuarioDtos.UsuarioResponseDto;
import com.teste.Treino.model.Usuario;
import com.teste.Treino.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/usuario")

public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public UsuarioResponseDto save(@RequestBody UsuarioRequestDto usuarioRequestDto){
        return usuarioService.salvar(usuarioRequestDto);
    }

    @GetMapping
    public List<UsuarioResponseDto> listarTodos(){
        return usuarioService.listarTodos();
    }

    @GetMapping("/{id}")
    public UsuarioResponseDto listarPorId (@PathVariable UUID id){
        return usuarioService.listarPorId(id);
    }

    @PutMapping("/{id}")
    public UsuarioResponseDto atualizar (@RequestBody UsuarioRequestDto usuarioRequestDto ,@PathVariable UUID id){
        return usuarioService.atualizar(id, usuarioRequestDto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable UUID id){
        usuarioService.deletar(id);
    }
}
