package br.com.casadocodigo.livraria.controlador;

import java.util.List;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.casadocodigo.livraria.modelo.Estante;
import br.com.casadocodigo.livraria.modelo.Livro;
import br.com.casadocodigo.livraria.persistencia.UmaEstanteQualquer;

@Resource
public class LivrosController {

	public void formulario() {
	}

	public void salva(Livro livro, Result result) {
		Estante estante = new UmaEstanteQualquer();
		estante.guarda(livro);

		result.include("mensagem", "Livro salvo com sucesso!");
		result.redirectTo(this).lista();
	}

	public List<Livro> lista() {
		Estante estante = new UmaEstanteQualquer();
		return estante.todosOsLivros();
	}

	public void edita(String isbn, Result result) {
		Estante estante = new UmaEstanteQualquer();

		Livro livroEncontrado = estante.buscaPorIsbn(isbn);
		result.include(livroEncontrado);

		result.of(this).formulario();
	}
}
