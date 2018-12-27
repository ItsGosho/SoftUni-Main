package itsgosho.domain.services;

import itsgosho.config.LoggingService;
import itsgosho.config.validators.ValidationUtil;
import itsgosho.domain.dtos.user.UserLoginDto;
import itsgosho.domain.dtos.user.UserRegisterDto;
import itsgosho.domain.entities.User;
import itsgosho.domain.enumarations.UserRole;
import itsgosho.domain.repositories.UserRepository;
import itsgosho.domain.validators.UserLoginDtoValidator;
import itsgosho.domain.validators.UserRegisterDtoValidator;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class UserServicesImp implements UserServices {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final UserRegisterDtoValidator userRegisterDtoValidator;
    private final UserLoginDtoValidator userLoginDtoValidator;

    public UserServicesImp(UserRepository userRepository, ModelMapper modelMapper, ValidationUtil validationUtil, UserRegisterDtoValidator userRegisterDtoValidator, UserLoginDtoValidator userLoginDtoValidator) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.userRegisterDtoValidator = userRegisterDtoValidator;
        this.userLoginDtoValidator = userLoginDtoValidator;
    }

    private boolean saveUser(User user){
        try{
            this.userRepository.save(user);
        }catch (Exception ex){
            LoggingService.error("The entity of type `User` wansn't saved: " + ex.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public User findUserByUsername(String username) {
        return this.userRepository.findUserByUsername(username);
    }

    @Override
    public User findUserByEmail(String email) {
        return this.userRepository.findUserByEmail(email);
    }

    @Override
    public boolean registerUser(UserRegisterDto userRegisterDto) {
        if(this.validationUtil.isValid(userRegisterDto) && this.userRegisterDtoValidator.isValid(userRegisterDto)){
            User user = this.modelMapper.map(userRegisterDto,User.class);
            user.setUserRole(UserRole.USER);
            this.userRepository.save(user);
            LoggingService.info("A user has been registered successful with username: " + user.getUsername());
            return true;
        }
        return false;
    }

    @Override
    public boolean loginUser(UserLoginDto userLoginDto, HttpSession httpSession) {
        if(this.validationUtil.isValid(userLoginDto) && this.userLoginDtoValidator.isValid(userLoginDto)){
            User user = this.userRepository.findUserByUsername(userLoginDto.getUsername());
            return this.loginUser(user,httpSession);
        }
        return false;
    }

    private boolean loginUser(User user,HttpSession httpSession) {
        if(httpSession.getAttribute("user")==null){
            httpSession.setAttribute("user",user);
            return true;
        }
        return false;
    }

    @Override
    public String determinateIfExistsForJSON(String username, String email) {
        boolean result = false;
        if(username!=null){
            result = this.findUserByUsername(username)!=null;
        }else if(email!=null){
            result = this.findUserByEmail(email)!=null;
        }
        return String.format("{ \"exists\": %b }",result);
    }

    @Override
    public String determinateIfLoginValidForJSON(String username, String password) {
        boolean result = false;
        UserLoginDto userLoginDto = new UserLoginDto();
        userLoginDto.setUsername(username);
        userLoginDto.setPassword(password);
        result = this.userLoginDtoValidator.isValid(userLoginDto);
        return String.format("{ \"valid\": %b }",result);
    }

    @Override
    public void logout(HttpSession httpSession) {
        httpSession.invalidate();
    }
}
