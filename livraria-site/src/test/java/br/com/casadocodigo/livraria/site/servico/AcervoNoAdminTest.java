package br.com.casadocodigo.livraria.site.servico;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;

import br.com.casadocodigo.livraria.site.modelo.Livro;

public class AcervoNoAdminTest {

	@Test
	public void converteUmaListaComApenasUmLivro() {
		ClienteHTTP http = new ClienteHTTP() {
			@Override
			public String get(String url) {
				return
					"<livros>" +
						"<livro>" +
							"<titulo>VRaptor 3</titulo>" +
							"<isbn>12345</isbn>" +
						"</livro>" +
					"</livros>";
			}
		};
		AcervoNoAdmin acervo = new AcervoNoAdmin(http);

		List<Livro> livros = acervo.todosOsLivros();

		assertThat(livros.size(), is(1));

		Livro livro = livros.get(0);
		assertThat(livro.getTitulo(), is("VRaptor 3"));
		assertThat(livro.getIsbn(), is("12345"));
	}
}
