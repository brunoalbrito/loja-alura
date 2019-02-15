package br.com.alura.loja.beans;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.alura.loja.models.CarrinhoCompras;
import br.com.alura.loja.models.CarrinhoItem;
import br.com.alura.loja.models.Livro;
import br.com.alura.loja.service.LivroService;
import lombok.Data;

@Data
@Model
public class CarrinhoComprasBean {

	@Inject
	private LivroService service;

	@Inject
	private CarrinhoCompras carrinho;

	public String add(Integer id) {
		Livro livro = service.buscaPorId(id);
		CarrinhoItem item = new CarrinhoItem();
		carrinho.add(item);

		return "carrinho?faces-redirect=true";
	}
}
