package br.com.zupacademy.gabriel.casadocodigo.livro;

public class LivroResponseResumo {

	private Long id;
	private String nome;

	public LivroResponseResumo(Livro livro) {
		this.id = livro.getId();
		this.nome = livro.getTitulo();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

}
