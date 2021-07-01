package br.com.zupacademy.gabriel.casadocodigo.estado;

import java.util.Optional;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.gabriel.casadocodigo.config.validation.ExisteNomeEstadoEmPais;
import br.com.zupacademy.gabriel.casadocodigo.config.validation.ExistsId;
import br.com.zupacademy.gabriel.casadocodigo.pais.Pais;
import br.com.zupacademy.gabriel.casadocodigo.pais.PaisRepository;

@ExisteNomeEstadoEmPais
public class EstadoRequest {
	
	@NotBlank
	private String nome;
	@NotNull
	@ExistsId(domainClass = Pais.class, fieldName = "id")
	private Long idPais;
	
	
	public EstadoRequest(@NotBlank String nome, @NotNull Long idPais) {
		super();
		this.nome = nome;
		this.idPais = idPais;
	}
	
	
	public String getNome() {
		return nome;
	}


	public Long getIdPais() {
		return idPais;
	}


	public Estado toModel(PaisRepository paisRepository) {
		@NotNull Optional<Pais> pais = paisRepository.findById(this.idPais);
		if (pais.isEmpty()) {
			throw new IllegalArgumentException("Algo estraho aconteceu e o pais está vázio");
		}
		return new Estado(this.nome, pais.get());
	}
	
	
	

}
