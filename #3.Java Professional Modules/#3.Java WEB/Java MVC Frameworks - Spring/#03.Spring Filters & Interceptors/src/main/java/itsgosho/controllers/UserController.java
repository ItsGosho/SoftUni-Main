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
@RequestMapping("/users")
public class UserController extends BaseController {

    private final UserServices userServices;

    @Autowired
    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }

    @GetMapping("/register")
    @PreAuthenticate(loggedIn = false)
    public ModelAndView registerGET() {
        return super.page("main-page", "users/user-register-form", "Register");
    }

    @GetMapping("/login")
    @PreAuthenticate(loggedIn = false)
    public ModelAndView loginGET() {
        return super.page("main-page", "users/user-login-form", "Login");
    }

    @GetMapping(value = "/exists", produces = "application/json")
    @ResponseBody
    public String usernameExistsGET(@RequestParam(required = false) String username, @RequestParam(required = false) String email) {
        return this.userServices.determinateIfExistsForJSON(username, email);
    }

    @GetMapping(value = "/isvalid", produces = "application/json")
    @ResponseBody
    public String isValidGET(@RequestParam String username, @RequestParam String password) {
        return this.userServices.determinateIfLoginValidForJSON(username, password);
    }

    @PostMapping("/register")
    @PreAuthenticate(loggedIn = false)
    public ModelAndView registerPOST(UserRegisterDto userRegisterDto, ModelAndView modelAndView) {
        if (this.userServices.registerUser(userRegisterDto)) {
            return super.redirect("/users/login");
        }
        return super.page("main-page", "users/user-register-form", "Register", modelAndView);
    }

    @PostMapping("/login")
    @PreAuthenticate(loggedIn = false)
    public ModelAndView loginPost(UserLoginDto userLoginDto, HttpSession httpSession) {
        if (this.userServices.loginUser(userLoginDto, httpSession)) {
            return super.redirect("/");
        }
        return super.page("main-page", "users/user-login-form", "Login");
    }

    @GetMapping("/logout")
    @PreAuthenticate(loggedIn = true)
    public ModelAndView logout(HttpSession httpSession) {
        this.userServices.logout(httpSession);
        return super.redirect("/");
    }
}
