package br.com.zupacademy.gabriel.casadocodigo.livro;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;

import br.com.zupacademy.gabriel.casadocodigo.autor.DetalheAutorResponse;

public class DetalheLivroResponse {

	private String titulo;
	private String resumo;
	private String sumario;
	private BigDecimal preco;
	private Integer numeroPaginas;
	private String isbn;
	private String dataPublicacao;
	private DetalheAutorResponse autor;
	
	public DetalheLivroResponse(Livro livro) {
		this.titulo = livro.getTitulo();
		this.resumo = livro.getResumo();
		this.sumario = livro.getSumario();
		this.preco = livro.getPreco();
		this.numeroPaginas = livro.getNumeroPaginas();
		this.isbn = livro.getIsbn();		
		this.autor = new DetalheAutorResponse(livro.getAutor());
		this.dataPublicacao = livro.getDataPublicacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}

	public String getTitulo() {
		return titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public DetalheAutorResponse getAutor() {
		return autor;
	}

	public String getDataPublicacao() {
		return dataPublicacao;
	}
	
	
	
	

}
