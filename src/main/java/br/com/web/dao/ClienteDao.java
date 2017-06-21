package br.com.web.dao;

import java.util.List;

import br.com.web.model.Cliente;

public interface ClienteDao {

	public void adiciona(Cliente cliente);
	
	public List<Cliente> getLista();
	
	public Cliente getCliente(String cpf);
	
	public void altera(Cliente cliente);
	
	public void remove(String cpf);
}
