package itsgosho.utils;

import org.springframework.stereotype.Component;

import javax.validation.Validation;
import javax.validation.Validator;

@Component
public final class ValidationUtil {

    private Validator validator;

    public ValidationUtil() {
        this.validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    public <E> boolean isValid(E entity) {
        return this.validator.validate(entity).size() == 0;
    }
}
