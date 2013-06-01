package br.com.casadocodigo.livraria.controlador;

import java.math.BigDecimal;
import java.util.List;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.I18nMessage;
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

	public void salva(Livro livro) {
		if (livro.getTitulo() == null) {
			validator.add(new I18nMessage("titulo", "campo.obrigatorio", "título"));
		}

		if (livro.getPreco() == null) {
			validator.add(new I18nMessage("preco", "campo.obrigatorio", "preço"));
		} else if (livro.getPreco().compareTo(BigDecimal.ZERO) < 0) {
			validator.add(new I18nMessage("preco", "campo.maior.que", "preço", 0));
		}

		if (livro.getIsbn() == null) {
			validator.add(new I18nMessage("isbn", "campo.obrigatorio", "isbn"));
		}

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
