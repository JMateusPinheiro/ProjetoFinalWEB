package br.com.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
