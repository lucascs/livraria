package br.com.casadocodigo.livraria.controlador;

import java.util.List;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.casadocodigo.livraria.modelo.Estante;
import br.com.casadocodigo.livraria.modelo.Livro;

@Resource
public class LivrosController {

	private final Estante estante;
	private Result result;

	public LivrosController(Estante estante, Result result) {
		this.estante = estante;
		this.result = result;
	}

	public void formulario() {
	}

	public void salva(Livro livro) {
		estante.guarda(livro);

		result.include("mensagem", "Livro salvo com sucesso!");
		result.redirectTo(this).lista();
	}

	public List<Livro> lista() {
		return estante.todosOsLivros();
	}

	public void edita(String isbn) {
		Livro livroEncontrado = estante.buscaPorIsbn(isbn);
		result.include(livroEncontrado);

		result.of(this).formulario();
	}
}
