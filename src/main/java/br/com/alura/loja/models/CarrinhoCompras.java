package br.com.alura.loja.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import lombok.Data;

@Data
@Named
@SessionScoped
public class CarrinhoCompras implements Serializable {

	private static final long serialVersionUID = 1L;

	private Set<CarrinhoItem> itens = new HashSet<CarrinhoItem>();

	private Integer quantidadeTotal = 0;

	public void add(CarrinhoItem item) {
		itens.add(item);
	}

	public BigDecimal getTotal(CarrinhoItem item) {
		BigDecimal total = new BigDecimal(0);
		total = item.getLivro().getPreco().multiply((new BigDecimal(item.getQuantidade())));
		return total;
	}

	public BigDecimal getTotal() {
		BigDecimal total = new BigDecimal(0);
		for (CarrinhoItem carrinhoItem : itens) {
			total = total.add(carrinhoItem.getLivro().getPreco()
					.multiply((new BigDecimal(carrinhoItem.getQuantidade()))));
		}
		return total;
	}

	public List<CarrinhoItem> getItens() {
		return new ArrayList<CarrinhoItem>(itens);
	}
}
