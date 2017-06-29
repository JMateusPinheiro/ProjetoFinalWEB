package br.com.web.ui;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.web.dao.ConnectionFactory;

public class CreateTableProdutos {

	public static void main(String[] args) throws SQLException {
		Connection c = new ConnectionFactory().getConnection();
		String sql = "create table produtos(id serial,"
				+ "nome varchar(100), "
				+ "preco bigint, "
				+ "descricao varchar(300), "
				+ "qtd bigint, "
				+ "img_link varchar(150),"
				+ "classificacao varchar(50)"
				+ "primary key(id))";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.executeUpdate();
		c.close();
	}
}
