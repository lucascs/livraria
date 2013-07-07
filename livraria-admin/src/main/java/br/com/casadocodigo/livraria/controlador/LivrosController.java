package br.com.casadocodigo.livraria.controlador;

import java.io.IOException;
import java.net.URI;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.interceptor.download.ByteArrayDownload;
import br.com.caelum.vraptor.interceptor.download.Download;
import br.com.caelum.vraptor.interceptor.multipart.UploadedFile;
import br.com.casadocodigo.livraria.aspecto.Transacional;
import br.com.casadocodigo.livraria.modelo.Arquivo;
import br.com.casadocodigo.livraria.modelo.DiretorioDeImagens;
import br.com.casadocodigo.livraria.modelo.Estante;
import br.com.casadocodigo.livraria.modelo.Livro;

import com.google.common.io.ByteStreams;

@Resource
public class LivrosController {

	private final Estante estante;
	private Result result;
	private Validator validator;
	private DiretorioDeImagens imagens;

	public LivrosController(Estante estante, DiretorioDeImagens imagens,
			Result result, Validator validator) {
		this.estante = estante;
		this.imagens = imagens;
		this.result = result;
		this.validator = validator;
	}

	@Get("/livros/formulario")
	public void formulario() {
	}

	@Transacional
	@Post("/livros")
	public void salva(final Livro livro, UploadedFile capa)
			throws IOException {
		validator.validate(livro);
		validator.onErrorRedirectTo(this).formulario();

		if (capa != null) {
			URI imagemCapa = imagens.grava(new Arquivo(capa.getFileName(),
					ByteStreams.toByteArray(capa.getFile()),
					capa.getContentType(), Calendar.getInstance()));

			livro.setCapa(imagemCapa);
		}

		estante.guarda(livro);

		result.include("mensagem", "Livro salvo com sucesso!");
		result.redirectTo(this).lista();
	}

	@Get("/livros")
	public List<Livro> lista() {
		return estante.todosOsLivros();
	}

	@Get @Path(value="/livros/{isbn}", priority=Path.LOWEST)
	public void edita(String isbn) {
		Livro livroEncontrado = estante.buscaPorIsbn(isbn);
		if (livroEncontrado == null) {
			result.notFound();
		} else {
			result.include(livroEncontrado);

			result.of(this).formulario();
		}
	}

	@Get("/livros/{isbn}/capa")
	public Download capa(String isbn) {
		Livro livro = estante.buscaPorIsbn(isbn);

		Arquivo capa = imagens.recupera(livro.getCapa());

		if (capa == null) {
			result.notFound();
			return null;
		}

		return new ByteArrayDownload(capa.getConteudo(),
				capa.getContentType(), capa.getNome());
	}
}
