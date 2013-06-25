package br.com.casadocodigo.livraria.conversor;

import java.util.ResourceBundle;

import br.com.caelum.vraptor.Convert;
import br.com.caelum.vraptor.Converter;
import br.com.casadocodigo.livraria.modelo.Dinheiro;

@Convert(Dinheiro.class)
public class DinheiroConverter
			implements Converter<Dinheiro> {

	@Override
	public Dinheiro convert(
			String value,
			Class<? extends Dinheiro> type,
			ResourceBundle bundle) {
		return null;
	}

}
