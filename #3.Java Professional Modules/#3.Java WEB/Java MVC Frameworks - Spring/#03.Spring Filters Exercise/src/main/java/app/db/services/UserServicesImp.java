package app.db.services;

import app.db.dtos.UserRegisterDto;
import app.db.models.User;
import app.db.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServicesImp implements UserServices{

    @Autowired
    private UserRepository userRepository;

    @Override
    public void create(UserRegisterDto userRegisterDto) {
        ModelMapper modelMapper = new ModelMapper();
        User user = modelMapper.map(userRegisterDto,User.class);
        user.setRole("USER");
        this.userRepository.save(user);
    }
}
