package app.db.repositories;

import app.db.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car,Long> {

    List<Car> getCarsByMake(String make);
    Car getCarById(long id);
}
