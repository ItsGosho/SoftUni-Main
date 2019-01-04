package itsgosho.services.validations.user.email;


import itsgosho.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class UniqueEmailConstraint implements ConstraintValidator<UniqueEmail, String> {

    private final UserRepository userRepository;

    @Autowired
    public UniqueEmailConstraint(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public void initialize(UniqueEmail constraintAnnotation) {
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {

        if(this.userRepository.findUserByEmail(email)==null){
            return true;
        }

        return false;
    }

}
