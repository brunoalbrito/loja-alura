package br.com.alura.loja.models;

import java.util.HashSet;
import java.util.Set;

import lombok.Data;

@Data
public class CarrinhoCompras {

	private Set<CarrinhoItem> itens = new HashSet<CarrinhoItem>();
	
	public void add(CarrinhoItem item) {
		itens.add(item);
	}
}
