package app.controllers;

import app.db.dtos.UserLoginDto;
import app.db.dtos.UserRegisterDto;
import app.db.models.User;
import app.db.repositories.UserRepository;
import app.db.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class AuthenticationController extends BaseController{

    @Autowired
    private UserServices userServices;
    @Autowired
    private UserRepository userRepository;

    @PreAuthenticate(loggedIn = false)
    @GetMapping("/login")
    public String loginGet(){
        return "authentication/login";
    }

    @PostMapping("/login")
    public String loginPOST(UserLoginDto userLoginDto,HttpSession httpSession){
        User user = this.userRepository.findUserByUsername(userLoginDto.getUsername());
        if(user!=null && user.getPassword().equals(userLoginDto.getPassword())){
            httpSession.setAttribute("username",user.getUsername());
            httpSession.setAttribute("email",user.getEmail());
            return "redirect:/homepage";
        }
        return "authentication/login";
    }

    @PreAuthenticate(loggedIn = false)
    @GetMapping("/register")
    public String registerGet(){
        return "authentication/register";
    }

    @PostMapping("/register")
    public String registerPOST(UserRegisterDto userRegisterDto, HttpSession httpSession){
        if(userRegisterDto.getPassword().equals(userRegisterDto.getConfirmPassword())){
            this.userServices.create(userRegisterDto);
            httpSession.setAttribute("username",userRegisterDto.getUsername());
            httpSession.setAttribute("email",userRegisterDto.getEmail());
            return "redirect:/homepage";
        }
        return "authentication/register";
    }

    @PreAuthenticate(loggedIn = false)
    @GetMapping("/logout")
    public String logout(HttpSession httpSession){
        httpSession.removeAttribute("username");
        httpSession.removeAttribute("email");
        return "redirect:/";
    }
}
