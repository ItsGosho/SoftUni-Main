package itsgosho.services.validations.user.ucn;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

///*
// @Author ItsGosho
// @Usage
// -> The provided ucn must not exists in the database
// -> NOTE: The ucn column must be UNIQUE!
// */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueUCNConstraint.class)
public @interface UniqueUCN {

    String message() default "The ucn already exists!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
