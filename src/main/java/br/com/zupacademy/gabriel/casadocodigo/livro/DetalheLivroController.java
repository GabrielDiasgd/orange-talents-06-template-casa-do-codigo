package br.com.zupacademy.gabriel.casadocodigo.livro;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produtos")
public class DetalheLivroController {

	@Autowired
	private LivroRepository livroRepository;

	@GetMapping("/{id}")
	public ResponseEntity<DetalheLivroResponse> listarDetalhes(@PathVariable Long id) {
		Optional<Livro> livro = livroRepository.findById(id);
		if (livro.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(new DetalheLivroResponse(livro.get()));
		}
		
	}

}
