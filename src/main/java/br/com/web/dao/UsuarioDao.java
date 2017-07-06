package br.com.web.dao;

import java.util.List;

import br.com.web.model.Usuario;

public interface UsuarioDao {

	public void adiciona(Usuario usuario);
	
	public List<Usuario> getUsuarios();
	
	public Usuario getUsuarioById(int id);
	
	public Usuario getUsuarioByEmail(String email);
	
	public void altera(Usuario usuario);
	
	public void remove(int id);
	
	public void close();
}
