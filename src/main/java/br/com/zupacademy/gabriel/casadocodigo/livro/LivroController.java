package br.com.zupacademy.gabriel.casadocodigo.livro;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.gabriel.casadocodigo.autor.AutorRepository;
import br.com.zupacademy.gabriel.casadocodigo.categoria.CategoriaRepository;

@RestController
@RequestMapping("/livros")
public class LivroController {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private AutorRepository autorRepository;
	@Autowired
	private LivroRepository livroRepository;
	
	@PostMapping
	public ResponseEntity<LivroResponse> criarLivro (@RequestBody @Valid LivroRequest livroRequest) {
		Livro livro = livroRequest.toModel(categoriaRepository, autorRepository);
		livro = livroRepository.save(livro);
		
		return ResponseEntity.ok(new LivroResponse(livro));
	}
}
