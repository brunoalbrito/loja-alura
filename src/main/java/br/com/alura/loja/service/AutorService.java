package br.com.alura.loja.service;

import java.util.List;

import javax.inject.Inject;

import org.apache.deltaspike.jpa.api.transaction.Transactional;

import br.com.alura.loja.models.Autor;
import br.com.alura.loja.repository.AutorRepository;

@Transactional
public class AutorService {
	
	@Inject
	private AutorRepository repository;

	public List<Autor> listar() {
		return repository.findAll();
	}
}
