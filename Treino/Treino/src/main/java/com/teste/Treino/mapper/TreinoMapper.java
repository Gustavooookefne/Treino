package com.teste.Treino.mapper;

import com.teste.Treino.dto.TreinoDtos.TreinoRequestDto;
import com.teste.Treino.dto.TreinoDtos.TreinoResponseDto;
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

    public TreinoResponseDto paraDtos (Treino treino) {

        return new TreinoResponseDto(
                treino.getId(),
                treino.getDescricao(),
                treino.getTipo()
        );
    }
}
