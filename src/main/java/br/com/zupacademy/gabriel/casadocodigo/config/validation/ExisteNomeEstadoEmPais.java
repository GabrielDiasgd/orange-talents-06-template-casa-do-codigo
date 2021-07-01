package br.com.zupacademy.gabriel.casadocodigo.config.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = {ExisteNomeEstadoEmPaisValidator.class})
@Target(ElementType.TYPE_USE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExisteNomeEstadoEmPais {
	
	String message() default "Já existe estado com esse nome no país escolhido";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };

	
	

}
