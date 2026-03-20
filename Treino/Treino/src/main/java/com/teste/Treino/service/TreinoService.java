package com.teste.Treino.service;

import com.teste.Treino.dto.TreinoDtos.TreinoRequestDto;
import com.teste.Treino.dto.TreinoDtos.TreinoResponseDto;
import com.teste.Treino.mapper.TreinoMapper;
import com.teste.Treino.model.Treino;
import com.teste.Treino.repository.TreinoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class TreinoService {

    private final TreinoRepository repository;
    private final TreinoMapper mapper;

    public TreinoResponseDto salvar(TreinoRequestDto dto){
        Treino treino = new Treino();

        treino.setDescricao(dto.descricao());
        treino.setTipo(dto.tipo());

        return mapper.paraDtos(repository.save(treino));
    }

    public List<TreinoResponseDto> listarTreinos(){

        return repository.findAll()
                .stream()
                .map(mapper::paraDtos)
                .toList();
    }

    public TreinoResponseDto listarPorId(long id){
        Treino treino = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lista não encontrada" + id));

        return mapper.paraDtos(treino);
    }

    public TreinoResponseDto atualizar (long id ,TreinoRequestDto dto){

        Treino treino = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Treino não encontrado"));

        treino.setDescricao(dto.descricao());
        treino.setTipo(dto.tipo());

        return mapper.paraDtos(treino);
    }

    public void deletarTreino (long id){
        repository.deleteById(id);
    }

}
