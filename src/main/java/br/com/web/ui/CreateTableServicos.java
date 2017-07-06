package br.com.web.ui;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.web.dao.ConnectionFactory;

public class CreateTableServicos {
	public static void main(String[] args) throws SQLException {
		Connection c = new ConnectionFactory().getConnection();
		String sql = "create table servicos(id serial,"
				+ "nome varchar(100), "
				+ "preco float, "
				+ "descricao varchar(300), "
				+ "primary key(id))";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.executeUpdate();
		c.close();
	}
}
