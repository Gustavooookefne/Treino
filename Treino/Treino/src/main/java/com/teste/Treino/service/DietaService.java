package com.teste.Treino.service;

import com.teste.Treino.dto.DietaDtos.DietaRequestDto;
import com.teste.Treino.model.Dieta;
import com.teste.Treino.repository.DietaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DietaService {

    private final DietaRepository repository;

    public Dieta salvar (DietaRequestDto dto) {
        Dieta dieta = new Dieta();

        dieta.setDetalhesDieta(dto.detalhesDieta());
        dieta.setNomeDieta(dto.nomeDieta());

        return repository.save(dieta);
    }

    public List<Dieta> listarTodos () {
        return repository.findAll();
    }

    public Dieta listarPorId (long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lista não encontrada"));
    }

    public Dieta atualizar (long id , DietaRequestDto dto){

        Dieta dieta = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dieta não encontrada"));

        dieta.setNomeDieta(dto.nomeDieta());
        dieta.setDetalhesDieta(dto.detalhesDieta());

        return repository.save(dieta);
    }

    public void deletar (long id){
        repository.deleteById(id);
    }
}
