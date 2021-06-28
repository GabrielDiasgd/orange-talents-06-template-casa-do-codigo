package br.com.zupacademy.gabriel.casadocodigo.autor;

public class AutorResponse {
	
	private Long id;
	private String nome;
	private String email;
	private String descricao;
	
	public AutorResponse(Autor autor) {
		this.id = autor.getId();
		this.nome = autor.getNome();
		this.email = autor.getEmail();
		this.descricao = autor.getDescricao();
	}
	
	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public String getEmail() {
		return email;
	}
	public String getDescricao() {
		return descricao;
	}
	
	
	

}
