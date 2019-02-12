package br.com.alura.loja.beans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.alura.loja.models.Livro;
import br.com.alura.loja.service.LivroService;
import lombok.Data;

@Data
@Model
public class AdminLivrosListaBean {

	@Inject
	private LivroService service;
	
	private List<Livro> livros = new ArrayList<Livro>();
	
	public List<Livro> getLivros(){
//		Livro l = new Livro();
//		l.setTitulo("Sucesso");
		this.livros = service.listar(); 
		return livros;
	}
}
