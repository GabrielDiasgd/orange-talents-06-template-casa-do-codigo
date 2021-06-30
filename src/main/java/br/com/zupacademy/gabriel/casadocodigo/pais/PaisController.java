package br.com.zupacademy.gabriel.casadocodigo.pais;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paises")
public class PaisController {
	
	@Autowired
	private PaisRepository paisRepository;
	
	@PostMapping
	public ResponseEntity<PaisResponse> criar (@RequestBody @Valid PaisRequest paisRequest) {
		Pais pais = paisRequest.toModel();
		pais = paisRepository.save(pais);
		return ResponseEntity.ok(new PaisResponse(pais));
	}

}
