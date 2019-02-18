package br.com.alura.loja.models;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class CarrinhoItem implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Livro livro;
	
	@EqualsAndHashCode.Exclude
	private Integer quantidade;
	
	public CarrinhoItem() {
		this.quantidade = 1;
	}

}
