package teste;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.alura.loja.models.Livro;
import br.com.alura.loja.utils.JPAUtil;

public class TesteJPA {
	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();

		Livro livro = new Livro();
		livro.setTitulo("Livro de java");
		livro.setDescricao("Livro alura");
		livro.setNumeroPaginas(256);
		livro.setPreco(new BigDecimal(100));

		em.getTransaction().begin();
		em.persist(livro);
		em.getTransaction().commit();
	}
}
