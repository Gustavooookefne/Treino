package com.teste.Treino.repository;

import com.teste.Treino.db.Conexao;
import com.teste.Treino.model.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepository {
    public Usuario criarUsuario (Usuario usuario)throws SQLException{
        String sql = """
                    INSERT INTO usuario
                    (nome ,email ,idade ,peso ,altura)
                    VALUES
                    (?,?,?,?,?)
                    """;

        try (Connection conn = Conexao.connection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
                ps.setString(1, usuario.getNome());
                ps.setString(2, usuario.getEmail());
                ps.setInt(3, usuario.getIdade());
                ps.setDouble(4, usuario.getPeso());
                ps.setDouble(5, usuario.getAltura());

                ps.executeUpdate();

                try (ResultSet rs = ps.getGeneratedKeys()){
                    if(rs.next()){
                        usuario.setAltura(rs.getLong(1));
                    }
                }
        }
        return usuario;
    }

    public List<Usuario> listarTodos()throws SQLException{
           List<Usuario>usuarios = new ArrayList<>();

           String sql = """
                   SELECT id,
                   nome,
                   email,
                   idade,
                   peso,
                   altura,
                   FROM usuario
                   """;

           try (Connection conn = Conexao.connection();
           PreparedStatement ps = conn.prepareStatement(sql)){
               ResultSet rs = ps.executeQuery();
               while (rs.next()){
                   Usuario usuario = new Usuario();
                   usuario.setNome(rs.getString("nome"));
                   usuario.setEmail(rs.getString("email"));
                   usuario.setIdade(rs.getInt("idade"));
                   usuario.setPeso(rs.getDouble("peso"));
                   usuario.setAltura(rs.getDouble("altura"));
                   usuarios.add(usuario);
               }
           }
        return usuarios;
    }

    public Usuario listarPorId(long id)throws SQLException{
           Usuario usuario = null;

           String sql = """
                   SELECT id,
                   nome
                   email
                   idade,
                   peso,
                   altura,
                   WHERE id = ?
                   FROM usuario
                   """;

           try (Connection conn = Conexao.connection();
           PreparedStatement ps = conn.prepareStatement(sql)){
               ps.setLong(1,id);

               try (ResultSet rs = ps.executeQuery()){
                    if(rs.next()){
                        usuario = new Usuario();
                        usuario.setNome(rs.getString("nome"));
                        usuario.setEmail(rs.getString("email"));
                        usuario.setIdade(rs.getInt("idade"));
                        usuario.setPeso(rs.getDouble("peso"));
                        usuario.setAltura(rs.getDouble("altura"));
                    }
               }
           }
        return usuario;
    }

    public Usuario atualizarUsuario(Usuario usuario, long id)throws SQLException{
            String sql = """
                    UPDATE usuario
                    SET
                    nome = ?,
                    email = ?,
                    idade = ?,
                    peso = ?,
                    altura = ?
                    WHERE id = ?
                    """;

            try (Connection conn = Conexao.connection();
            PreparedStatement ps = conn.prepareStatement(sql)){
                ps.setLong(1, id);
                ps.setString(2,usuario.getNome());
                ps.setString(3,usuario.getEmail());
                ps.setInt(4,usuario.getIdade());
                ps.setDouble(5,usuario.getPeso());
                ps.setDouble(6,usuario.getAltura());

                ps.executeUpdate();
            }

        return usuario;
    }

    public void deletar(long id)throws SQLException{
            String sql = """
                    DELETE FROM usuario
                    WHERE id = ?
                    """;

            try (Connection conn = Conexao.connection();
            PreparedStatement ps = conn.prepareStatement(sql)){
                ps.setLong(1,id);
                ps.executeUpdate();
            }
    }
}
