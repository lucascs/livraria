package br.com.casadocodigo.livraria.site.controlador;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.casadocodigo.livraria.site.modelo.Acervo;

@Resource
public class HomeController {

	private Acervo acervo;
	private Result result;

	public HomeController(Acervo acervo, Result result) {
		this.acervo = acervo;
		this.result = result;
	}

	public void inicio() {
		result.include("livros", acervo.todosOsLivros());
	}
}
