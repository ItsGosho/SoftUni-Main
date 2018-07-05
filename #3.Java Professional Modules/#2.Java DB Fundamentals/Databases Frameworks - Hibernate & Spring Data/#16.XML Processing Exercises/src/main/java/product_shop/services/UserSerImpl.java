package product_shop.services;

import product_shop.models.User;
import product_shop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSerImpl implements UserServices {
    private UserRepository userRepository;

    @Autowired
    public UserSerImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public void saveUser(User user) {
        this.userRepository.save(user);
    }

    @Override
    public User findUserById(int id) {
        return this.userRepository.findUserById(id);
    }
}
