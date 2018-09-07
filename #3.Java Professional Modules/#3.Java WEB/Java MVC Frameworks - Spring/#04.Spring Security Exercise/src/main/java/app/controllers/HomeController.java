package app.controllers;

import app.db.models.User;
import app.db.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.jaas.AuthorityGranter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.security.Principal;

@Controller
public class HomeController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String index(){
        return "home/index";
    }

    @GetMapping("/admin/home")
    public String adminHome(Principal principal,Model model){
        User user = (User) this.userRepository.findUserByUsername(principal.getName());
        model.addAttribute("username",user.getUsername());
        model.addAttribute("email",user.getEmail());
        return "home/admin-home";
    }

    @GetMapping("/user/home")
    public String userHome(Principal principal,Model model){
        User user = (User) this.userRepository.findUserByUsername(principal.getName());
        model.addAttribute("username",user.getUsername());
        model.addAttribute("email",user.getEmail());
        return "home/user-home";
    }
}
