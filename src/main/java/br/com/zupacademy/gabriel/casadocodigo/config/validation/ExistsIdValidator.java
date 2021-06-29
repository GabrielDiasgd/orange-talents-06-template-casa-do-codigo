package br.com.zupacademy.gabriel.casadocodigo.config.validation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.Assert;

public class ExistsIdValidator implements ConstraintValidator<ExistsId, Object> {
	
	@PersistenceContext
	private EntityManager manager;
	
	private String domainAttribute;
	private Class<?> klass;


	@Override
	public void initialize(ExistsId constraintAnnotation) {
		domainAttribute = constraintAnnotation.fieldName();
		klass = constraintAnnotation.domainClass();
	}


	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		Query query = manager.createQuery("select 1 from " + klass.getName() + " where " + domainAttribute + "=:value");
		System.out.println(value);
		query.setParameter("value", value);
		List<?> list = query.getResultList();
		Assert.state(list.size() <= 1 , "Não existe um " + klass.getSimpleName() + " com o id " + value);
		
		return !list.isEmpty();
	}
}
