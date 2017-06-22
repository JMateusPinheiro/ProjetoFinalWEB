package br.com.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.com.web.model.Produto;

public class ProdutoJdbcDao implements ProdutoDao {
	
	private Connection connection;
	
	public ProdutoJdbcDao() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	@Override
	public void adiciona(Produto produto) {
		String sql = "insert into produtos " + "(nome,preco,descricao,qtd,img_link)" + " values (?,?,?,?,?)";

		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);

			// seta os valores
			stmt.setString(1, produto.getNome());
			stmt.setFloat(2, produto.getPreco());
			stmt.setString(3, produto.getDescricao());
			stmt.setInt(4, produto.getQtd());
			stmt.setString(5, produto.getImg_link());

			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public List<Produto> getLista() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Produto getCliente(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void altera(Produto produto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void close() throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
