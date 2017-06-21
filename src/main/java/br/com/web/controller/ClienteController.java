package br.com.web.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.web.dao.ClienteDao;
import br.com.web.dao.ClienteJDBCDao;
import br.com.web.model.Cliente;

@Controller
public class ClienteController{

	@RequestMapping("/")
	public String getList(Model model) throws SQLException	{
		ClienteDao clienteDao = new ClienteJDBCDao();
		List<Cliente> clientes = clienteDao.getLista();

		model.addAttribute("clientes", clientes);

		clienteDao.close();
		return "index";
	}

	@RequestMapping(value = "/clientes", method = RequestMethod.POST)
	public String create(Cliente rcliente, @RequestParam("re-senha") String resenha) throws SQLException{
		ClienteDao clientedao = new ClienteJDBCDao();
		if(rcliente.getSenha().equals(resenha)){

			clientedao.adiciona(rcliente);
			clientedao.close();
			return "redirect:/";
		}
		return "SenhasError";
	}

	@RequestMapping("/clientes/{cpf}")
	public String delete(@PathVariable("cpf") String cpf) throws SQLException{
		ClienteDao clientedao = new ClienteJDBCDao();
		clientedao.remove(cpf);
		clientedao.close();

		return "redirect:/";
	}

	@RequestMapping("/alt/{cpf}")
	public String alt(@PathVariable("cpf") String cpf, Model model) throws SQLException{
		ClienteDao clientedao = new ClienteJDBCDao();
		Cliente cliente = clientedao.getCliente(cpf);
		model.addAttribute("cliente", cliente);
		clientedao.close();
		return "AlterarCliente";
	}
	
	@RequestMapping(value = "/clientes/update", method = RequestMethod.POST)
	public String update(Cliente rcliente, @RequestParam("re-senha") String resenha) throws SQLException{
		ClienteDao clientedao = new ClienteJDBCDao();
		if(rcliente.getSenha().equals(resenha)){

			clientedao.altera(rcliente);
			clientedao.close();
			return "redirect:/";
		}
		return "SenhasError";
	}
}
