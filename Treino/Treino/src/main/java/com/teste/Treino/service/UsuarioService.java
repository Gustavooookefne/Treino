package com.teste.Treino.service;

import com.teste.Treino.dto.UsuarioDtos.UsuarioRequestDto;
import com.teste.Treino.dto.UsuarioDtos.UsuarioResponseDto;
import com.teste.Treino.mapper.UsuarioMapper;
import com.teste.Treino.model.Usuario;
import com.teste.Treino.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UsuarioService {

    private final UsuarioRepository repository;
    private final UsuarioMapper mapper;

    public UsuarioResponseDto salvar (UsuarioRequestDto dto){
        Usuario usuario = new Usuario();

        usuario.setNome(dto.nome());
        usuario.setEmail(dto.email());
        usuario.setIdade(dto.idade());
        usuario.setPeso(dto.peso());
        usuario.setAltura(dto.altura());

        return mapper.paraDtos(repository.save(usuario));

    }

    public List<UsuarioResponseDto> listarTodos(){
        return repository.findAll()
                .stream()
                .map(mapper::paraDtos)
                .toList();
    }

    public UsuarioResponseDto listarPorId(UUID id){
        Usuario usuario = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario não encontrado" + id));

        return mapper.paraDtos(usuario);
    }

    public UsuarioResponseDto atualizar (UUID id, UsuarioRequestDto dto){

        Usuario usuario = repository.findById(id)

                .orElseThrow(() -> new RuntimeException("Usuario não encontrado"));

        usuario.setNome(dto.nome());
        usuario.setEmail(dto.email());
        usuario.setIdade(dto.idade());
        usuario.setPeso(dto.peso());
        usuario.setAltura(dto.altura());

        return mapper.paraDtos(usuario);
    }

    public void deletar (UUID id){
        repository.deleteById(id);
    }

}
