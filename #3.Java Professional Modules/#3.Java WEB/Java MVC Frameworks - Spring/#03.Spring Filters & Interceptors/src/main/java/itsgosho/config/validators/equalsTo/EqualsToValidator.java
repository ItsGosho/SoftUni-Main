package itsgosho.config.validators.equalsTo;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

public class EqualsToValidator implements ConstraintValidator<EqualsTo, String> {

    private EqualsTo equalsTo;

    //Annotation value => equalsTo.value()
    //Field value => value

    @Override
    public void initialize(EqualsTo constraintAnnotation) {
        this.equalsTo = constraintAnnotation;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        List<String> values = Arrays.asList(equalsTo.values());

        if(!equalsTo.value().equals("")){
            if(equalsTo.value().equals(value)){
                return true;
            }
        }
        if(!values.isEmpty()){
            if(values.contains(value)){
                return true;
            }
        }
        return false;
    }
}
