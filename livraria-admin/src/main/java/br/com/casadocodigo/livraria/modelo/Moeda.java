package br.com.casadocodigo.livraria.modelo;

public enum Moeda {
	REAL("R$"), DOLAR("US$"),
	EURO("€"), LIBRA("£");

	private final String simbolo;

	private Moeda(String simbolo) {
		this.simbolo = simbolo;
	}

	public String getSimbolo() {
		return simbolo;
	}
}
