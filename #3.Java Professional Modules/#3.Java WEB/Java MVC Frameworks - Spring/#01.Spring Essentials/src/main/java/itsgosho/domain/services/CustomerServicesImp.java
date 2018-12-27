package itsgosho.domain.services;

import itsgosho.domain.dtos.AddCustomerDto;
import itsgosho.domain.entities.Customer;
import itsgosho.domain.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class CustomerServicesImp implements CustomerServices {

    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServicesImp(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getAllByBirthdateAscending() {
        return customerRepository.findAll().stream()
                .sorted((x1, x2) -> x2.getBirthDate().compareTo(x1.getBirthDate()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Customer> getAllByBirthdateDescending() {
        return customerRepository.findAll().stream()
                .sorted((x1, x2) -> x1.getBirthDate().compareTo(x2.getBirthDate()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Customer> getAll() {
        return this.customerRepository.findAll();
    }

    @Override
    public boolean create(AddCustomerDto addCustomerDto) {
        Customer customer = new Customer();
        customer.setName(addCustomerDto.getName());
        try {
            customer.setBirthDate(format.parse(addCustomerDto.getBirthdate()));
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
        customer.setYoungDriver(false);
        this.customerRepository.save(customer);
        return true;
    }

    @Override
    public Customer getById(Integer id) {
        return this.customerRepository.findById(id).orElse(null);
    }

    @Override
    public boolean edit(Integer id,AddCustomerDto addCustomerDto) {
        Customer customer =  this.getById(id);
        customer.setName(addCustomerDto.getName());
        try {
            customer.setBirthDate(format.parse(addCustomerDto.getBirthdate()));
        } catch (ParseException e) {
            e.printStackTrace() ;
            return false;
        }
        customer.setYoungDriver(false);
        this.customerRepository.save(customer);
        return true;
    }
}
