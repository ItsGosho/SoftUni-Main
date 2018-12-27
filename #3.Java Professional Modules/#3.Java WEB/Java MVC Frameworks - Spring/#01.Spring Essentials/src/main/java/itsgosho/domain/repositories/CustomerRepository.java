package itsgosho.domain.repositories;

import itsgosho.domain.entities.Car;
import itsgosho.domain.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

}
