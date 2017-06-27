package br.com.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.web.model.Usuario;

public class UsuarioJdbcDao implements UsuarioDao{
	
	private Connection connection;

	public UsuarioJdbcDao() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void adiciona(Usuario usuario) {
		String sql = "insert into clientes " + "(nome,endereco,cpf,email,telefone,senha)" + " values (?,?,?,?,?,?)";

		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);

			// seta os valores
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getEndereco());
			stmt.setString(3, usuario.getCpf());
			stmt.setString(4, usuario.getEmail());
			stmt.setString(5, usuario.getTelefone());
			stmt.setString(6, usuario.getSenha());

			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Usuario> getLista() {
		try {
			List<Usuario> usuarios = new ArrayList<Usuario>();
			PreparedStatement stmt = this.connection.prepareStatement("select * from clientes");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// criando o objeto Contato
				Usuario usuario = new Usuario();
				usuario.setNome(rs.getString("nome"));
				usuario.setEndereco(rs.getString("endereco"));
				usuario.setCpf(rs.getString("cpf"));
				usuario.setEmail(rs.getString("email"));
				usuario.setTelefone(rs.getString("telefone"));
				usuario.setSenha(rs.getString("senha"));
				// adicionando o objeto à lista
				usuarios.add(usuario);
			}
			rs.close();
			stmt.close();
			return usuarios;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Usuario getCliente(String cpf){
		try {
			Usuario usuario = new Usuario();
			PreparedStatement stmt = this.connection.prepareStatement("select * from clientes where cpf=?");
			stmt.setString(1, cpf);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				// criando o objeto Contato
				usuario.setNome(rs.getString("nome"));
				usuario.setEndereco(rs.getString("endereco"));
				usuario.setCpf(rs.getString("cpf"));
				usuario.setEmail(rs.getString("email"));
				usuario.setTelefone(rs.getString("telefone"));
				usuario.setSenha(rs.getString("senha"));
			}
			rs.close();
			stmt.close();
			return usuario;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public void altera(Usuario usuario) {
		String sql = "update clientes set nome=?, endereco=?, email=?, telefone=?, senha=?"
				+ "where cpf=?";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getEndereco());
			stmt.setString(3, usuario.getEmail());
			stmt.setString(4, usuario.getTelefone());
			stmt.setString(5, usuario.getSenha());
			stmt.setString(6, usuario.getCpf());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void remove(String cpf) {
	     try {
	         PreparedStatement stmt = connection.prepareStatement("delete from clientes where cpf=?");
	         stmt.setString(1, cpf);
	         stmt.execute();
	         stmt.close();
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	 }
	public void close() throws SQLException{
		connection.close();
	}
}
