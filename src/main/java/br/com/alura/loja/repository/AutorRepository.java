package br.com.alura.loja.repository;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

import br.com.alura.loja.models.Autor;

@Repository
public interface AutorRepository extends EntityRepository<Autor, Integer> {

}
