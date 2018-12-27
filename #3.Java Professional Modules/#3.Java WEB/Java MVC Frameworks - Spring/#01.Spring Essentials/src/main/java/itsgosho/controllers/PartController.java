package itsgosho.controllers;

import itsgosho.domain.services.PartServices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/parts")
public class PartController extends BaseController{

    private final PartServices partServices;

    public PartController(PartServices partServices) {
        this.partServices = partServices;
    }


    @GetMapping("")
    private ModelAndView cars(ModelAndView modelAndView){
        modelAndView.addObject("parts",this.partServices.getAll());
        return super.view("parts/allParts",modelAndView);
    }
}
