package br.com.zupacademy.gabriel.casadocodigo.config.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler {
	
	@Autowired
	MessageSource messageSource;
	
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
	public List<DescricaoDoErroResponse> handler(MethodArgumentNotValidException exception) {
		
		List<FieldError> fieldErros = exception.getBindingResult().getFieldErrors();
		List<DescricaoDoErroResponse> errorsResponse = new ArrayList<>();
		
		fieldErros.forEach(erro -> {
			String mensagem = messageSource.getMessage(erro, LocaleContextHolder.getLocale());
			DescricaoDoErroResponse  descricaoErro = new DescricaoDoErroResponse(erro.getField(), mensagem, LocalDateTime.now(), HttpStatus.BAD_REQUEST.toString());
			errorsResponse.add(descricaoErro);
		});
		
		return errorsResponse;
	}
	
}

