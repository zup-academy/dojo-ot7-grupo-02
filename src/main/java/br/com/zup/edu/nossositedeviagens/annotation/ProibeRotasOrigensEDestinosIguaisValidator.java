package br.com.zup.edu.nossositedeviagens.annotation;

import br.com.zup.edu.nossositedeviagens.model.dto.RoutDto;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ProibeRotasOrigensEDestinosIguaisValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return RoutDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
