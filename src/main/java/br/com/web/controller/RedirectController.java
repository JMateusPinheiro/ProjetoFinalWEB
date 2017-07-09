package br.com.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.web.dao.ServicoDao;
import br.com.web.dao.ServicoJdbcDao;
import br.com.web.model.Usuario;

@Controller
public class RedirectController {

	@RequestMapping("/")
	public String home()  {
		return "index";
	}

	@RequestMapping("/adm")
	public String admHome()  {
		return "adm/ADM_Index";
	}

	@RequestMapping("/usuario")
	public String userHome()  {
		return "user/USER_Perfil";
	}
	
	@RequestMapping("/cadastro")
	public String userCadastro()  {
		return "Cadastro";
	}
	
	@RequestMapping("/login")
	public String userLogin()  {
		return "Login";
	}
	
	@RequestMapping("/adm/gerenciar_servicos/FormAdd")
	public String addServiço(HttpServletRequest req){
		req.setAttribute("path", "add");
		return "adm/ADM_FormAddServico";
	}
	
	@RequestMapping("/adm/gerenciar_servicos/FormEdit/{id}")
	public String editServiço(@PathVariable("id") int id, HttpServletRequest req){
		ServicoDao servicodao = new ServicoJdbcDao();
		req.setAttribute("path", "edit");
		req.setAttribute("servico", servicodao.getServicoById(id));
		servicodao.close();
		return "adm/ADM_FormAddServico";
	}
	
	@RequestMapping("/usuario/solicitar_servico")
	public String solicitarServiço(HttpServletRequest req){
		ServicoDao servicodao = new ServicoJdbcDao();
		req.setAttribute("servicos", servicodao.getAllServicos());
		servicodao.close();
		return "user/USER_AgendarServiço";
	}
	
	@RequestMapping("/usuario/servicos")
	public String servicos(HttpServletRequest req){
		ServicoDao servicodao = new ServicoJdbcDao();
		Usuario usuario = (Usuario) req.getSession().getAttribute("usuario");
		req.setAttribute("agendados", servicodao.getAgedadoByUsuarioId(usuario.getId()));
		servicodao.close();
		return "user/USER_Servicos";
	}
}
