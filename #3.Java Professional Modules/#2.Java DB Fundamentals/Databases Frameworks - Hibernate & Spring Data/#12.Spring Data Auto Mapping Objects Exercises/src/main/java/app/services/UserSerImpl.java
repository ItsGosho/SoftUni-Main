package app.services;

import app.entities.User;
import app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSerImpl implements UserServices{
    private UserRepository userRepository;

    @Autowired
    public UserSerImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public void saveUser(User user) {
        this.userRepository.save(user);
    }

    @Override
    public User findUserByEmailEquals(String email) {
        return this.userRepository.findUserByEmailEquals(email);
    }
}
