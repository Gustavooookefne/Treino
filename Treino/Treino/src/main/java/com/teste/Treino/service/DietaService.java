package com.teste.Treino.service;

import com.teste.Treino.dto.DietaDtos.DietaRequestDto;
import com.teste.Treino.dto.DietaDtos.DietaResponseDto;
import com.teste.Treino.mapper.DietaMapper;
import com.teste.Treino.model.Dieta;
import com.teste.Treino.repository.DietaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DietaService {

    private final DietaRepository repository;
    private final DietaMapper mapper;

    public DietaResponseDto salvar (DietaRequestDto dto) {
        Dieta dieta = new Dieta();

        dieta.setDetalhesDieta(dto.detalhesDieta());
        dieta.setNomeDieta(dto.nomeDieta());

        return mapper.paraDto(repository.save(dieta));
    }

    public List<DietaResponseDto> listarTodos () {
        return repository.findAll()
                .stream()
                .map(mapper::paraDto)
                .toList();
    }

    public DietaResponseDto listarPorId (long id) {
        Dieta dieta = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lista não encontrada"));

        return mapper.paraDto(dieta);
    }

    public DietaResponseDto atualizar (long id , DietaRequestDto dto){

        Dieta dieta = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dieta não encontrada"));

        dieta.setNomeDieta(dto.nomeDieta());
        dieta.setDetalhesDieta(dto.detalhesDieta());

        return mapper.paraDto(dieta);
    }

    public void deletar (long id){
        repository.deleteById(id);
    }
}
