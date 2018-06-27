package t02_user_system.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import t02_user_system.models.User;
import t02_user_system.repositories.UserRepository;
import t02_user_system.services.interfaces.UserSer;

import java.util.Date;
import java.util.List;

@Service
@Primary
public class UserSerImp implements UserSer {
    private UserRepository userRepository;

    @Autowired
    public UserSerImp(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public void saveUser(User user) {
        this.userRepository.save(user);
    }

    @Override
    public List<User> findUsersByEmailEquals(String email) {
       return this.userRepository.findUsersByEmailEquals(email);
    }

    @Override
    public void setDeleteForInnactiveUsersAfterDate(Date date){
        List<User> users= (List<User>) this.userRepository.findAll();
        int countOfDelete=0;
        for (User user : users) {
            if(user.getLastTimeLoggedIn().compareTo(date)>0){
                this.userRepository.delete(user);
                countOfDelete++;
            }
        }
        System.out.println(countOfDelete+" users have been deleted");
    }

}
