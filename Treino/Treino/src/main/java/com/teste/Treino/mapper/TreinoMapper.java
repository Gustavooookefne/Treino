package com.teste.Treino.mapper;

import com.teste.Treino.dto.TreinoDtos.TreinoRequestDto;
import com.teste.Treino.model.Treino;
import org.springframework.stereotype.Component;

@Component
public class TreinoMapper {

    public Treino paraEntidade (TreinoRequestDto treinoRequestDto) {

        return new Treino(
                treinoRequestDto.descricao(),
                treinoRequestDto.tipo()
        );
    }

    public Treino paraDtos (Treino treino) {

        return new Treino(
                treino.getDescricao(),
                treino.getTipo()
        );
    }
}
