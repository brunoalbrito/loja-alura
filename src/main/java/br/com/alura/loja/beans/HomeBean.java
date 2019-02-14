package br.com.alura.loja.beans;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.alura.loja.models.Livro;
import br.com.alura.loja.service.LivroService;

@Model
public class HomeBean {
	
	@Inject
	@RequestScoped
	private LivroService livroService;
	
	public List<Livro> ultimosLancamentos(){
		System.out.println("Caiu aqui");
		return livroService.listar();
	}
}
