package br.com.casadocodigo.livraria.modelo;

import java.math.BigDecimal;

public class Dinheiro {
	private Moeda moeda;
	private BigDecimal montante;

	public Dinheiro(Moeda moeda, BigDecimal montante) {
		this.moeda = moeda;
		this.montante = montante;
	}

	public Moeda getMoeda() {
		return moeda;
	}

	public BigDecimal getMontante() {
		return montante;
	}
}
