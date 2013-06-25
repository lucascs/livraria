package br.com.casadocodigo.livraria.modelo;

import java.util.Calendar;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Livro {
	@Id @NotEmpty
	private String isbn;

	@NotEmpty(message="{campo.obrigatorio}")
	private String titulo;
	private String descricao;

	@Embedded
	private Dinheiro preco;

	@Past
	private Calendar dataPublicacao;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Dinheiro getPreco() {
		return preco;
	}

	public void setPreco(Dinheiro preco) {
		this.preco = preco;
	}

	public Calendar getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(Calendar dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}
}