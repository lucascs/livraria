package br.com.casadocodigo.livraria.site.controlador;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.casadocodigo.livraria.site.modelo.Estante;

@Resource
public class HomeController {

	private Estante estante;
	private Result result;

	public HomeController(Estante estante, Result result) {
		this.estante = estante;
		this.result = result;
	}

	public void inicio() {
		result.include("livros", estante.todosOsLivros());
	}
}
