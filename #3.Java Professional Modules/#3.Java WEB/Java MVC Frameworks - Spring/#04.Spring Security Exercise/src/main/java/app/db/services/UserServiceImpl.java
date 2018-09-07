package app.db.services;

import app.db.dtos.UserRegisterDto;
import app.db.models.User;
import app.db.models.UserRole;
import app.db.repositories.UserRepository;
import app.db.repositories.UserRoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ModelMapper modelMapper;
    private final UserRoleRepository userRoleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, BCryptPasswordEncoder bCryptPasswordEncoder, UserRoleRepository userRoleRepository) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public boolean createUser(UserRegisterDto userRegisterDto) {
        User user = this.modelMapper.map(userRegisterDto, User.class);
        if (userRegisterDto.getPassword().equals(userRegisterDto.getConfirmPassword())) {
            user.setPassword(this.bCryptPasswordEncoder.encode(userRegisterDto.getPassword()));
            user.setAuthorities(new LinkedHashSet<>());
            if(this.userRoleRepository.count()==0){
                this.userRoleRepository.save(new UserRole("Admin"));
            }
            if(this.userRoleRepository.findUserRoleByAuthority("User")==null){
                this.userRoleRepository.save(new UserRole("User"));
            }
            user.getAuthorities().add(this.userRoleRepository.findUserRoleByAuthority("User"));
        }

        return this.userRepository.save(user)!=null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails foundUser =  this.userRepository
                .findUserByUsername(username);

        if (foundUser == null) {
            throw new UsernameNotFoundException("Username not found.");
        }

        return foundUser;
    }
}
