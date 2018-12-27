package itsgosho.domain.services;

import itsgosho.domain.dtos.AddCustomerDto;
import itsgosho.domain.entities.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CustomerServices {
    List<Customer> getAllByBirthdateAscending();

    List<Customer> getAllByBirthdateDescending();

    List<Customer> getAll();

    boolean create(AddCustomerDto addCustomerDto);

    Customer getById(Integer id);

    boolean edit(Integer id,AddCustomerDto addCustomerDto);
}
