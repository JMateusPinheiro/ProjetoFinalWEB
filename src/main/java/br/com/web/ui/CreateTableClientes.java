package br.com.web.ui;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.web.dao.ConnectionFactory;

public class CreateTableClientes {

	public static void main(String[] args) throws SQLException {
		Connection c = new ConnectionFactory().getConnection();
		String sql = "create table clientes(id serial,"
				+ "nome varchar(100), "
				+ "endereco varchar(500), "
				+ "cpf varchar(11), "
				+ "email varchar(100), "
				+ "telefone varchar(15),"
				+ "senha varchar(50),"
				+ "primary key(id),"
				+ "unique(cpf, email));";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.executeUpdate();
		c.close();
	}

}