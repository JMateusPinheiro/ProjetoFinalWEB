package br.com.web.dao;

import java.util.List;

import br.com.web.model.Servico;

public interface ServicoDao {

	public void adcionarServico(Servico servico);
	
	public void removerServico(int id);
	
	public void alterarServico(Servico servico);
	
	public Servico getServicoById(int id);
	
	public List<Servico> getAllServicos();
	
	public void AgendarServico();
	
	public void close();
}
