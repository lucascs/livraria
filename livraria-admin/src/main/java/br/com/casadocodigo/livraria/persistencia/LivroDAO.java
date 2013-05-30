package br.com.casadocodigo.livraria.persistencia;

import java.util.List;

import br.com.casadocodigo.livraria.modelo.Livro;

public interface LivroDAO {
	void adiciona(Livro livro);
	List<Livro> todos();
	Livro buscaPorId(String isbn);
}
