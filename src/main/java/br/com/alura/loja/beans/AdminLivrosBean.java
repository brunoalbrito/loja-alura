package br.com.alura.loja.beans;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;

import br.com.alura.loja.models.Livro;
import lombok.Data;


@Data
@Named
@RequestScoped
public class AdminLivrosBean {
	
	
	private Livro livro = new Livro();
	
	public void salvar() {
		System.out.println("Livros cadastrado: "+ livro);
	}
}
