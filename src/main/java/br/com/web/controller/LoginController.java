package br.com.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.web.dao.UsuarioDao;
import br.com.web.dao.UsuarioJdbcDao;
import br.com.web.model.Usuario;

@Controller
public class LoginController {

	UsuarioDao usuariodao = new UsuarioJdbcDao();

	@RequestMapping(value="/logar", method = RequestMethod.POST)
	public String logar(@RequestParam("email") String email,@RequestParam("senha") String senha,RedirectAttributes redirectAttributes, HttpServletRequest req){
		HttpSession session = req.getSession();
		Usuario usuario = usuariodao.getUsuarioByEmail(email);
		if(senha.equals(usuario.getSenha()) && usuario.getRole().equals("usuario")){
			session.setAttribute("usuario", usuario);
			session.setAttribute("admin", "no");
			return "redirect:/";
		}
		else if(senha.equals(usuario.getSenha()) && usuario.getRole().equals("admin")){
			session.setAttribute("usuario", usuario);
			session.setAttribute("admin", "yes");
			return "redirect:/adm";
		}
		else{
			redirectAttributes.addFlashAttribute("msg", "Email ou senha Incorretos");
			redirectAttributes.addFlashAttribute("ver","Failed");
			return "redirect:/login";
		}
	}

	@RequestMapping("/deslogar")
	public String logar(HttpSession session, HttpServletRequest req){
		req.getSession().invalidate();
		return "redirect:/";
	}
}
