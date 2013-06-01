package br.com.casadocodigo.livraria.controlador;

import java.math.BigDecimal;
import java.util.List;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.Validations;
import br.com.casadocodigo.livraria.modelo.Estante;
import br.com.casadocodigo.livraria.modelo.Livro;

@Resource
public class LivrosController {

	private final Estante estante;
	private Result result;
	private Validator validator;

	public LivrosController(Estante estante, Result result, Validator validator) {
		this.estante = estante;
		this.result = result;
		this.validator = validator;
	}

	public void formulario() {
	}

	public void salva(final Livro livro) {
		validator.checking(new Validations() {{
			that(livro.getTitulo() != null, "titulo", "campo.obrigatorio", "título");

			if (that(livro.getPreco() != null, "preco", "campo.obrigatorio", "preco"))
				that(livro.getPreco().compareTo(BigDecimal.ZERO) > 0,
						"preco", "campo.maior.que", "preço", 0);

			that(livro.getIsbn() != null, "isbn", "campo.obrigatorio", "isbn");
		}});

		validator.onErrorRedirectTo(this).formulario();

		estante.guarda(livro);

		result.include("mensagem", "Livro salvo com sucesso!");
		result.redirectTo(this).lista();
	}

	public List<Livro> lista() {
		return estante.todosOsLivros();
	}

	public void edita(String isbn) {
		Livro livroEncontrado = estante.buscaPorIsbn(isbn);
		if (livroEncontrado == null) {
			result.notFound();
		} else {
			result.include(livroEncontrado);

			result.of(this).formulario();
		}
	}
}
