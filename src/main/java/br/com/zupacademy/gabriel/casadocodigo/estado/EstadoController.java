package br.com.zupacademy.gabriel.casadocodigo.estado;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.gabriel.casadocodigo.pais.PaisRepository;

@RestController
@RequestMapping("/estados")
public class EstadoController {
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private PaisRepository paisRepository;
	
	@PostMapping
	public ResponseEntity<?> criar (@RequestBody @Valid EstadoRequest estadoRequest) {
		Estado estado = estadoRequest.toModel(paisRepository);
		estado = estadoRepository.save(estado);
		return ResponseEntity.ok(new EstadoResponse(estado));
	}

}
