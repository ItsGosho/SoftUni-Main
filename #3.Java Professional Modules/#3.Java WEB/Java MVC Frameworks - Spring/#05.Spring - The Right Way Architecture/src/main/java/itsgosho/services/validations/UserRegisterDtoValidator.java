package itsgosho.services.validations;

import itsgosho.constants.UserConstants;
import itsgosho.domain.models.dtos.UserRegisterDto;
import itsgosho.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class UserRegisterDtoValidator {


    private final UserRepository userRepository;

    @Autowired
    public UserRegisterDtoValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean isValid(UserRegisterDto userRegisterDto) {

        if (!this.isUsernameAvaliable(userRegisterDto.getUsername())) {
            return false;
        }

        if (!this.isUsernameValid(userRegisterDto.getUsername())) {
            return false;
        }

        if (!this.isEmailAvaliable(userRegisterDto.getEmail())) {
            return false;
        }

        if (!this.isEmailValid(userRegisterDto.getEmail())) {
            return false;
        }

        if (!this.isPasswordValid(userRegisterDto.getPassword())) {
            return false;
        }

        if (!this.isUniqueCitizenNumberAvaliable(userRegisterDto.getUniqueCitizenNumber())) {
            return false;
        }

        if(!this.arePasswordsEqual(userRegisterDto.getPassword(),userRegisterDto.getConfirmPassword())){
            return false;
        }

        return true;
    }

    private boolean isUsernameAvaliable(String username) {
        return this.userRepository.findUserByUsername(username) == null;
    }

    private boolean isUsernameValid(String username){
        return username.length()>= UserConstants.USERNAME_MIN_LENGTH && username.length()<= UserConstants.USERNAME_MAX_LENGTH;
    }

    private boolean isEmailAvaliable(String email) {
        return this.userRepository.findUserByEmail(email) == null;
    }

    private boolean isEmailValid(String email) {
        Pattern pattern = Pattern.compile( UserConstants.EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.find();
    }

    private boolean isPasswordValid(String password) {
        Pattern pattern = Pattern.compile( UserConstants.PASSWORD_PATTERN);
        Matcher matcher = pattern.matcher(password);
        return matcher.find();
    }

    private boolean isUniqueCitizenNumberAvaliable(String uniqueCitizenNumber) {
        return this.userRepository.findUserByUniqueCitizenNumber(uniqueCitizenNumber) == null;
    }

    private boolean arePasswordsEqual(String password, String confirmPassword) {
        return password.equals(confirmPassword);
    }
}
