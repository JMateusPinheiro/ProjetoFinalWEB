package br.com.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.web.model.Servico;

public class ServicoJdbcDao implements ServicoDao {

	Connection connection = new ConnectionFactory().getConnection();

	@Override
	public void adcionarServico(Servico servico) {
		try{
			String sql = "insert into servicos(nome,preco,descricao) values(?,?,?)";
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, servico.getNome());
			stmt.setFloat(2, servico.getPreco());
			stmt.setString(3, servico.getDescricao());

			stmt.executeUpdate();
			stmt.close();
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void removerServico(int id) {
		try{
			String sql = "delete from servicos where id=?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.executeUpdate();
			stmt.close();
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	public void alterarServico(Servico servico) {
		try{
			String sql = "update servicos set nome=?, preco=?, descricao=? where id=?";
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, servico.getNome());
			stmt.setFloat(2, servico.getPreco());
			stmt.setString(3, servico.getDescricao());
			stmt.setInt(4, servico.getId());

			stmt.executeUpdate();
			stmt.close();
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	public Servico getServicoById(int id) {
		try{
			String sql = "select * from servicos where id=?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			stmt.setInt(1, id);
			Servico servico = new Servico();

			while(rs.next()){
				servico.setId(rs.getInt("id"));
				servico.setNome(rs.getString("nome"));
				servico.setPreco(rs.getFloat("preco"));
				servico.setDescricao(rs.getString("descricao"));
			}

			rs.close();
			stmt.close();
			return servico;
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Servico> getAllServicos() {
		try{
			String sql = "select * from servicos";
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			List<Servico> servicos = new ArrayList<Servico>();

			while(rs.next()){
				Servico servico = new Servico();

				servico.setId(rs.getInt("id"));
				servico.setNome(rs.getString("nome"));
				servico.setPreco(rs.getFloat("preco"));
				servico.setDescricao(rs.getString("descricao"));

				servicos.add(servico);
			}

			rs.close();
			stmt.close();
			return servicos;
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	public void AgendarServico() {
		// TODO Auto-generated method stub

	}

	@Override
	public void close() {
		try{
			connection.close();
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}



}
