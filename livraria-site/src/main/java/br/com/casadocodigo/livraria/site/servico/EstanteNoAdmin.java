package br.com.casadocodigo.livraria.site.servico;

import java.util.List;

import br.com.casadocodigo.livraria.site.modelo.Estante;
import br.com.casadocodigo.livraria.site.modelo.Livro;

import com.thoughtworks.xstream.XStream;

public class EstanteNoAdmin implements Estante {

	private ClienteHTTP http;

	public EstanteNoAdmin(ClienteHTTP http) {
		this.http = http;
	}

	@Override
	public List<Livro> todosOsLivros() {
		String xml = http
				.get("http://localhost:8080/livraria-admin/integracao/listaLivros");
		XStream xstream = new XStream();
		xstream.alias("livros", List.class);
		xstream.alias("livro", Livro.class);
		List<Livro> livros = (List<Livro>) xstream.fromXML(xml);
		return livros;
	}
}
