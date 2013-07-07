package br.com.casadocodigo.livraria.modelo;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ArquivoNoBD extends Arquivo {

	@Id @GeneratedValue
	private Long id;

	public ArquivoNoBD(String nome, byte[] conteudo, String contentType,
			Calendar dataModificacao) {
		super(nome, conteudo, contentType, dataModificacao);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
