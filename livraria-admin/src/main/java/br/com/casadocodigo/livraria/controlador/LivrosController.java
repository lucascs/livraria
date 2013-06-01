package br.com.casadocodigo.livraria.controlador;

import java.math.BigDecimal;
import java.util.List;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.ValidationMessage;
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
			validator.add(new ValidationMessage("título é obrigatório", "titulo"));
		}
		if (livro.getPreco() == null
				|| livro.getPreco().compareTo(BigDecimal.ZERO) < 0) {
			validator.add(new ValidationMessage("preço é obrigatório e deve ser positivo", "preco"));
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
