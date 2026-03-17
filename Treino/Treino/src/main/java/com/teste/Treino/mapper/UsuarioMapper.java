package com.teste.Treino.mapper;

import com.teste.Treino.dto.UsuarioDtos.UsuarioRequestDto;
import com.teste.Treino.model.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public Usuario paraEntidade (UsuarioRequestDto usuarioRequestDto) {

        return new Usuario(

                usuarioRequestDto.nome(),
                usuarioRequestDto.email(),
                usuarioRequestDto.idade(),
                usuarioRequestDto.peso(),
                usuarioRequestDto.altura()
        );
    }

    public Usuario paraDtos (Usuario usuario){

        return new Usuario(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getIdade(),
                usuario.getPeso(),
                usuario.getAltura()

        );
    }
}
