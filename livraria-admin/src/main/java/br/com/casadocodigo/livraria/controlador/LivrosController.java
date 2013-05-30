package br.com.casadocodigo.livraria.controlador;

import java.util.List;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.casadocodigo.livraria.modelo.Estante;
import br.com.casadocodigo.livraria.modelo.Livro;

@Resource
public class LivrosController {

	private final Estante estante;

	public LivrosController(Estante estante) {
		this.estante = estante;
	}

	public void formulario() {
	}

	public void salva(Livro livro, Result result) {
		estante.guarda(livro);

		result.include("mensagem", "Livro salvo com sucesso!");
		result.redirectTo(this).lista();
	}

	public List<Livro> lista() {
		return estante.todosOsLivros();
	}

	public void edita(String isbn, Result result) {
		Livro livroEncontrado = estante.buscaPorIsbn(isbn);
		result.include(livroEncontrado);

		result.of(this).formulario();
	}
}
