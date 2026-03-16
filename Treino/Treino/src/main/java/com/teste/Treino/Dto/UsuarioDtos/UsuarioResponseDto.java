package com.teste.Treino.Dto.UsuarioDtos;

import java.util.UUID;

public record UsuarioResponseDto (

        long id,
        String nome,
        String email,
        int idade,
        double peso,
        double altura
){
}
