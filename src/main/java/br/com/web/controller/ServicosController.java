package br.com.web.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.web.dao.ServicoDao;
import br.com.web.dao.ServicoJdbcDao;
import br.com.web.model.Servico;

@Controller
public class ServicosController {

	@RequestMapping("/adm/gerenciar_servicos")
	public String gerServicos(Model model){
		ServicoDao servicodao = new ServicoJdbcDao();
		List<Servico> servicos = servicodao.getAllServicos();
		
		model.addAttribute("servicos", servicos);
		
		servicodao.close();
		return "adm/ADM_GerenciarServicos";
	}
}
