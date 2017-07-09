package br.com.web.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.web.dao.ProdutoDao;
import br.com.web.dao.ProdutoJdbcDao;
import br.com.web.model.Produto;

@Controller
public class ProdutoController {

	private static String UPLOADED_FOLDER = "src/main/webapp/img/produtos/";

	@RequestMapping("/adm/gerenciar_produtos")
	public String getList(Model model) {
		ProdutoDao produtodao = new ProdutoJdbcDao();
		List<Produto> produtos = produtodao.getProdutos();

		model.addAttribute("produtos", produtos);

		produtodao.close();
		return "adm/ADM_GerenciarProdutos";
	}
	@PostMapping("/adm/gerenciar_produtos/add")
	public String addProduto(Produto produto,@RequestParam("classificacao") String classificacao,@RequestParam("file") MultipartFile file,
			RedirectAttributes redirectAttributes) {
		try {
			ProdutoDao produtodao = new ProdutoJdbcDao();
			// Get the file and save it somewhere 
			byte[] bytes = file.getBytes();
			Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
			Files.write(path, bytes);
			redirectAttributes.addFlashAttribute("msg", "You successfully uploaded '" + file.getOriginalFilename() + "'");
			produto.setImg_link("/img/produtos/" + file.getOriginalFilename());
			produto.setClassificacao(classificacao);
			produtodao.adiciona(produto);
			produtodao.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "redirect:/adm/gerenciar_produtos";
	}
	@PostMapping("/adm/gerenciar_produtos/edit")
	public String editProduto(Produto produto){

		return "redirect:/adm/gerenciar_produtos";
	}
	
	@RequestMapping("/adm/gerenciar_produtos/remove/{id}")
	public String removeProduto(@PathVariable("id") int id,
			RedirectAttributes redirectAttributes) {
		try {
			ProdutoDao produtodao = new ProdutoJdbcDao();
			Path path = Paths.get("src/main/webapp" + produtodao.getProduto(id).getImg_link());
			Files.delete(path);
			redirectAttributes.addFlashAttribute("msg","Removido com sucesso");
			produtodao.remove(id);
			produtodao.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "redirect:/adm/gerenciar_produtos";
	}
}
