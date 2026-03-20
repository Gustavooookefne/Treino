package com.teste.Treino.dto.UsuarioDtos;

import java.util.UUID;

public record UsuarioResponseDto (

        UUID id,
        String nome,
        String email,
        int idade,
        double peso,
        double altura
){
}
