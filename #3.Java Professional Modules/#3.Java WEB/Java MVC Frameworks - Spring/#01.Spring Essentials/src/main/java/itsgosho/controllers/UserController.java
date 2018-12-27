package itsgosho.controllers;

import itsgosho.domain.dtos.UserCreateDto;
import itsgosho.domain.dtos.UserLoginDto;
import itsgosho.domain.services.UserServices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    private final UserServices userServices;

    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }

    @GetMapping("/register")
    public ModelAndView registerGet(){
        return super.view("users/registerForm");
    }

    @PostMapping("/register")
    public ModelAndView registerPost(UserCreateDto userCreateDto){
       if(this.userServices.addUser(userCreateDto)){
           return super.redirect("/user/login");
       }
        return super.view("users/registerForm");
    }

    @GetMapping("/login")
    public ModelAndView loginGet(){
        return super.view("users/loginForm");
    }

    @PostMapping("/login")
    public ModelAndView lognPost(UserLoginDto userLoginDto, HttpSession httpSession){
        if(this.userServices.loginUser(userLoginDto,httpSession)){
            return super.redirect("/customers");
        }
        return super.view("users/loginForm");
    }
}
