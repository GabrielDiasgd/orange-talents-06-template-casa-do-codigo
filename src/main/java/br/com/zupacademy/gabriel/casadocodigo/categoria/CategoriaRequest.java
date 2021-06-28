package br.com.zupacademy.gabriel.casadocodigo.categoria;

import javax.validation.constraints.NotBlank;

public class CategoriaRequest {
	
	@NotBlank
	private String nome;

	public CategoriaRequest(@NotBlank String nome) {
		super();
		this.nome = nome;
	}
	
	public CategoriaRequest() {
		super();
	}

	public String getNome() {
		return nome;
	}

	public Categoria toModel() {
		return new Categoria(this.nome);
	}

	

}
