package br.com.casadocodigo.livraria.site.servico;

public class ServidorIndisponivelException extends RuntimeException {
	public ServidorIndisponivelException(String url, Exception e) {
		super("Erro ao fazer requisição ao servidor na url " + url, e);
	}
}