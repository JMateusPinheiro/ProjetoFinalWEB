package br.com.web.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.web.dao.ProdutoDao;
import br.com.web.dao.ProdutoJdbcDao;
import br.com.web.model.Produto;

@Controller
public class ProdutoController {

	@RequestMapping("/adm/gerenciar_produtos")
	public String getList(Model model) throws SQLException	{
		ProdutoDao produtodao = new ProdutoJdbcDao();
		List<Produto> produtos = produtodao.getProdutos();

		model.addAttribute("produtos", produtos);

		produtodao.close();
		return "adm/ADM_GerenciarProdutos";
	}
}
