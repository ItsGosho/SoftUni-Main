package itsgosho.controllers;

import itsgosho.domain.services.CarServices;
import itsgosho.domain.services.CarServicesImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cars")
public class CarController extends BaseController{

    private final CarServices carServices;

    @Autowired
    public CarController(CarServices carServices) {
        this.carServices = carServices;
    }

    @GetMapping("")
    private ModelAndView cars(ModelAndView modelAndView){
        modelAndView.addObject("cars",this.carServices.getAll());
        return super.view("cars/allCars",modelAndView);
    }

    @GetMapping("/{make}")
    private ModelAndView carsFromMake(ModelAndView modelAndView,@PathVariable String make){
        modelAndView.addObject("cars",this.carServices.getAllCarsByMake(make));
        return super.view("cars/getAllCars",modelAndView);
    }

    @GetMapping("/{id}/parts")
    private ModelAndView carsFromMake(ModelAndView modelAndView,@PathVariable Integer id){
        modelAndView.addObject("car",this.carServices.getCar(id));
        return super.view("cars/carWithParts",modelAndView);
    }
}
