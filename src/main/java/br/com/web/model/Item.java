package br.com.web.model;

import java.util.Date;

public class Item {

	int usuario_id;
	Produto produto;
	Date data;
	
	public Item(){
		data = new Date(System.currentTimeMillis());
	}
	
	public int getUsuario_id() {
		return usuario_id;
	}
	
	public void setUsuario_id(int usuario_id) {
		this.usuario_id = usuario_id;
	}
	
	public Produto getProduto() {
		return produto;
	}
	
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public Date getData() {
		return data;
	}
	
	public void setData(Date data) {
		this.data = data;
	}
	
}
