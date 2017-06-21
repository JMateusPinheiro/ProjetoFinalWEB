package br.com.web.controller;

import java.sql.SQLException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.web.dao.ClienteDao;
import br.com.web.model.Cliente;

@Controller
public class ClienteController{

	@Autowired
	@Qualifier("clienteJdbcDao")
	private ClienteDao clienteDao;

	@RequestMapping("/")
	public String getList(Model model){
		List<Cliente> clientes = clienteDao.getLista();
		model.addAttribute("clientes", clientes);
		return "index";
	}

	@RequestMapping(value = "/clientes", method = RequestMethod.POST)
	public String create(@Valid Cliente rcliente, @RequestParam("re-senha") String resenha) throws SQLException{
				
		if(rcliente.getSenha().equals(resenha)){
			clienteDao.adiciona(rcliente);
			return "redirect:/";
		}
		return "SenhasError";
	}

	@RequestMapping("/clientes/{cpf}")
	public String delete(@PathVariable("cpf") String cpf) throws SQLException{
		clienteDao.remove(cpf);

		return "redirect:/";
	}

	@RequestMapping("/alt/{cpf}")
	public String alt(@PathVariable("cpf") String cpf, Model model) throws SQLException{
		Cliente cliente = clienteDao.getCliente(cpf);
		model.addAttribute("cliente", cliente);
		return "AlterarCliente";
	}

	@RequestMapping(value = "/clientes/update", method = RequestMethod.POST)
	public String update(Cliente rcliente, @RequestParam("re-senha") String resenha) throws SQLException{
		if(rcliente.getSenha().equals(resenha)){

			clienteDao.altera(rcliente);
			return "redirect:/";
		}
		return "SenhasError";
	}
}
