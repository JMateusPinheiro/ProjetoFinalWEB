package br.com.web.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Usuario {
	
	@NotNull
	@Size(min=2, max=200, message="Numero de Caracteres entre {min} e {max}")
	String nome;
	
	@NotNull
	@Size(min=2, max=200, message="Numero de Caracteres entre {min} e {max}")
	String endereco;
	
	@NotNull
	@Size(min=11, max=11, message="O cpf precisa ter exatamente 11 caracteres")
	String cpf;
	
	@NotNull
	String email;
	
	@NotNull
	@Size(min=11, max=11, message="O Telefone precisa ter exatamente 11 numeros")
	String telefone;
	
	@NotNull
	@Size(min=2, message="Senha precisa ter no minimo 4 caracteres")
	String senha;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
}
