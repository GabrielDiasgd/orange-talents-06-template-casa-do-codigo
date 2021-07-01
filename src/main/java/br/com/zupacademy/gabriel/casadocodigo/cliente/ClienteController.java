package br.com.zupacademy.gabriel.casadocodigo.cliente;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.gabriel.casadocodigo.estado.EstadoRepository;
import br.com.zupacademy.gabriel.casadocodigo.pais.PaisRepository;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private PaisRepository paisRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private EstadoPertenceAoPaisValidator estadoPertenceAoPais;
	
	@InitBinder
	public void init (WebDataBinder binder) {
		binder.addValidators(estadoPertenceAoPais);
	}
	
	@PostMapping
	public ResponseEntity<ClienteResponse> criar (@RequestBody @Valid ClienteRequest clienteRequest) {
		Cliente cliente = clienteRequest.toModel(paisRepository, estadoRepository);
		cliente = clienteRepository.save(cliente);
		
		return ResponseEntity.ok(new ClienteResponse(cliente));
	}

}
