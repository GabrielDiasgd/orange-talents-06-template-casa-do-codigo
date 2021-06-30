package br.com.zupacademy.gabriel.casadocodigo.pais;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import br.com.zupacademy.gabriel.casadocodigo.config.validation.UniqueValue;

public class PaisRequest {
	

	@NotBlank
	@UniqueValue(domainClass = Pais.class, fieldName = "nome")
	private String nome;

	@JsonCreator(mode = Mode.PROPERTIES )
	public PaisRequest(@NotBlank String nome) {
		super();
		this.nome = nome;
	}

	public Pais toModel() {
		return new Pais(this.nome);
	}
	
	

}
