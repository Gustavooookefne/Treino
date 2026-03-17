package com.teste.Treino.service;

import com.teste.Treino.dto.UsuarioDtos.UsuarioRequestDto;
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

    public Usuario salvar (UsuarioRequestDto dto){
        Usuario usuario = new Usuario();

        usuario.setNome(dto.nome());
        usuario.setEmail(dto.email());
        usuario.setIdade(dto.idade());
        usuario.setPeso(dto.peso());
        usuario.setAltura(dto.altura());

        return repository.save(usuario);

    }

    public List<Usuario> listarTodos(){
        return repository.findAll();
    }

    public Usuario listarPorId(UUID id){
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario não encontrado" + id));
    }

    public Usuario atualizar (UUID id, UsuarioRequestDto dto){

        Usuario usuario = repository.findById(id)

                .orElseThrow(() -> new RuntimeException("Usuario não encontrado"));

        usuario.setNome(dto.nome());
        usuario.setEmail(dto.email());
        usuario.setIdade(dto.idade());
        usuario.setPeso(dto.peso());
        usuario.setAltura(dto.altura());

        return repository.save(usuario);
    }

    public void deletar (UUID id){
        repository.deleteById(id);
    }

}
