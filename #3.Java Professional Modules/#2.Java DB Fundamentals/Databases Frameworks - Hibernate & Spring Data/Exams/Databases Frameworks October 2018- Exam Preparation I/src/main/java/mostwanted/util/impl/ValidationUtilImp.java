package mostwanted.util.impl;

import mostwanted.util.inter.ValidationUtil;
import org.springframework.stereotype.Component;

import javax.validation.Validation;
import javax.validation.Validator;

public class ValidationUtilImp implements ValidationUtil {


    private Validator validator;

    public ValidationUtilImp() {
        this.validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Override
    public <E> boolean isValid(E entity) {
        return this.validator.validate(entity).size() == 0;
    }
}
