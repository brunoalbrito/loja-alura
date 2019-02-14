package br.com.alura.loja.beans;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.alura.loja.models.Livro;
import br.com.alura.loja.service.LivroService;
import lombok.Data;

@Data
@Model
public class LivroDetalheBean {

	@Inject
	private LivroService livroService;
	
	private Livro livro = new Livro();
	
	private Integer id;
	
	public void carregarDetalhe() {
		this.livro = livroService.buscaPorId(id);
	}
}
