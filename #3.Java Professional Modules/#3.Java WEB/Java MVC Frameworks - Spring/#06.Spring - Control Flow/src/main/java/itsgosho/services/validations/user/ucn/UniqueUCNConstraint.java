package itsgosho.services.validations.user.ucn;


import itsgosho.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class UniqueUCNConstraint implements ConstraintValidator<UniqueUCN, String> {

    private final UserRepository userRepository;

    @Autowired
    public UniqueUCNConstraint(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public void initialize(UniqueUCN constraintAnnotation) {
    }

    @Override
    public boolean isValid(String ucn, ConstraintValidatorContext context) {

        if(this.userRepository.findUserByUniqueCitizenNumber(ucn)==null){
            return true;
        }

        return false;
    }

}
