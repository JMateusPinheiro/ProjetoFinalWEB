package br.com.web.dao;

import java.util.List;

import br.com.web.model.Produto;


public interface ProdutoDao {

	public void adiciona(Produto produto);

	public List<Produto> getProdutos();

	public Produto getProduto(int id);

	public void altera(Produto produto);

	public void remove(int id);

	public void close();

	public List<Produto> getProdutosByClassificacao(String animal);
}
