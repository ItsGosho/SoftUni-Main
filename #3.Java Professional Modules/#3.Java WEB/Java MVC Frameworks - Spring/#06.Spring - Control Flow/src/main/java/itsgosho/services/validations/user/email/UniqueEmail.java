package itsgosho.services.validations.user.email;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

///*
// @Author ItsGosho
// @Usage
// -> The provided email must not exists in the database
// -> NOTE: The email column must be UNIQUE!
// */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueEmailConstraint.class)
public @interface UniqueEmail {

    String message() default "The username already exists!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
