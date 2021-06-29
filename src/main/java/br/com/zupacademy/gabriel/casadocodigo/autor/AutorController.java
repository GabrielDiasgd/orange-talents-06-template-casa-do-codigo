package br.com.zupacademy.gabriel.casadocodigo.autor;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autores")
public class AutorController {
	
	@Autowired
	private AutorRepository autorRepository;
	
	@PostMapping
	@Transactional
	public ResponseEntity<AutorResponse> criarAutor (@RequestBody  @Valid AutorRequest autorRequest) {
		Autor autor = autorRequest.toModel();
		autorRepository.save(autor);
		return ResponseEntity.ok(new AutorResponse(autor));
	}

}
