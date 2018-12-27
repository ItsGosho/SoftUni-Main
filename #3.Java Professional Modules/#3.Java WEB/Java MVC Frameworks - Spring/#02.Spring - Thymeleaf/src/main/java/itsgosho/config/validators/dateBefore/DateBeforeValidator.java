package itsgosho.config.validators.dateBefore;

import itsgosho.config.validators.dateBefore.tools.DateBeforeUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class DateBeforeValidator implements ConstraintValidator<DateBefore, String> {

    private static String INVALID_FORMAT_ERROR_MESSAGE = "The value of the field isn't in the valid date format,please look at the annotation comment for the needed format!";
    private DateBefore dateBefore;

    //Annotation value => equalsTo.value()
    //Field value => value

    @Override
    public void initialize(DateBefore constraintAnnotation) {
        this.dateBefore = constraintAnnotation;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
       if(!DateBeforeUtils.isValid(value)){
           return false;
       }
        LocalDate dateFromAnnotation = LocalDate.of(dateBefore.year(),dateBefore.month(),dateBefore.day());
        LocalDate dateFromTheField = DateBeforeUtils.parseDate(value);
        if(dateFromAnnotation.compareTo(dateFromTheField)>0){
            return true;
        }
        return false;
    }
}
