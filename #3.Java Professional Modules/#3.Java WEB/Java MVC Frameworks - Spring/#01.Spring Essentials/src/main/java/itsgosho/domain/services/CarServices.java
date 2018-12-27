package itsgosho.domain.services;

import itsgosho.domain.entities.Car;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CarServices {
    List<Car> getAllCarsByMake(String make);

    Car getCar(Integer id);

    List<Car> getAll();
}
