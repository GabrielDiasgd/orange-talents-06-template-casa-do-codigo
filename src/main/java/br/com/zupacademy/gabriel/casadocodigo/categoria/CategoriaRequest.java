package br.com.zupacademy.gabriel.casadocodigo.categoria;

import javax.validation.constraints.NotBlank;

import br.com.zupacademy.gabriel.casadocodigo.config.validation.UniqueValue;

public class CategoriaRequest {
	
	@NotBlank
	@UniqueValue(domainClass = Categoria.class, fieldName = "nome")
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
