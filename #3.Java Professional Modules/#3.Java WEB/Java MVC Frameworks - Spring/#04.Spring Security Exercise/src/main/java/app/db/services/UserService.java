package app.db.services;

import app.db.dtos.UserRegisterDto;
import app.db.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Set;

public interface UserService extends UserDetailsService {
    boolean createUser(UserRegisterDto userRegisterDto);
}
