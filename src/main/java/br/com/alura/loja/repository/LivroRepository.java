package br.com.alura.loja.repository;

import org.apache.deltaspike.data.api.Repository;

import br.com.alura.loja.models.Livro;

import org.apache.deltaspike.data.api.EntityRepository;

@Repository
public interface LivroRepository extends EntityRepository<Livro, Integer>{

}
