package br.com.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.web.model.Agendado;
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
		String sql = "update servicos set nome=?, preco=?, descricao=? where id=?";
		try{
			PreparedStatement stmt = connection.prepareStatement(sql);
			System.out.println(servico.getId());
			stmt.setString(1, servico.getNome());
			stmt.setFloat(2, servico.getPreco());
			stmt.setString(3, servico.getDescricao());
			stmt.setInt(4, servico.getId());

			stmt.execute();
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
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
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
	public void close() {
		try{
			connection.close();
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void AgendarServico(Agendado agendado) {
		String sql = "insert into servicos_solicitados(usuario_id,servico_id,data_solicitada,hora_solicitada,status) values(?,?,?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, agendado.getUsuario().getId());
			stmt.setInt(2, agendado.getServico().getId());
			stmt.setString(3, agendado.getData());
			stmt.setString(4, agendado.getHora());
			stmt.setString(5, agendado.getStatus());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void execultarServico(Agendado agendado) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancelarServico(Agendado agendado) {
		String sql = "update servicos_solicitados set status='FEITO' "
				+ "where usuario_id=? and servico_id=? and data_requisitada=? and hora_requisitada=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setInt(1, agendado.getUsuario().getId());
			stmt.setInt(2, agendado.getServico().getId());
			stmt.setString(3, agendado.getData());
			stmt.setString(4, agendado.getHora());
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Agendado> listarServicosAgendados() {
		String sql = "select * from servicos_solicitados";
		try {
			List<Agendado> agendados = new ArrayList<Agendado>();
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			UsuarioDao usuariodao = new UsuarioJdbcDao();
			while(rs.next()){
				Agendado agendado = new Agendado();
				
				agendado.setUsuario(usuariodao.getUsuarioById(rs.getInt("usuario_id")));
				agendado.setServico(getServicoById(rs.getInt("servico_id")));
				agendado.setData(rs.getString("data_solicitada"));
				agendado.setHora(rs.getString("hora_solicitada"));
				agendado.setStatus(rs.getString("status"));
				
				agendados.add(agendado);
			}
			rs.close();
			stmt.close();
			return agendados;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}		
	}



}
