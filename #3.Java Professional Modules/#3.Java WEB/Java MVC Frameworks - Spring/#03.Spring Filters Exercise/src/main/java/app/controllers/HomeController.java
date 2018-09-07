package app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(){
        return "home/index";
    }

    @PreAuthenticate(loggedIn = true)
    @GetMapping("/homepage")
    public String homepage(Model model, HttpSession httpSession){
        model.addAttribute("username",httpSession.getAttribute("username"));
        model.addAttribute("email",httpSession.getAttribute("email"));
        return "home/homepage";
    }
}
