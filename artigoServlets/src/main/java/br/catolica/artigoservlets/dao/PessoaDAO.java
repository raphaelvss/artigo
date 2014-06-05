package br.catolica.artigoservlets.dao;

import br.catolica.artigoservlets.conexao.ConnectionFactory;
import br.catolica.artigoservlets.model.Cidade;
import br.catolica.artigoservlets.model.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Raphael
 */
public class PessoaDAO {

    private Connection conn;

    public PessoaDAO() {
        conn = ConnectionFactory.getConnection();
    }

    public void save(Pessoa pessoa) {
        try {
            String sql = "INSERT INTO tb_pessoa(NOME, IDADE, FK_CIDADE) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, pessoa.getNome());
            ps.setInt(2, pessoa.getIdade());
            ps.setLong(3, pessoa.getCidadeNatal().getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void remove(Long id) {
        try {
            String sql = "DELETE FROM tb_pessoa WHERE PK_PESSOA=?";
            PreparedStatement ps = conn
                    .prepareStatement(sql);
            ps.setLong(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Pessoa pessoa) {
        try {
            String sql = "UPDATE tb_pessoa SET NOME=?, IDADE=?, FK_CIDADE=?  WHERE PK_PESSOA=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, pessoa.getNome());
            ps.setInt(2, pessoa.getIdade());
            ps.setLong(3, pessoa.getCidadeNatal().getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Pessoa> list() {
        List<Pessoa> pessoas = new ArrayList<Pessoa>();
        try {
            String sql = "SELECT * FROM tb_pessoa";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Pessoa pessoa = new Pessoa();
                pessoa.setId(rs.getLong("pk_pessoa"));
                pessoa.setNome(rs.getString("nome"));
                pessoa.setIdade(rs.getInt("idade"));

//                Cidade cidade = new CidadeDAO.findByPk(rs.getLong("pk_cidade"));

//                pessoa.setCidadeNatal(cidade);
                pessoas.add(pessoa);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pessoas;
    }

    public Pessoa findByPk(Long id) {
        Pessoa pessoa = new Pessoa();
        try {
            String sql = "SELECT * FROM users WHERE pk_pessoa=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                pessoa.setId(rs.getLong("pk_pessoa"));
                pessoa.setNome(rs.getString("nome"));
                pessoa.setIdade(rs.getInt("idade"));
                Cidade cidade = new Cidade();
                cidade.setId(rs.getLong("fk_cidade"));

                pessoa.setCidadeNatal(cidade);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pessoa;
    }
}
