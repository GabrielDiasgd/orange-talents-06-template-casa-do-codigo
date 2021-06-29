package br.com.zupacademy.gabriel.casadocodigo.livro;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
	@Transactional
	public ResponseEntity<LivroResponse> criarLivro (@RequestBody @Valid LivroRequest livroRequest) {
		Livro livro = livroRequest.toModel(categoriaRepository, autorRepository);
		livro = livroRepository.save(livro);
		
		return ResponseEntity.ok(new LivroResponse(livro));
	}
	
	@GetMapping
	public List<LivroResponseResumo> listar () {
		List<Livro> livros = livroRepository.findAll();
		List<LivroResponseResumo> list = livros.stream()
		.map(l -> new LivroResponseResumo(l))
		.collect(Collectors.toList());
		return list;
	}
}
