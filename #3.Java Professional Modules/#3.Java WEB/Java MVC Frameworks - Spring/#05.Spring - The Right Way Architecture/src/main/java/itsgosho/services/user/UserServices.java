package itsgosho.services.user;

import itsgosho.domain.entities.User;
import itsgosho.domain.models.dtos.UserRegisterDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Set;

public interface UserServices extends UserDetailsService {

    boolean register(UserRegisterDto userRegisterDto);

    List<User> findAll();
}
