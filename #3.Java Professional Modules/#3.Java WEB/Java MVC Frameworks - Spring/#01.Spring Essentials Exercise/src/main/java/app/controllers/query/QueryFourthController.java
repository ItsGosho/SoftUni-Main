package app.controllers.query;

import app.db.entities.Car;
import app.db.entities.Part;
import app.db.repositories.CarRepository;
import app.db.repositories.PartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class QueryFourthController {

@Autowired
private CarRepository carRepository;
@Autowired
private PartRepository partRepository;

    @GetMapping("/cars/{id}/parts")
    private String carParts(@PathVariable long id){
        //Car car = this.carRepository.getCarById(id);
        List<Part> parts = this.partRepository.findAll();
        List<Car> cars=parts.get(0).getCar();
          return "";
    }
}
