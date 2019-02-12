package br.com.alura.loja.repository;

import org.apache.deltaspike.data.api.Repository;

import br.com.alura.loja.models.Livro;

import java.util.List;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Query;

@Repository
public interface LivroRepository extends EntityRepository<Livro, Integer>{

}
