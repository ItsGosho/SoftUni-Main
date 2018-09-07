package app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController extends BaseController{

    @GetMapping("/")
    public String index(){
        return "home/index";
    }
}
