package br.com.zupacademy.gabriel.casadocodigo.estado;

public class EstadoResponse {

	private String nome;
	private String pais;
	
	public EstadoResponse(Estado estado) {
		this.nome = estado.getNome();
		this.pais = estado.getPais().getNome();
	}

	public String getNome() {
		return nome;
	}

	public String getPais() {
		return pais;
	}
	
	

}
