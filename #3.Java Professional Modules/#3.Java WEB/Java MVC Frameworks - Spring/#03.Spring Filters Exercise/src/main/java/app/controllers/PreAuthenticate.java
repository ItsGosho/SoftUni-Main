package app.controllers;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PreAuthenticate {

    boolean loggedIn() default false;
    String inRole() default "GUEST";
}
