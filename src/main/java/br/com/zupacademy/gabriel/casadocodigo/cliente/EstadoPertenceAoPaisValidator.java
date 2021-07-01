package br.com.zupacademy.gabriel.casadocodigo.cliente;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zupacademy.gabriel.casadocodigo.estado.Estado;
import br.com.zupacademy.gabriel.casadocodigo.estado.EstadoRepository;
import br.com.zupacademy.gabriel.casadocodigo.pais.Pais;
import br.com.zupacademy.gabriel.casadocodigo.pais.PaisRepository;

@Component
public class EstadoPertenceAoPaisValidator implements Validator {

	@Autowired
	private PaisRepository paisRepository;
	@Autowired
	private EstadoRepository estadoRepository;

	@Override
	public boolean supports(Class<?> clazz) {
		return ClienteRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}
		
		ClienteRequest request = (ClienteRequest) target;
		Optional<Pais> pais = paisRepository.findById(request.getIdPais());
		
		if (request.temEstado()) {
			Optional<Estado> estado = estadoRepository.findById(request.getIdEstado());
			if (!estado.get().pertenceAoPais(pais.get())) {
			errors.rejectValue("idEstado", null, "Este estado não pertence ao país informado");
		}
	} else  {
		if (!pais.get().getEstados().isEmpty()) {
			errors.rejectValue("idEstado", null, "Para o país informado é necessário informar um estado");
		}
	}
		
	}

}
