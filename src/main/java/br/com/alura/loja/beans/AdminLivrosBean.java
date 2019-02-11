package br.com.alura.loja.beans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.alura.loja.models.Livro;
import br.com.alura.loja.service.LivroService;
import lombok.Data;

@Data
@Named
@RequestScoped
public class AdminLivrosBean {

	
	@Inject
	@RequestScoped
	private LivroService livroService;
	 
	private Livro livro = new Livro();

	public void salvar() {
		livroService.save(livro);
		System.out.println("Livros cadastrado: " + livro);
	}
}
