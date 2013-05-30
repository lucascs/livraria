package br.com.casadocodigo.livraria.persistencia;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.ComponentFactory;

@Component
@ApplicationScoped
public class FabricaDeEntityManagerFactory implements ComponentFactory<EntityManagerFactory> {

	private EntityManagerFactory factory;

	public FabricaDeEntityManagerFactory() {
		factory = Persistence.createEntityManagerFactory("default");
	}

	@Override
	public EntityManagerFactory getInstance() {
		return this.factory;
	}

}
