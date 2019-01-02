package itsgosho.controllers;

import itsgosho.domain.models.dtos.UserRegisterDto;
import itsgosho.services.user.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserAuthenticationController extends BaseController {

    private final UserServices userServices;

    @Autowired
    public UserAuthenticationController(UserServices userServices) {
        this.userServices = userServices;
    }

    @GetMapping("/register")
    public ModelAndView registerGet(){
        return super.page("main-page","auth/register-form","Register");
    }
    @GetMapping("/login")
    public ModelAndView loginGet(){
        return super.page("main-page","auth/login-form","Login");
    }

    @PostMapping("/register")
    public ModelAndView registerProceed(UserRegisterDto userRegisterDto){
        if(this.userServices.register(userRegisterDto)){
            return super.redirect("/login");
        }
        return super.page("main-page","auth/register-form","Register");
    }
}
