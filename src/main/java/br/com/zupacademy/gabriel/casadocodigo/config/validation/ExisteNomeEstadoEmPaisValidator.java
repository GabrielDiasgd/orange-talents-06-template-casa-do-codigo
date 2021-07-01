package br.com.zupacademy.gabriel.casadocodigo.config.validation;

import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.zupacademy.gabriel.casadocodigo.estado.Estado;
import br.com.zupacademy.gabriel.casadocodigo.estado.EstadoRepository;
import br.com.zupacademy.gabriel.casadocodigo.estado.EstadoRequest;

public class ExisteNomeEstadoEmPaisValidator implements ConstraintValidator<ExisteNomeEstadoEmPais, Object>{
	
	@Autowired
	private EstadoRepository estadoRepository;

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		var estadoRequest = (EstadoRequest) value;
		Optional<Estado> existeEstado = estadoRepository.findByNomeAndPaisId(estadoRequest.getNome(), estadoRequest.getIdPais());
		return !existeEstado.isPresent();
	}

}
