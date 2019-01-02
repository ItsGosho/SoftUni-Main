package itsgosho.services;

import itsgosho.constants.UserConstants;
import itsgosho.domain.models.dtos.UserRegisterDto;
import itsgosho.domain.entities.User;
import itsgosho.repositories.UserRepository;
import itsgosho.services.validations.UserRegisterDtoValidator;
import itsgosho.utils.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserServicesImp implements UserServices {

    private final UserRepository userRepository;
    private final UserRoleServices userRoleServices;
    private final UserRegisterDtoValidator userRegisterDtoValidator;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServicesImp(UserRepository userRepository,UserRoleServices userRoleServices, UserRegisterDtoValidator userRegisterDtoValidator, ValidationUtil validationUtil, ModelMapper modelMapper, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.userRoleServices = userRoleServices;
        this.userRegisterDtoValidator = userRegisterDtoValidator;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        if(this.isLoginByEmail(usernameOrEmail)){
            return this.userRepository.findUserByEmail(usernameOrEmail);
        }

        return this.userRepository.findUserByUsername(usernameOrEmail);
    }

    @Override
    public boolean register(UserRegisterDto userRegisterDto) {

        if (this.validationUtil.isValid(userRegisterDto) && this.userRegisterDtoValidator.isValid(userRegisterDto)) {
            User user = this.modelMapper.map(userRegisterDto, User.class);
            user.setPassword(this.bCryptPasswordEncoder.encode(userRegisterDto.getPassword()));

            this.userRoleServices.initialSetAuthorities(user);

            this.userRepository.save(user);
            return true;
        }

        return false;
    }

    private boolean isLoginByEmail(String email){
        Matcher matcher = Pattern.compile(UserConstants.EMAIL_PATTERN).matcher(email);

        return matcher.find();
    }
}
