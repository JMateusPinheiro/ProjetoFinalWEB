package br.com.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.web.model.Produto;

public class ProdutoJdbcDao implements ProdutoDao {
	
	private Connection connection;
	
	public ProdutoJdbcDao() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	@Override
	public void adiciona(Produto produto) {
		String sql = "insert into produtos " + "(nome,preco,descricao,qtd,img_link,classificacao)" + " values (?,?,?,?,?,?)";

		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);

			// seta os valores
			stmt.setString(1, produto.getNome());
			stmt.setFloat(2, produto.getPreco());
			stmt.setString(3, produto.getDescricao());
			stmt.setInt(4, produto.getQtd());
			stmt.setString(5, produto.getImg_link());
			stmt.setString(6, produto.getClassificacao());

			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public List<Produto> getProdutos() {
		try {
			List<Produto> produtos = new ArrayList<Produto>();
			PreparedStatement stmt = this.connection.prepareStatement("select * from produtos");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// criando o objeto Contato
				Produto produto = new Produto();
				produto.setId(rs.getInt("id"));
				produto.setNome(rs.getString("nome"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setQtd(rs.getInt("qtd"));
				produto.setPreco(rs.getFloat("preco"));
				produto.setImg_link(rs.getString("img_link"));
				produto.setClassificacao(rs.getString("classificacao"));
				// adicionando o objeto à lista
				produtos.add(produto);
			}
			rs.close();
			stmt.close();
			return produtos;
			}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Produto getProduto(int id) {
		try {
			Produto produto = new Produto();
			PreparedStatement stmt = this.connection.prepareStatement("select * from produtos where id=?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				// criando o objeto Contato
				produto.setId(rs.getInt("id"));
				produto.setNome(rs.getString("nome"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setQtd(rs.getInt("qtd"));
				produto.setPreco(rs.getFloat("preco"));
				produto.setImg_link(rs.getString("img_link"));
				produto.setClassificacao(rs.getString("classificacao"));
			}
			rs.close();
			stmt.close();
			return produto;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void altera(Produto produto) {
		String sql = "update produtos set nome=?, preco=?, descricao=?, qtd=?, img_link=?"
				+ "where id=?";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, produto.getNome());
			stmt.setFloat(2, produto.getPreco());
			stmt.setString(3, produto.getDescricao());
			stmt.setInt(4, produto.getQtd());
			stmt.setString(5, produto.getImg_link());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public void remove(int id) {
		try {
	         PreparedStatement stmt = connection.prepareStatement("delete from produtos where id=?");
	         stmt.setInt(1, id);
	         stmt.execute();
	         stmt.close();
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	 }
	
	@Override
	public void close(){
		try{
		connection.close();
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
