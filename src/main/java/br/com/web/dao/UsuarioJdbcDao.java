package br.com.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.web.model.Produto;
import br.com.web.model.Usuario;

public class UsuarioJdbcDao implements UsuarioDao{

	private Connection connection;

	public UsuarioJdbcDao() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void adiciona(Usuario usuario) {
		String sql = "insert into usuarios " + "(nome,endereco,cpf,email,telefone,senha,role)" + " values (?,?,?,?,?,?,?)";

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
			stmt.setString(7, usuario.getRole());

			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Usuario> getUsuarios() {
		try {
			List<Usuario> usuarios = new ArrayList<Usuario>();
			PreparedStatement stmt = this.connection.prepareStatement("select * from usuarios where role='usuario'");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// criando o objeto Contato
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
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

	public Usuario getUsuarioById(int id){
		try {
			Usuario usuario = new Usuario();
			PreparedStatement stmt = this.connection.prepareStatement("select * from usuarios where id=?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// criando o objeto Contato
				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setEndereco(rs.getString("endereco"));
				usuario.setCpf(rs.getString("cpf"));
				usuario.setEmail(rs.getString("email"));
				usuario.setTelefone(rs.getString("telefone"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setRole(rs.getString("role"));
			}
			rs.close();
			stmt.close();
			return usuario;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public Usuario getUsuarioByEmail(String email){
		try {
			Usuario usuario = new Usuario();
			PreparedStatement stmt = this.connection.prepareStatement("select * from usuarios where email=?");
			stmt.setString(1, email);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// criando o objeto Contato
				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setEndereco(rs.getString("endereco"));
				usuario.setCpf(rs.getString("cpf"));
				usuario.setEmail(rs.getString("email"));
				usuario.setTelefone(rs.getString("telefone"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setRole(rs.getString("role"));
			}
			rs.close();
			stmt.close();
			return usuario;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public void altera(Usuario usuario) {
		String sql = "update usuarios set nome=?, cpf=?, endereco=?, email=?, telefone=?, senha=?"
				+ "where id=?";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getCpf());
			stmt.setString(3, usuario.getEndereco());
			stmt.setString(4, usuario.getEmail());
			stmt.setString(5, usuario.getTelefone());
			stmt.setString(6, usuario.getSenha());
			stmt.setInt(7, usuario.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void remove(int id) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from usuarios where id=?");
			stmt.setInt(1, id);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public void close(){
		try{
			connection.close();
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public boolean addFav(int usuario_id, int produto_id) {
		String sql = "insert into favoritos(usuario_id, produto_id) values(?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, usuario_id);
			stmt.setInt(2, produto_id);
			if((getFavorito(usuario_id, produto_id).getId() != produto_id)){
				stmt.execute();
				return true;
			}
			stmt.close();
			return false;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void finalizarCompra(int usuario_id, int produto_id, Date data_compra) {

	}

	@Override
	public List<Produto> getFavoritos(int usuario_id) {
		String sql = "select * from favoritos where usuario_id = ?";
		try {
			List<Produto> favoritos = new ArrayList<Produto>();
			ProdutoDao produtodao = new ProdutoJdbcDao();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, usuario_id);
			ResultSet rs = stmt.executeQuery();

			while(rs.next()){
				Produto produto = produtodao.getProduto(rs.getInt("produto_id"));
				favoritos.add(produto);
			}
			rs.close();
			stmt.close();
			produtodao.close();
			return favoritos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Produto getFavorito(int usuario_id, int produto_id){
		String sql = "select * from favoritos where usuario_id=? and produto_id=?";
		try {
			ProdutoDao produtodao = new ProdutoJdbcDao();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, usuario_id);
			stmt.setInt(2, produto_id);
			ResultSet rs = stmt.executeQuery();
			// criando o objeto Contato
			Produto produto = new Produto();

			while (rs.next()) {
				produto = produtodao.getProduto(rs.getInt("produto_id"));
			}
			System.out.println(produto.getId());
			rs.close();
			stmt.close();
			return produto;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void removeFavorito(int usuario_id, int produto_id){
		String sql = "delete from favoritos where usuario_id=? and produto_id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, usuario_id);
			stmt.setInt(2, produto_id);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
