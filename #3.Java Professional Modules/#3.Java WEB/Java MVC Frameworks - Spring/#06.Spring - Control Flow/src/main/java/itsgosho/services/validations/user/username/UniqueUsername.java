package itsgosho.services.validations.user.username;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

///*
// @Author ItsGosho
// @Usage
// -> The provided username must not exists in the database
// -> NOTE: The username column must be UNIQUE!
// */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueUsernameConstraint.class)
public @interface UniqueUsername {

    String message() default "The username already exists!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
