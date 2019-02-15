package br.com.alura.loja.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class CarrinhoItem {
	
	private Livro livro;
	
	@EqualsAndHashCode.Exclude
	private Integer quantidade;
	
	public CarrinhoItem() {
		this.quantidade = 1;
	}

}
