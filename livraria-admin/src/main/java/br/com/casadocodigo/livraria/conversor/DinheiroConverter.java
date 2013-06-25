package br.com.casadocodigo.livraria.conversor;

import java.math.BigDecimal;
import java.util.ResourceBundle;

import br.com.caelum.vraptor.Convert;
import br.com.caelum.vraptor.Converter;
import br.com.casadocodigo.livraria.modelo.Dinheiro;
import br.com.casadocodigo.livraria.modelo.Moeda;

@Convert(Dinheiro.class)
public class DinheiroConverter
			implements Converter<Dinheiro> {

	@Override
	public Dinheiro convert(
			String value,
			Class<? extends Dinheiro> type,
			ResourceBundle bundle) {

		if (value.startsWith("R$")) {
			return new Dinheiro(Moeda.REAL,
				new BigDecimal(
						value.replace("R$ ", "")
							.replace(',', '.')
				)
			);
		}
		return null;
	}
}
