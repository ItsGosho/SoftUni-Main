package itsgosho.services.validations.user.username;


import itsgosho.repositories.UserRepository;
import itsgosho.services.user.UserServices;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

@Component
public class UniqueUsernameConstraint implements ConstraintValidator<UniqueUsername, String> {

    private final UserRepository userRepository;

    @Autowired
    public UniqueUsernameConstraint(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public void initialize(UniqueUsername constraintAnnotation) {
    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {

        if(this.userRepository.findUserByUsername(username)==null){
            return true;
        }

        return false;
    }

}
