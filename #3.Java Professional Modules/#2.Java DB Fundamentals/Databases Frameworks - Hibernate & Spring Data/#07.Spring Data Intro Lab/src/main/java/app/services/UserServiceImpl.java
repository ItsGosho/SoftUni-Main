package app.services;

import app.models.User;
import app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public void registerUser(User user) {
          if(this.userRepository.getByUsername(user.getUsername()) ==null){
              this.userRepository.save(user);
          }else{
              throw new IllegalArgumentException("There is already user with that username!");
          }
    }
}
