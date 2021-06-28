package br.com.zupacademy.gabriel.casadocodigo.categoria;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ProibeNomeDuplicadoCategoriaValidator implements Validator {
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	@Override
	public boolean supports(Class<?> clazz) {
		return CategoriaRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}
		
		CategoriaRequest categoriaRequest = (CategoriaRequest) target;
		Optional<Categoria> nomeCadastrado = categoriaRepository.findByNome(categoriaRequest.getNome());
		
		if (nomeCadastrado.isPresent()) {
			errors.rejectValue("nome",null, "Já existe uma categoria cadastrada com o nome " + categoriaRequest.getNome());
		}
		
	}

}
