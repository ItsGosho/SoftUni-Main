package itsgosho.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/")
public class HomeController extends BaseController {

    @GetMapping("")
    public ModelAndView home(){
        return super.page("main-page","pages/home/home","Home");
    }
}
