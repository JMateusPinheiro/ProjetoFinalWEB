package br.com.web.model;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {
	List<Item> carrinho;
		
	public Carrinho(){
		carrinho = new ArrayList<Item>();
	}
	public List<Item> getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(List<Item> carrinho) {
		this.carrinho = carrinho;
	}
}
