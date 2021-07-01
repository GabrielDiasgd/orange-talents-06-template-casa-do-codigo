package br.com.zupacademy.gabriel.casadocodigo.cliente;

import java.util.Optional;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.gabriel.casadocodigo.config.validation.Documento;
import br.com.zupacademy.gabriel.casadocodigo.config.validation.ExistsId;
import br.com.zupacademy.gabriel.casadocodigo.config.validation.UniqueValue;
import br.com.zupacademy.gabriel.casadocodigo.estado.Estado;
import br.com.zupacademy.gabriel.casadocodigo.estado.EstadoRepository;
import br.com.zupacademy.gabriel.casadocodigo.pais.Pais;
import br.com.zupacademy.gabriel.casadocodigo.pais.PaisRepository;

public class ClienteRequest {
	
	@NotBlank
	private String nome;
	@NotBlank @Email @UniqueValue(domainClass = Cliente.class, fieldName = "email")
	private String email;
	@NotBlank
	private String sobrenome;
	@NotBlank @Documento @UniqueValue(domainClass = Cliente.class, fieldName = "documento")
	private String documento;
	@NotBlank
	private String endereco;
	@NotBlank
	private String complemento;
	@NotBlank
	private String cidade;
	@NotNull
	@ExistsId(domainClass = Pais.class, fieldName = "id")
	private Long idPais;
	@ExistsId(domainClass = Estado.class, fieldName = "id")
	private Long idEstado;
	@NotBlank
	private String telefone;
	@NotBlank
	private String cep;
	
	public ClienteRequest(@NotBlank String nome, @NotBlank @Email String email, @NotBlank String sobrenome,
			@NotBlank String documento, @NotBlank String endereco, @NotBlank String complemento, @NotBlank String cidade,
			@NotNull Long idPais, Long idEstado, @NotBlank String telefone, @NotBlank String cep) {
		super();
		this.nome = nome;
		this.email = email;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.idPais = idPais;
		this.idEstado = idEstado;
		this.telefone = telefone;
		this.cep = cep;
	}
	
	public Long getIdPais() {
		return idPais;
	}

	public Long getIdEstado() {
		return idEstado;
	}



	public Cliente toModel(PaisRepository paisRepository, EstadoRepository estadoRepository) {
		Optional<Pais> pais = paisRepository.findById(this.idPais);
		
		Cliente cliente = new Cliente(this.nome, this.email, this.sobrenome, this.documento, this.endereco, 
				this.complemento, this.cidade, pais.get(), this.telefone, this.cep);

		if (pais.get().getEstados().isEmpty()) {
			return cliente;
	} 
		if (idEstado != null) {
			Optional<Estado> estado = estadoRepository.findById(idEstado);
			cliente.setEstado(estado.get());
		}
			return cliente;
		
	
	}
	
	
	public boolean temEstado() {
		return Optional.ofNullable(idEstado).isPresent();
	}

	
}
