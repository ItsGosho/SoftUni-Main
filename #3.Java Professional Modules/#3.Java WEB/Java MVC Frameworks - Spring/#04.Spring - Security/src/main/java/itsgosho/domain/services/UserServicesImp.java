package itsgosho.domain.services;

import itsgosho.config.LoggingService;
import itsgosho.config.validators.ValidationUtil;
import itsgosho.domain.dtos.user.UserLoginDto;
import itsgosho.domain.dtos.user.UserRegisterDto;
import itsgosho.domain.entities.User;
import itsgosho.domain.entities.UserRole;
import itsgosho.domain.enumarations.UserRoles;
import itsgosho.domain.repositories.UserRepository;
import itsgosho.domain.utils.UserRoleUtil;
import itsgosho.domain.validators.UserLoginDtoValidator;
import itsgosho.domain.validators.UserRegisterDtoValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServicesImp implements UserServices {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final UserRegisterDtoValidator userRegisterDtoValidator;
    private final UserLoginDtoValidator userLoginDtoValidator;
    private final BCryptPasswordEncoder passwordEncoder;
    private final UserRoleUtil userRoleUtil;

    public UserServicesImp(UserRepository userRepository, ModelMapper modelMapper, ValidationUtil validationUtil, UserRegisterDtoValidator userRegisterDtoValidator, UserLoginDtoValidator userLoginDtoValidator, BCryptPasswordEncoder passwordEncoder, UserRoleUtil userRoleUtil) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.userRegisterDtoValidator = userRegisterDtoValidator;
        this.userLoginDtoValidator = userLoginDtoValidator;
        this.passwordEncoder = passwordEncoder;
        this.userRoleUtil = userRoleUtil;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.userRepository.findUserByUsername(username);
    }

    @Override
    public User findById(String id) {
        return this.userRepository.findById(id).orElse(null);
    }

    @Override
    public User findUserByEmail(String email) {
        return this.userRepository.findUserByEmail(email);
    }

    @Override
    public boolean registerUser(UserRegisterDto userRegisterDto) {
        if(this.validationUtil.isValid(userRegisterDto) && this.userRegisterDtoValidator.isValid(userRegisterDto)){
            User user = this.modelMapper.map(userRegisterDto,User.class);
            user.setPassword(this.passwordEncoder.encode(userRegisterDto.getPassword()));
            user.setRegistrationDate(LocalDateTime.now());
            Set<UserRole> userRoles = new HashSet<>();

            if(this.userRepository.findAll().size()==0){
                userRoles.add(this.userRoleUtil.bakeRole(UserRoles.ROOT_ADMIN));
                userRoles.add(this.userRoleUtil.bakeRole(UserRoles.ADMIN));
                userRoles.add(this.userRoleUtil.bakeRole(UserRoles.MODERATOR));
                userRoles.add(this.userRoleUtil.bakeRole(UserRoles.USER));
            }else{
                userRoles.add(this.userRoleUtil.bakeRole(UserRoles.USER));
            }

            user.setAuthorities(userRoles);


            this.userRepository.saveAndFlush(user);
            LoggingService.info("A user has been registered successful with username: " + user.getUsername());
            return true;
        }
        return false;
    }


    @Override
    public String determinateIfExistsForJSON(String username, String email) {
        boolean result = false;
        if(username!=null){
            result = this.loadUserByUsername(username)!=null;
        }else if(email!=null){
            result = this.findUserByEmail(email)!=null;
        }
        return String.format("{ \"exists\": %b }",result);
    }

    @Override
    public String determinateIfLoginValidForJSON(String username, String password) {
        boolean result = false;
        User user = this.userRepository.findUserByUsername(username);
        if(user!=null){
            result = this.passwordEncoder.matches(password,user.getPassword());
        }
        return String.format("{ \"valid\": %b }",result);
    }

    @Override
    public List<User> findAll() {
        return this.userRepository.findAll()
                .stream()
                .sorted((x1,x2)-> Integer.compare(UserRoles.valueOf(x2.getRole()).ordinal(),UserRoles.valueOf(x1.getRole()).ordinal()))
                .collect(Collectors.toList());
    }

    @Override
    public boolean deleteUser(Principal principal, String id) {
        User user = this.userRepository.findUserByUsername(principal.getName());
        User userToBeDeleted = this.userRepository.findById(id).orElse(null);

        if(!this.validateRankOperation(user,userToBeDeleted)){
            return false;
        }

        this.userRepository.delete(userToBeDeleted);
        LoggingService.warning(String.format("User has been deleted with username: %s and role: %s by %s with role: %s",
                userToBeDeleted.getUsername(),userToBeDeleted.getRole(),
                user.getUsername(),user.getRole()));

        return true;
    }

    @Override
    public boolean promoteUser(Principal principal, String id) {
        User user = this.userRepository.findUserByUsername(principal.getName());
        User userToBePromoted = this.userRepository.findById(id).orElse(null);

        if(!this.validateRankOperation(user,userToBePromoted)){
            return false;
        }

        userToBePromoted.addAuthority(this.userRoleUtil.getRole(userToBePromoted.getNextRole()));
        this.userRepository.saveAndFlush(userToBePromoted);
        LoggingService.warning(String.format("User has been promoted with username: %s to role: %s by %s with role: %s",
                userToBePromoted.getUsername(),userToBePromoted.getRole(),
                user.getUsername(),user.getRole()));
        return true;
    }

    @Override
    public boolean demoteUser(Principal principal, String id) {
        User user = this.userRepository.findUserByUsername(principal.getName());
        User userToBeDemoted = this.userRepository.findById(id).orElse(null);
        String olderRole = userToBeDemoted.getRole();

        if(!this.validateRankOperation(user,userToBeDemoted)
                || userToBeDemoted.getRole().equals(UserRoles.USER.name())){
            return false;
        }

        userToBeDemoted.getAuthorities().removeIf(x->((GrantedAuthority) x).getAuthority().equals(olderRole));
        this.userRepository.saveAndFlush(userToBeDemoted);
        LoggingService.warning(String.format("User has been demoted with username: %s from role %s to role: %s by %s with role: %s",
                userToBeDemoted.getUsername(),olderRole,userToBeDemoted.getRole(),
                user.getUsername(),user.getRole()));
        return true;
    }

    private boolean validateRankOperation(User user,User userToBeProceeded){


        if(user.getUsername().equals(userToBeProceeded.getUsername())){
            return false;
        }

        if(userToBeProceeded.getRole().equals(UserRoles.ROOT_ADMIN.name())){
            return false;
        }

        if(user.getRole().equals(userToBeProceeded.getRole())){
            return false;
        }

        if(UserRoles.valueOf(user.getRole()).ordinal()<UserRoles.valueOf(userToBeProceeded.getRole()).ordinal()){
            return false;
        }
        return true;
    }
}
