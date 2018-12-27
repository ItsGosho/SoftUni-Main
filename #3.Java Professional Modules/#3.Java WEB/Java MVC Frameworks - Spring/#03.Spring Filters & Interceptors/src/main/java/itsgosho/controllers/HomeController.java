package itsgosho.controllers;

import itsgosho.config.validators.preAuthenticate.PreAuthenticate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/")
public class HomeController extends BaseController {

    @GetMapping("")
    public ModelAndView home(){
        return super.page("main-page","home/homepage","Home");
    }
}
