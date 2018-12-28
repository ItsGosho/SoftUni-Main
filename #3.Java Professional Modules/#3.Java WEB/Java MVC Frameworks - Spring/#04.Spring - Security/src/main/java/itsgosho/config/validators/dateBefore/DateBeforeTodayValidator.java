package itsgosho.config.validators.dateBefore;

import itsgosho.config.validators.dateBefore.tools.DateBeforeUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class DateBeforeTodayValidator implements ConstraintValidator<DateBeforeToday, String> {

    private DateBeforeToday dateBeforeToday;

    @Override
    public void initialize(DateBeforeToday constraintAnnotation) {
           this.dateBeforeToday = constraintAnnotation;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(!DateBeforeUtils.isValid(value)){
            return false;
        }
        LocalDate localDate = LocalDate.now();
        LocalDate dateFromTheField =  DateBeforeUtils.parseDate(value);
        if(localDate.compareTo(dateFromTheField)>0){
            return true;
        }
        return false;
    }

}
