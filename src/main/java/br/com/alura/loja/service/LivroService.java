package br.com.alura.loja.service;

import java.util.List;

import javax.inject.Inject;

import org.apache.deltaspike.jpa.api.transaction.Transactional;

import br.com.alura.loja.models.Livro;
import br.com.alura.loja.repository.LivroRepository;

@Transactional
public class LivroService {
	
	@Inject
	private LivroRepository repository;

	public void save(Livro livro) {
		repository.save(livro);
	}

	public List<Livro> listar() {
		return repository.findAll();
	}

	public Livro buscaPorId(Integer id) {
		return repository.findBy(id);
	}

}
