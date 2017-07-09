package br.com.web.dao;

import java.util.List;

import br.com.web.model.Agendado;
import br.com.web.model.Servico;

public interface ServicoDao {

	public void adcionarServico(Servico servico);
	
	public void removerServico(int id);
	
	public void alterarServico(Servico servico);
	
	public Servico getServicoById(int id);
	
	public List<Servico> getAllServicos();
	
	public void AgendarServico(Agendado agendado);
	
	public void execultarServico(Agendado agendado);
	
	public void cancelarServico(Agendado agendado);
	
	public List<Agendado> listarServicosAgendados();
	
	public void close();
}
