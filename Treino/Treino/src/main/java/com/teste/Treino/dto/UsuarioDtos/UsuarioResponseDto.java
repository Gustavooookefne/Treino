package com.teste.Treino.dto.UsuarioDtos;

public record UsuarioResponseDto (

        long id,
        String nome,
        String email,
        int idade,
        double peso,
        double altura
){
}
