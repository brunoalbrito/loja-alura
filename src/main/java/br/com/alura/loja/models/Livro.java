package br.com.alura.loja.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

@Data
@Entity
public class Livro {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String titulo;
	
	private String descricao;
	
	private Integer numerdoPaginas;
	
	private BigDecimal preco;
	
	@ManyToMany
	private List<Autor> autores = new ArrayList<>();
}
