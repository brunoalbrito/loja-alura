package br.com.alura.loja.infra;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.deltaspike.jpa.api.entitymanager.PersistenceUnitName;

@ApplicationScoped
public class EntityManagerProducer {

	@Inject
	@PersistenceUnitName("postgres")
	private static EntityManagerFactory entityManagerFactory;
	
	@Produces
	@RequestScoped
	public EntityManager create() {
		return entityManagerFactory.createEntityManager();
	}

	public void dispose(@Disposes EntityManager entityManager) {
		if (entityManager.isOpen()) {
			entityManager.close();
		}
	}

}
