package itsgosho.domain.validators;

import itsgosho.domain.dtos.user.UserRegisterDto;
import itsgosho.domain.repositories.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class UserRegisterDtoValidator {

    private final UserRepository userRepository;

    public UserRegisterDtoValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean isValid(UserRegisterDto userRegisterDto) {

        if(this.userRepository.findUserByUsername(userRegisterDto.getUsername())!=null){
            return false;
        }

        if(this.userRepository.findUserByEmail(userRegisterDto.getEmail())!=null){
            return false;
        }

        if(!userRegisterDto.getPassword().equals(userRegisterDto.getConfirmPassword())){
            return false;
        }

        return true;
    }
}
