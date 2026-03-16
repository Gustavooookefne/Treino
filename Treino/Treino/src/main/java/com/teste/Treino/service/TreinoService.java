package com.teste.Treino.service;

import com.teste.Treino.dto.TreinoDtos.TreinoRequestDto;
import com.teste.Treino.model.Treino;
import com.teste.Treino.repository.TreinoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TreinoService {

    private final TreinoRepository repository;

    public Treino salvar(TreinoRequestDto dto){
        Treino treino = new Treino();

        treino.setDescricao(dto.descricao());
        treino.setTipo(dto.tipo());

        return repository.save(treino);
    }

    public List<Treino> listarTreinos(){
        return repository.findAll();
    }

    public Treino listarPorId(long id){
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lista não encontrada" + id));
    }

    public void deletarTreino (long id){
        repository.deleteById(id);
    }

}
