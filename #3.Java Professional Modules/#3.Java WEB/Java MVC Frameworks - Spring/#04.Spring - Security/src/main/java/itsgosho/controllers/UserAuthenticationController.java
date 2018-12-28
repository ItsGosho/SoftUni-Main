package itsgosho.controllers;

import com.fasterxml.jackson.databind.util.JSONPObject;
import itsgosho.config.validators.preAuthenticate.PreAuthenticate;
import itsgosho.domain.dtos.user.UserLoginDto;
import itsgosho.domain.dtos.user.UserRegisterDto;
import itsgosho.domain.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class UserAuthenticationController extends BaseController {

    private final UserServices userServices;

    @Autowired
    public UserAuthenticationController(UserServices userServices) {
        this.userServices = userServices;
    }

    @GetMapping("/register")
    public ModelAndView registerGET() {
        return super.page("main-page", "users/user-register-form", "Register");
    }

    @GetMapping("/login")
    public ModelAndView loginGET() {
        return super.page("main-page", "users/user-login-form", "Login");
    }

    @PostMapping("/register")
    public ModelAndView registerPOST(UserRegisterDto userRegisterDto, ModelAndView modelAndView) {
        if (this.userServices.registerUser(userRegisterDto)) {
            return super.redirect("/login");
        }
        return super.page("main-page", "users/user-register-form", "Register", modelAndView);
    }
}
