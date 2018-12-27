package itsgosho.config.validators.equalsTo;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

///*
// @Author ItsGosho
// @Usage
// -> If value is used then if the field value is equal to the given value in the annotation ,the validator will pass
// -> If values is used then if the field value is AT LEAST ONE TIME CONTAINED in the values ,the validator will pass
// */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EqualsToValidator.class)
public @interface EqualsTo {

    String value() default "";
    String[] values() default {};
    String message() default "";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
