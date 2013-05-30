package br.com.casadocodigo.livraria.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.ComponentFactory;

@Component
public class FabricaDeEntityManager implements ComponentFactory<EntityManager> {

	private EntityManagerFactory factory;

	public FabricaDeEntityManager(EntityManagerFactory factory) {
		this.factory = factory;
	}

	@Override
	public EntityManager getInstance() {
		return this.factory.createEntityManager();
	}

}
