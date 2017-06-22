package br.com.web.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.web.model.Produto;


public interface ProdutoDao {

	public void adiciona(Produto produto);

	public List<Produto> getLista();

	public Produto getCliente(int id);

	public void altera(Produto produto);

	public void remove(int id);

	public void close() throws SQLException;
}
