package br.com.casadocodigo.livraria.site.servico;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;

import br.com.caelum.vraptor.ioc.Component;

import com.google.common.io.CharStreams;

@Component
public class URLClienteHTTP implements ClienteHTTP {

	@Override
	public String get(String url) {
		try {
			URL servico = new URL(url);
			InputStream resposta = servico.openStream();
			Reader reader = new InputStreamReader(resposta);
		    return CharStreams.toString(reader);
		} catch (MalformedURLException e) {
			throw new IllegalArgumentException("A url " + url + " está inválida, corrija-a!");
		} catch (IOException e) {
			throw new ServidorIndisponivelException(url, e);
		}
	}

}
