package itsgosho.domain.services;

import itsgosho.domain.entities.Car;
import itsgosho.domain.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServicesImp implements CarServices{

    private final CarRepository carRepository;

    @Autowired
    public CarServicesImp(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<Car> getAllCarsByMake(String make){
        return this.carRepository.findAll().stream().filter(x->x.getMake().toLowerCase().equals(make.toLowerCase()))
                .sorted((x1,x2)->x1.getMake().compareTo(x2.getMake())).collect(Collectors.toList());
    }

    @Override
    public Car getCar(Integer id){
        return this.carRepository.findCarById(id);
    }

    @Override
    public List<Car> getAll(){
        return this.carRepository.findAll();
    }
}
