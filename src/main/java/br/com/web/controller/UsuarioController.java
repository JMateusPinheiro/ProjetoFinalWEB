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

	@RequestMapping(value = "/clientes/add", method = RequestMethod.POST)
	public String create(@Valid Usuario rcliente, @RequestParam("re-senha") String resenha, RedirectAttributes redirectAttributes) throws SQLException{
		UsuarioDao usuariodao = new UsuarioJdbcDao();
		if(rcliente.getSenha().equals(resenha)){
			usuariodao.adiciona(rcliente);
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

	@RequestMapping("/clientes/{cpf}")
	public String delete(@PathVariable("cpf") String cpf) throws SQLException{
		UsuarioDao usuariodao = new UsuarioJdbcDao();
		usuariodao.remove(cpf);
		usuariodao.close();

		return "redirect:/";
	}

	@RequestMapping("/alt/{cpf}")
	public String alt(@PathVariable("cpf") String cpf, Model model) throws SQLException{
		UsuarioDao usuariodao = new UsuarioJdbcDao();
		Usuario usuario = usuariodao.getCliente(cpf);
		model.addAttribute("cliente", usuario);
		usuariodao.close();
		return "AlterarCliente";
	}
	
	@RequestMapping(value = "/clientes/update", method = RequestMethod.POST)
	public String update(Usuario rusuario, @RequestParam("re-senha") String resenha) throws SQLException{
		UsuarioDao usuariodao = new UsuarioJdbcDao();
		if(rusuario.getSenha().equals(resenha)){

			usuariodao.altera(rusuario);
			usuariodao.close();
			return "redirect:/";
		}
		return "ErrorPage";
	}
	@RequestMapping("/listar")
	public String getList(Model model) throws SQLException	{
		UsuarioDao usuarioDao = new UsuarioJdbcDao();
		List<Usuario> usuarios = usuarioDao.getLista();

		model.addAttribute("clientes", usuarios);

		usuarioDao.close();
		return "adm/ListarClientes";
	}
}
