package br.com.casadocodigo.livraria.persistencia;

import java.net.URI;

import javax.persistence.EntityManager;

import br.com.caelum.vraptor.ioc.Component;
import br.com.casadocodigo.livraria.modelo.Arquivo;
import br.com.casadocodigo.livraria.modelo.ArquivoNoBD;
import br.com.casadocodigo.livraria.modelo.DiretorioDeImagens;

@Component
public class DiretorioDeImagensNoBD implements DiretorioDeImagens {

	private EntityManager manager;

	public DiretorioDeImagensNoBD(EntityManager manager) {
		this.manager = manager;
	}

	@Override
	public URI grava(Arquivo arquivo) {
		ArquivoNoBD arquivoNoBD = new ArquivoNoBD(arquivo.getNome(),
				arquivo.getConteudo(), arquivo.getContentType(),
				arquivo.getDataModificacao());
		manager.persist(arquivoNoBD);

		return URI.create("bd://" + arquivoNoBD.getId());
	}

	@Override
	public Arquivo recupera(URI chave) {
		// TODO Auto-generated method stub
		return null;
	}

}
