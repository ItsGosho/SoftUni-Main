package itsgosho.domain.services;

import itsgosho.domain.dtos.user.UserRegisterDto;
import itsgosho.domain.entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import java.security.Principal;
import java.util.List;

public interface UserServices extends UserDetailsService {

    User findById(String id);

    User findUserByEmail(String email);

    boolean registerUser(UserRegisterDto userRegisterDto);

    String determinateIfExistsForJSON(String username, String email);

    String determinateIfLoginValidForJSON(String username, String password);

    List<User> findAll();

    boolean deleteUser(Principal principal,String id);

    boolean promoteUser(Principal principal, String id);

    boolean demoteUser(Principal principal, String id);
}
