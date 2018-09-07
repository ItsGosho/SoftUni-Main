package app.controllers.query;

import app.controllers.BaseController;
import app.db.entities.Car;
import app.db.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class QueryTwoController extends BaseController {

    @Autowired
    private CarRepository carRepository;
    
    @GetMapping("/cars/{make}")
    @ResponseBody
    private String carsFromMake(@PathVariable String make){
        StringBuilder str=new StringBuilder();
        List<Car> cars = this.carRepository.getCarsByMake(make);
        for (Car car : cars) {
            str.append("<h1>"+car.getMake()+" "+car.getModel()+" "+car.getTravelledDistance()+" "+"</h1>");
        }
        return str.toString();
    }
}
