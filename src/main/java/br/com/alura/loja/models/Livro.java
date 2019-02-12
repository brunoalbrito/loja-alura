package br.com.alura.loja.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Data
@Entity
@SequenceGenerator(name = "seq_livro", sequenceName = "pk_livro", allocationSize = 1)
public class Livro {
	
	@Id
	@GeneratedValue(generator = "seq_livro", strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	private String titulo;
	
	private String descricao;
	
	private Integer numeroPaginas;
	
	private BigDecimal preco;
	
	@ManyToMany
	private List<Autor> autores = new ArrayList<>();
}
