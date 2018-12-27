package itsgosho.domain.services;

import itsgosho.domain.dtos.UserCreateDto;
import itsgosho.domain.dtos.UserLoginDto;
import itsgosho.domain.entities.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public interface UserServices {

    User findUserByEmail(String email);
    User findUserByUsername(String username);
    boolean addUser(UserCreateDto userCreateDto);

    boolean loginUser(UserLoginDto userLoginDto, HttpSession httpSession);
}
