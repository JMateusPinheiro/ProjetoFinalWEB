package br.com.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.web.dao.ServicoDao;
import br.com.web.dao.ServicoJdbcDao;
import br.com.web.dao.UsuarioDao;
import br.com.web.dao.UsuarioJdbcDao;
import br.com.web.model.Agendado;
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
	@PostMapping("/adm/gerenciar_servicos/add")
	public String addServiço(Servico servico, RedirectAttributes red){
		ServicoDao servicodao = new ServicoJdbcDao();
		servicodao.adcionarServico(servico);
		servicodao.close();
		red.addFlashAttribute("msg","Servico adicionado com sucesso");
		return "redirect:/adm/gerenciar_servicos";
	}
	
	@RequestMapping("/adm/gerenciar_servicos/delete/{id}")
	public String delServico(@PathVariable("id") int id){
		ServicoDao servicodao = new ServicoJdbcDao();
		servicodao.removerServico(id);
		servicodao.close();
		return "redirect:/adm/gerenciar_servicos";
	}
	
	@PostMapping("/adm/gerenciar_servicos/edit")
	public String editServico(Servico servico, RedirectAttributes red){
		ServicoDao servicodao = new ServicoJdbcDao();
		System.out.println(servico.getId());
		System.out.println(servico.getNome());
		System.out.println(servico.getDescricao());
		servicodao.alterarServico(servico);
		servicodao.close();
		red.addFlashAttribute("msg","Servico alterado com sucesso");
		return "redirect:/adm/gerenciar_servicos"; 
	}
	
	@PostMapping("/usuario/requisitar_servico")
	public String requisitarServico(Agendado agendado, @RequestParam("usuario_id") int usuario_id, @RequestParam("servico_id") int servico_id){
		ServicoDao servicodao = new ServicoJdbcDao();
		UsuarioDao usuariodao = new UsuarioJdbcDao();
		agendado.setUsuario(usuariodao.getUsuarioById(usuario_id));
		agendado.setServico(servicodao.getServicoById(servico_id));
		agendado.setStatus("ABERTA");
		servicodao.AgendarServico(agendado);
		return "redirect:/";
	}
	
	@RequestMapping("/adm/gerenciar_servicos/ListarServicosRequisitados")
	public String ListarAgendados(HttpServletRequest req){
		ServicoDao servicodao = new ServicoJdbcDao();
		req.setAttribute("agendados", servicodao.listarServicosAgendados());
		servicodao.close();
		return "adm/ADM_ListarAgendados";
	}
	
	@RequestMapping("/adm/gerenciar_servicos/execultarServico")
	public String execultarServico(HttpServletRequest req){
		ServicoDao servicodao = new ServicoJdbcDao();
//		servicodao.execultarServico(agendado);
		servicodao.close();
		return "redirect:/adm/gerenciar_servicos/ListarServicosRequisitados";
	}
}
