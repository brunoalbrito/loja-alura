package br.com.alura.loja.beans;

import java.io.IOException;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Part;

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

	public String salvar() throws IOException {
		livroService.save(livro);

		capaLivro.write("/home/bruno/loja-alura/imagem/" + capaLivro.getSubmittedFileName());

		context.getExternalContext().getFlash().setKeepMessages(true);

		context.addMessage(null, new FacesMessage("Livro Cadastrado com sucesso"));

		// Forward
		return "/livros/lista?faces-redirect=true";
	}

	public List<Autor> getAutores() {
		return autorService.listar();
	}
}
