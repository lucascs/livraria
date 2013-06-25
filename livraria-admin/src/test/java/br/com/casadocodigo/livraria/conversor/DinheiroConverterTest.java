package br.com.casadocodigo.livraria.conversor;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;
import java.util.ResourceBundle;

import org.junit.Test;

import br.com.caelum.vraptor.Converter;
import br.com.caelum.vraptor.converter.ConversionError;
import br.com.casadocodigo.livraria.modelo.Dinheiro;
import br.com.casadocodigo.livraria.modelo.Moeda;

public class DinheiroConverterTest {

	@Test
	public void converteUmValorEmReais() {
		Converter<Dinheiro> converter = new DinheiroConverter();
		assertThat(converter.convert("R$ 1,00", null, null),
				is(new Dinheiro(Moeda.REAL, new BigDecimal("1.00"))));
	}

	@Test
	public void converteUmValorEmDolares() {
		Converter<Dinheiro> converter = new DinheiroConverter();
		assertThat(converter.convert("US$ 49,95", null, null),
				is(new Dinheiro(Moeda.DOLAR, new BigDecimal("49.95"))));
	}

	@Test(expected=ConversionError.class)
	public void lancaErroDeConversaoQuandoOValorEhInvalido() {
		Converter<Dinheiro> converter = new DinheiroConverter();
		converter.convert("noventa pratas!", null, ResourceBundle.getBundle("messages"));
	}

	@Test(expected=ConversionError.class)
	public void lancaErroDeConversaoQuandoOMontanteEhInvalido() {
		Converter<Dinheiro> converter = new DinheiroConverter();
		converter.convert("R$ mil", null, ResourceBundle.getBundle("messages"));
	}
}
