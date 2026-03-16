package com.teste.Treino.service;

import com.teste.Treino.model.Usuario;
import com.teste.Treino.repository.UsuarioRepository;

import java.sql.SQLException;
import java.util.List;

public class UsuarioService {

    UsuarioRepository usuarioRepository = new UsuarioRepository();

    public Usuario criarUsuario (Usuario usuario) throws SQLException{
        if(usuario.getNome().isEmpty()){
            throw new RuntimeException("Usuario não encontrado");
        }
        return usuarioRepository.criarUsuario(usuario);
    }

    public List<Usuario> listarTodosUsuario () throws SQLException{
           List<Usuario> usuarios = usuarioRepository.listarTodos();
           if(usuarios.isEmpty()){
               throw new RuntimeException("A lista esta vazia");
           }
        return usuarios;
    }

    public Usuario listarPorId (long id) throws SQLException{
           Usuario usuario = usuarioRepository.listarPorId(id);

           if(usuario == null){
               throw new RuntimeException("A lsita esta vazia");
           }
        return usuario;
    }

    public Usuario atualizarUsuario (Usuario usuario, long id) throws SQLException{
           Usuario usuarioo = usuarioRepository.listarPorId(id);

           if(usuario == null){
               throw new RuntimeException("Usuario não encontrado");
           }
        return usuario;
    }

    public void deletarUsuario (long id) throws SQLException{
        Usuario usuario = usuarioRepository.listarPorId(id);

        if(usuario == null){
            throw new RuntimeException("Usuario não encontrado");
        }
        usuarioRepository.deletar(id);
    }
}
