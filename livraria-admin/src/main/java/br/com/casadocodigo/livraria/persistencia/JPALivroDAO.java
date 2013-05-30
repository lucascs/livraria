package br.com.casadocodigo.livraria.persistencia;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.caelum.vraptor.ioc.Component;
import br.com.casadocodigo.livraria.modelo.Livro;

@Component
public class JPALivroDAO implements LivroDAO {

	private EntityManager manager;

	public JPALivroDAO(EntityManager manager) {
		this.manager = manager;
	}

	@Override
	public void adiciona(Livro livro) {
		this.manager.persist(livro);
	}

	@Override
	public List<Livro> todos() {
		return this.manager
				.createQuery("select l from Livro l", Livro.class)
				.getResultList();
	}

	@Override
	public Livro buscaPorId(String isbn) {
		return this.manager.find(Livro.class, isbn);
	}

}
