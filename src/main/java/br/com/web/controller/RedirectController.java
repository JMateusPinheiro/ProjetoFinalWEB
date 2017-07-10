package br.com.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.web.dao.ProdutoDao;
import br.com.web.dao.ProdutoJdbcDao;
import br.com.web.dao.ServicoDao;
import br.com.web.dao.ServicoJdbcDao;
import br.com.web.model.Carrinho;
import br.com.web.model.Item;
import br.com.web.model.Produto;
import br.com.web.model.Usuario;

@Controller
public class RedirectController {

	@RequestMapping("/")
	public String home(Model model)  {
		ProdutoDao produtodao = new ProdutoJdbcDao();
		List<Produto> produtos = produtodao.getProdutos();
		model.addAttribute("produtos", produtos);
		produtodao.close();
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
	
	@RequestMapping("/adm/gerenciar_produtos/FormAdd")
	public String addProduto(HttpServletRequest req){
		req.setAttribute("path", "add");
		return "adm/ADM_AddProdutoForm";
	}
	
	@RequestMapping("/produto/{id}")
	public String visualizarProduto(@PathVariable("id") int id, HttpServletRequest req){
		ProdutoDao produtodao = new ProdutoJdbcDao();
		req.setAttribute("produto", produtodao.getProduto(id));
		produtodao.close();
		return "VerProduto";
	}
	
	@GetMapping("/produtos")
	public String exProduto(@RequestParam("animal") String animal, HttpServletRequest req){
		ProdutoDao produtodao = new ProdutoJdbcDao();
		req.setAttribute("produtos", produtodao.getProdutosByClassificacao(animal));
		produtodao.close();
		return "ProdutosExpecificos";
	}
	
//	@RequestMapping("/usuario/carrinho/add/{produto_id}")
//	public void addCarrinho(HttpServletRequest req, @PathVariable("produto_id") int produto_id){
//		Carrinho carrinho1 = (Carrinho) req.getSession().getAttribute("carrinho");
//		ProdutoDao produtodao = new ProdutoJdbcDao();
//		Usuario usuario = (Usuario) req.getSession().getAttribute("usuario");
//		Item item = new Item();
//		item.setProduto(produtodao.getProduto(produto_id));
//		item.setUsuario_id(usuario.getId());
//		Carrinho carrinho = new Carrinho();
//		carrinho.getCarrinho().add(item);
//		carrinho1 = carrinho;
//		req.getSession().setAttribute("carrinho", carrinho1);
//	}
}
