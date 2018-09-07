package app.db.services.car;

import app.db.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImp implements CarServices{

    @Autowired
    private CarRepository carRepository;
}
