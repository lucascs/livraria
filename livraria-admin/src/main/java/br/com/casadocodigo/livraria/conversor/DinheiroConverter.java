package br.com.casadocodigo.livraria.conversor;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.ResourceBundle;

import br.com.caelum.vraptor.Convert;
import br.com.caelum.vraptor.Converter;
import br.com.caelum.vraptor.converter.ConversionError;
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

		for (Moeda moeda : Moeda.values()) {
			if (value.startsWith(moeda.getSimbolo())) {
				return new Dinheiro(moeda,
						new BigDecimal(
							value.replace(moeda.getSimbolo(), "")
								.replace(',', '.').trim()
						)
				);
			}
		}
		throw new ConversionError(
			MessageFormat.format(bundle.getString("dinheiro_invalido"), value)
		);

	}
}
