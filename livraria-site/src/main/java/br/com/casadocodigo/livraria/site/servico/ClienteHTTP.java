package br.com.casadocodigo.livraria.site.servico;

public interface ClienteHTTP {

	String get(String url) throws ServidorIndisponivelException;;

}
