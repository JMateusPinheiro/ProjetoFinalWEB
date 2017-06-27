package br.com.web.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.web.model.Usuario;

public interface UsuarioDao {

	public void adiciona(Usuario usuario);
	
	public List<Usuario> getLista();
	
	public Usuario getCliente(String cpf);
	
	public void altera(Usuario usuario);
	
	public void remove(String cpf);
	
	public void close() throws SQLException;
}
