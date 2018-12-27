package itsgosho.domain.services;

import itsgosho.domain.dtos.UserCreateDto;
import itsgosho.domain.dtos.UserLoginDto;
import itsgosho.domain.entities.User;
import itsgosho.domain.parsers.ValidationUtil;
import itsgosho.domain.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Service
public class UserServicesImp implements UserServices {

    private final UserRepository userRepository;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    @Autowired
    public UserServicesImp(UserRepository userRepository, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public User findUserByEmail(String email) {
        return this.userRepository.findUserByEmail(email);
    }

    @Override
    public User findUserByUsername(String username) {
        return this.userRepository.findUserByUsername(username);
    }

    @Override
    public boolean addUser(UserCreateDto userCreateDto) {
        if(this.validationUtil.isValid(userCreateDto)){
            User user = this.modelMapper.map(userCreateDto,User.class);
            this.userRepository.save(user);
            return true;
        }
        return false;
    }

    @Override
    public boolean loginUser(UserLoginDto userLoginDto, HttpSession httpSession) {
        if(this.validationUtil.isValid(userLoginDto)){
            User user = this.findUserByUsername(userLoginDto.getUsername());
            if(user!=null && user.getPassword().equals(userLoginDto.getPassword())){
                httpSession.setAttribute("username",user.getUsername());
                return true;
            }
            return false;
        }
        return false;
    }
}
