package dao;

import model.Livro;
import util.DBConnetion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


 //Classe responsavel pelo CRUD de livros no banco de dados.

public class LivroDAO {

    public void criarTabela() {
        String sql = "CREATE TABLE IF NOT EXISTS livros (" +
                "id SERIAL PRIMARY KEY," +
                "titulo VARCHAR(255) NOT NULL," +
                "autor VARCHAR(255) NOT NULL," +
                "ano INT," +
                "genero VARCHAR(100),";
        try (Connection conn = DBConnetion.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void adicionarLivro(Livro livro) {
        String sql = "INSERT INTO livros(titulo, autor, ano, genero) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnetion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, livro.getTitulo());
            pstmt.setString(2, livro.getAutor());
            pstmt.setInt(3, livro.getAno());
            pstmt.setString(4, livro.getGenero());
            pstmt.setString(5, livro.getStatus());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Livro> listarLivros() {
        List<Livro> livros = new ArrayList<>();
        String sql = "SELECT * FROM livros";
        try (Connection conn = DBConnetion.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                livros.add(new Livro(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("autor"),
                        rs.getInt("ano"),
                        rs.getString("genero"),
                        rs.getString("status")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return livros;
    }

    public void atualizarLivro(Livro livro) {
        String sql = "UPDATE livros SET titulo=?, autor=?, ano=?, genero=?, status=? WHERE id=?";
        try (Connection conn = DBConnetion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, livro.getTitulo());
            pstmt.setString(2, livro.getAutor());
            pstmt.setInt(3, livro.getAno());
            pstmt.setString(4, livro.getGenero());
            pstmt.setString(5, livro.getStatus());
            pstmt.setInt(6, livro.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluirLivro(int id) {
        String sql = "DELETE FROM livros WHERE id=?";
        try (Connection conn = DBConnetion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
