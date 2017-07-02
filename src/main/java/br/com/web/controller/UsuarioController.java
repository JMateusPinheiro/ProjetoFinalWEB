package br.com.web.controller;

import java.sql.SQLException;
import java.util.List;

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

	@RequestMapping("/")
	public String home(Model model) throws SQLException	{
		return "index";
	}

	@RequestMapping("/adm")
	public String admHome(Model model) throws SQLException{
		return "adm/ADM_Index";
	}
	
	@RequestMapping("/usuario")
	public String userHome(Model model) throws SQLException{
		return "user/USER_Perfil";
	}
	
	@RequestMapping(value = "/usuario/add", method = RequestMethod.POST)
	public String create(@Valid Usuario rusuario, @RequestParam("re-senha") String resenha, RedirectAttributes redirectAttributes) throws SQLException{
		UsuarioDao usuariodao = new UsuarioJdbcDao();
		if(rusuario.getSenha().equals(resenha)){
			rusuario.setRole("usuario");
			usuariodao.adiciona(rusuario);
			redirectAttributes.addFlashAttribute("ver", "Success");
			redirectAttributes.addFlashAttribute("msg", "Conta criada com sucesso");
			usuariodao.close();
			return "redirect:/";
		}
		else{
			redirectAttributes.addFlashAttribute("ver", "Failed");
			redirectAttributes.addFlashAttribute("msg", "Error.");
			usuariodao.close();
			return "redirect:/";
		}		
	}

	@RequestMapping("/adm/delete_usuario/{id}")
	public String delete(@PathVariable("id") int id) throws SQLException{
		UsuarioDao usuariodao = new UsuarioJdbcDao();
		usuariodao.remove(id);
		usuariodao.close();

		return "redirect:/adm/gerenciar_usuario";
	}

	@RequestMapping("/usuario/redirect_update/{id}")
	public String alt(@PathVariable("id") int id, Model model) throws SQLException{
		UsuarioDao usuariodao = new UsuarioJdbcDao();
		Usuario usuario = usuariodao.getUsuarioById(id);
		model.addAttribute("cliente", usuario);
		usuariodao.close();
		return "redirect:/usuario/update";
	}

	@RequestMapping(value = "/usuario/update", method = RequestMethod.POST)
	public String updateForm(Usuario rusuario, @RequestParam("re-senha") String resenha) throws SQLException{
		return "USER_AlterarUsuario";
	}

	@RequestMapping(value = "/usuario/execute_update", method = RequestMethod.POST)
	public String update(Usuario rusuario, @RequestParam("re-senha") String resenha) throws SQLException{
		UsuarioDao usuariodao = new UsuarioJdbcDao();
		if(rusuario.getSenha().equals(resenha)){
			usuariodao.altera(rusuario);
			usuariodao.close();
			return "redirect:/";
		}
		return "ErrorPage";
	}

	@RequestMapping("/adm/gerenciar_usuario")
	public String getList(Model model) throws SQLException	{
		UsuarioDao usuarioDao = new UsuarioJdbcDao();
		List<Usuario> usuarios = usuarioDao.getUsuarios();

		model.addAttribute("usuarios", usuarios);

		usuarioDao.close();
		return "adm/ADM_GerenciarUsuarios";
	}
}
