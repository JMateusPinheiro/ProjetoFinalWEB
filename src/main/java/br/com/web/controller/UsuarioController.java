package br.com.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.web.dao.UsuarioDao;
import br.com.web.dao.UsuarioJdbcDao;
import br.com.web.model.Usuario;

@Controller
public class UsuarioController{

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String create(@Valid Usuario rusuario, @RequestParam("re-senha") String resenha, 
			@RequestParam("email") String email, RedirectAttributes red)  {
		UsuarioDao usuariodao = new UsuarioJdbcDao();
		if(usuariodao.getUsuarioByEmail(email).getEmail() != null){
			red.addFlashAttribute("rusuario", rusuario);
			red.addFlashAttribute("ver", "Failed");
			red.addFlashAttribute("msg", "Error: Email Já Cadastrado");
			usuariodao.close();
			return "Cadastro";
		}
		else if(rusuario.getSenha().equals(resenha)){
			rusuario.setRole("usuario");
			usuariodao.adiciona(rusuario);
			red.addFlashAttribute("ver", "Success");
			red.addFlashAttribute("msg", "Conta criada com sucesso");
			usuariodao.close();
			return "redirect:/";
		}
		else{
			red.addFlashAttribute("rusuario", rusuario);
			red.addFlashAttribute("ver", "Failed");
			red.addFlashAttribute("msg", "Error: Senhas Não Conferem");
			usuariodao.close();
			return "Cadastro";
		}
	}

	@RequestMapping("/adm/delete_usuario/{id}")
	public String delete(@PathVariable("id") int id)  {
		UsuarioDao usuariodao = new UsuarioJdbcDao();
		usuariodao.remove(id);
		usuariodao.close();

		return "redirect:/adm/gerenciar_usuario";
	}

	@RequestMapping(value = "/usuario/update", method = RequestMethod.POST)
	public String update(Usuario rusuario, @RequestParam("re-senha") String resenha, HttpServletRequest req, RedirectAttributes red)  {
		UsuarioDao usuariodao = new UsuarioJdbcDao();
		if(rusuario.getSenha().equals(resenha)){
			usuariodao.altera(rusuario);
			req.getSession().setAttribute("usuario", rusuario);
			red.addFlashAttribute("ver", "Success");
			red.addFlashAttribute("msg", "Conta alterada com sucesso");
			usuariodao.close();
			return "redirect:/usuario";
		}else{
			red.addFlashAttribute("ver", "Failed");
			red.addFlashAttribute("msg", "Error: Senhas Não Conferem");
			usuariodao.close();
			return "redirect:/usuario";
		}
	}

	@RequestMapping("/adm/gerenciar_usuario")
	public String getList(Model model)  	{
		UsuarioDao usuarioDao = new UsuarioJdbcDao();
		List<Usuario> usuarios = usuarioDao.getUsuarios();

		model.addAttribute("usuarios", usuarios);

		usuarioDao.close();
		return "adm/ADM_GerenciarUsuarios";
	}

	@RequestMapping("/usuario/agendar_servico")
	public String agendarServico(RedirectAttributes redirectAttributes){

		redirectAttributes.addFlashAttribute("msg", "Serviço Agendado com sucesso");
		return "redirect:/";
	}
	
	@RequestMapping("/adm/ver_usuario/{id}")
	public String verUser(@PathVariable("id") int id, HttpServletRequest req){
		UsuarioDao usuarioDao = new UsuarioJdbcDao();
		req.setAttribute("user", usuarioDao.getUsuarioById(id));
		return "adm/ADM_VisualizarDadosUser";
	}
}
