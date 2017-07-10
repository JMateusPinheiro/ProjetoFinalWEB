package br.com.web.dao;

import java.util.Date;
import java.util.List;

import br.com.web.model.Produto;
import br.com.web.model.Usuario;

public interface UsuarioDao {

	public void adiciona(Usuario usuario);
	
	public List<Usuario> getUsuarios();
	
	public Usuario getUsuarioById(int id);
	
	public Usuario getUsuarioByEmail(String email);
	
	public void altera(Usuario usuario);
	
	public void remove(int id);
	
	public void addFav(int usuario_id,int produto_id);
	
	public void addHis(int usuario_id,int produto_id, Date data_compra);
	
	public List<Produto> getFavoritos(int usuario_id);
	
	
	public void close();
}
