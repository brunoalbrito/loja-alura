package br.com.alura.loja.beans;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Part;

import br.com.alura.loja.infra.FileSaver;
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

	private Livro livro = new Livro();

	@Inject
	private FacesContext context;

	private Part capaLivro;
	
	private String path = "imagem";
	
	public String salvar() throws IOException {
		
		FileSaver fileSaver = new FileSaver();
		livro.setCapaPath(fileSaver.path(capaLivro, path));
		
		livroService.save(livro);
		
		context.getExternalContext().getFlash().setKeepMessages(true);

		context.addMessage(null, new FacesMessage("Livro Cadastrado com sucesso"));

		// Forward
		return "/livros/lista?faces-redirect=true";
	}

	public List<Autor> getAutores() {
		return autorService.listar();
	}
}
