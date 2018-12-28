package itsgosho.config.validators.dateBefore;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

///*
// @Author ItsGosho
// @Usage
// -> If the field date is before the provided date the the validator will pass
// -> NOTE: The FORMAT of the field must be:
// ->                      *! YEAR-MONTH-DAY !*
// ->                      Example: 2000-07-16
// */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DateBeforeTodayValidator.class)
public @interface DateBeforeToday {

    String message() default "";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
