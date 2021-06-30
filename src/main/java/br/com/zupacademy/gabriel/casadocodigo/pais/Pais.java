package br.com.zupacademy.gabriel.casadocodigo.pais;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import br.com.zupacademy.gabriel.casadocodigo.estado.Estado;

@Entity
public class Pais {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String nome;
	@OneToMany(mappedBy = "pais")
	private List<Estado> estados = new ArrayList<>();
	
	@Deprecated
	public Pais() {
	}
	
	public Pais(@NotBlank String nome) {
		super();
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	
	
	
	
	

}
