package app.controllers;

import app.db.dtos.UserRegisterDto;
import app.db.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthenticationController {

    private final UserService userService;

    @Autowired
    public AuthenticationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login(){
        return "authentication/login";
    }

    @GetMapping("/register")
    public String register(){
        return "authentication/register";
    }

    @PostMapping("/register")
    public String registerProcess(UserRegisterDto userRegisterDto){
        if(this.userService.createUser(userRegisterDto)){
            return "redirect:/login";
        }else{
            return "redirect:/register";
        }
    }
}
