package itsgosho.domain.services;

import itsgosho.domain.dtos.user.UserLoginDto;
import itsgosho.domain.dtos.user.UserRegisterDto;
import itsgosho.domain.entities.User;

import javax.servlet.http.HttpSession;
import java.util.Map;

public interface UserServices {

    User findUserByUsername(String username);
    User findUserByEmail(String email);

    boolean registerUser(UserRegisterDto userRegisterDto);

    boolean loginUser(UserLoginDto userLoginDto, HttpSession httpSession);

    String determinateIfExistsForJSON(String username, String email);

    String determinateIfLoginValidForJSON(String username, String password);

    void logout(HttpSession httpSession);
}
