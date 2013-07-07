package br.com.casadocodigo.livraria.modelo;

import java.net.URI;

public interface DiretorioDeImagens {

	URI grava(Arquivo arquivo);

	Arquivo recupera(URI chave);
}
