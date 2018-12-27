package itsgosho.domain.validators;

import itsgosho.domain.dtos.user.UserLoginDto;
import itsgosho.domain.entities.User;
import itsgosho.domain.repositories.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class UserLoginDtoValidator {

    private final UserRepository userRepository;

    public UserLoginDtoValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean isValid(UserLoginDto userLoginDto) {
        if(userLoginDto==null){
            return false;
        }

        if(userLoginDto.getUsername()==null || userLoginDto.getUsername().isEmpty()){
            return false;
        }

        if(userLoginDto.getPassword()==null || userLoginDto.getPassword().isEmpty()){
            return false;
        }

        User user = this.userRepository.findUserByUsername(userLoginDto.getUsername());

        if (user == null) {
            return false;
        }
        if (!user.getPassword().equals(userLoginDto.getPassword())) {
            return false;
        }
        return true;
    }
}
