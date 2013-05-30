package br.com.casadocodigo.livraria.persistencia;

import java.util.List;

import br.com.casadocodigo.livraria.modelo.Estante;
import br.com.casadocodigo.livraria.modelo.Livro;

public class EstanteNoBancoDeDados implements Estante {

	private LivroDAO dao;

	public EstanteNoBancoDeDados(LivroDAO dao) {
		this.dao = dao;
	}

	@Override
	public void guarda(Livro livro) {
		this.dao.adiciona(livro);
	}

	@Override
	public List<Livro> todosOsLivros() {
		return this.dao.todos();
	}

	@Override
	public Livro buscaPorIsbn(String isbn) {
		return this.dao.buscaPorId(isbn);
	}

}
