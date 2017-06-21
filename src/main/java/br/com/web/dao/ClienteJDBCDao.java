package br.com.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.web.model.Cliente;

public class ClienteJDBCDao implements ClienteDao{
	
	private Connection connection;

	public ClienteJDBCDao() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void adiciona(Cliente cliente) {
		String sql = "insert into clientes " + "(nome,endereco,cpf,email,telefone,senha)" + " values (?,?,?,?,?,?)";

		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);

			// seta os valores
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getEndereco());
			stmt.setString(3, cliente.getCpf());
			stmt.setString(4, cliente.getEmail());
			stmt.setString(5, cliente.getTelefone());
			stmt.setString(6, cliente.getSenha());

			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Cliente> getLista() {
		try {
			List<Cliente> clientes = new ArrayList<Cliente>();
			PreparedStatement stmt = this.connection.prepareStatement("select * from clientes");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// criando o objeto Contato
				Cliente cliente = new Cliente();
				cliente.setNome(rs.getString("nome"));
				cliente.setEndereco(rs.getString("endereco"));
				cliente.setCpf(rs.getString("cpf"));
				cliente.setEmail(rs.getString("email"));
				cliente.setTelefone(rs.getString("telefone"));
				cliente.setSenha(rs.getString("senha"));
				// adicionando o objeto à lista
				clientes.add(cliente);
			}
			rs.close();
			stmt.close();
			return clientes;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Cliente getCliente(String cpf){
		try {
			Cliente cliente = new Cliente();
			PreparedStatement stmt = this.connection.prepareStatement("select * from clientes where cpf=?");
			stmt.setString(1, cpf);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				// criando o objeto Contato
				cliente.setNome(rs.getString("nome"));
				cliente.setEndereco(rs.getString("endereco"));
				cliente.setCpf(rs.getString("cpf"));
				cliente.setEmail(rs.getString("email"));
				cliente.setTelefone(rs.getString("telefone"));
				cliente.setSenha(rs.getString("senha"));
			}
			rs.close();
			stmt.close();
			return cliente;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public void altera(Cliente cliente) {
		String sql = "update clientes set nome=?, endereco=?, email=?, telefone=?, senha=?"
				+ "where cpf=?";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getEndereco());
			stmt.setString(3, cliente.getEmail());
			stmt.setString(4, cliente.getTelefone());
			stmt.setString(5, cliente.getSenha());
			stmt.setString(6, cliente.getCpf());
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
