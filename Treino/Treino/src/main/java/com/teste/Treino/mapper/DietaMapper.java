package com.teste.Treino.mapper;

import com.teste.Treino.dto.DietaDtos.DietaRequestDto;
import com.teste.Treino.model.Dieta;
import org.springframework.stereotype.Component;

@Component
public class DietaMapper {

    public Dieta paraEntidade (DietaRequestDto dietaRequestDto) {

        return new Dieta(
                dietaRequestDto.nomeDieta(),
                dietaRequestDto.detalhesDieta()
        );
    }

    public Dieta paraDto (Dieta dieta) {

        return new Dieta(
                dieta.getId(),
                dieta.getNomeDieta(),
                dieta.getDetalhesDieta()
        );
    }
}
