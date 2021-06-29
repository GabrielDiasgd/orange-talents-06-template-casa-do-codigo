package br.com.zupacademy.gabriel.casadocodigo.livro;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import br.com.zupacademy.gabriel.casadocodigo.autor.Autor;
import br.com.zupacademy.gabriel.casadocodigo.autor.AutorRepository;
import br.com.zupacademy.gabriel.casadocodigo.categoria.Categoria;
import br.com.zupacademy.gabriel.casadocodigo.categoria.CategoriaRepository;
import br.com.zupacademy.gabriel.casadocodigo.config.validation.ExistsId;
import br.com.zupacademy.gabriel.casadocodigo.config.validation.UniqueValue;

public class LivroRequest {
	
	@NotBlank
	@UniqueValue(domainClass = Livro.class, fieldName = "titulo")
	private String titulo;
	@NotBlank
	@Length(max = 500)
	private String resumo;
	@NotBlank
	private String sumario;
	@NotNull
	@Min(20)
	private BigDecimal preco;
	@NotNull
	@Min(100)
	private Integer numeroPaginas;
	@NotBlank
	@UniqueValue(domainClass = Livro.class, fieldName = "isbn")
	private String isbn;
	@Future
	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	private LocalDate dataPublicacao;
	@NotNull
	@ExistsId(domainClass = Categoria.class, fieldName = "id")
	private Long idCategoria;
	@NotNull
	@ExistsId(domainClass = Autor.class, fieldName = "id")
	private Long idAutor;
	
	public LivroRequest(@NotBlank String titulo, @NotBlank @Length(max = 500) String resumo, @NotBlank String sumario,
			@NotNull @Min(20) BigDecimal preco, @NotNull @Min(100) Integer numeroPaginas, @NotBlank String isbn,
			 @Future @JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)LocalDate dataPublicacao, @NotNull Long idCategoria, @NotNull Long idAutor) {
		super();
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numeroPaginas = numeroPaginas;
		this.isbn = isbn;
		this.dataPublicacao = dataPublicacao;
		this.idCategoria = idCategoria;
		this.idAutor = idAutor;
	}

	/*
	 * Esse setter foi criado pois o jackson não consegue desserializar a data no construtor
	 * por algum motivo e esse foi o jeito que consegui fazer funcionar
	 */
	public void setDataPublicacao(LocalDate dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public Livro toModel(CategoriaRepository categoriaRepository, AutorRepository autorRepository) {
	    @NotNull Optional<Categoria> categoria = categoriaRepository.findById(this.idCategoria);
		@NotNull Optional<Autor> autor = autorRepository.findById(this.idAutor);
		
		
		return new Livro(this.titulo, this.resumo, this.sumario, this.preco, this.numeroPaginas, this.isbn, this.dataPublicacao, categoria.get(), autor.get());
	}
	
	
	

}
