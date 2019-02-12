package br.com.alura.loja.beans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.alura.loja.models.Autor;
import br.com.alura.loja.models.Livro;
import br.com.alura.loja.service.AutorService;
import br.com.alura.loja.service.LivroService;
import lombok.Data;

@Data
@Named
@RequestScoped
public class AdminLivrosBean {

	
	@Inject
	@RequestScoped
	private LivroService livroService;
	
	@Inject
	@RequestScoped
	private AutorService autorService;
	
	private List<Integer> autoresId = new ArrayList<Integer>();
	 
	private Livro livro = new Livro();

	public void salvar() {
		for (Integer autorId : autoresId) {
			livro.getAutores().add(new Autor(autorId));
		}
		livroService.save(livro);
		livro = new Livro();
		autoresId = new ArrayList<>();
		System.out.println("Livros cadastrado: " + livro);
	}
	
	public List<Autor> getAutores(){
		return autorService.listar();
	}
}
