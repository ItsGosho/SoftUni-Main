package app;

import app.dtos.EmployeeDto;
import app.dtos.ManagerDto;
import app.entities.Employee;
import app.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;

@SpringBootApplication
@Component
public class ConsoleRunner implements CommandLineRunner {

    private EmployeeRepository employeeRepository;

    @Autowired
    public ConsoleRunner(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        ModelMapper mapper=new ModelMapper();

        Employee djoni=new Employee();
        djoni.setFirstName("Djoni");
        djoni.setLastName("Baroni");
        djoni.setOnHoliday(true);
        djoni.setSalary(new BigDecimal(1700));
        djoni.setBirthday(new java.sql.Date(1993,1,1));
        this.employeeRepository.save(djoni);

        Employee roki=new Employee();
        roki.setFirstName("Roki");
        roki.setLastName("Djoki");
        roki.setOnHoliday(true);
        roki.setSalary(new BigDecimal(500));
        roki.setBirthday(new java.sql.Date(2011,1,1));
        this.employeeRepository.save(roki);

        List<Employee> employees=this.employeeRepository.getAllByBirthdayAfter(new Date(1,1,1));
        java.lang.reflect.Type targetListType = new TypeToken<List<EmployeeDto>>() {}.getType();
        List<EmployeeDto> employeesDto=mapper.map(employees,targetListType);
        for (EmployeeDto item : employeesDto) {
            if(item.getManager()==null){
                System.out.println(item.getFirstName()+" "+item.getLastName()+" "+item.getSalary()+" - Manager: [no manager]");
            }else{
                System.out.println(item.getFirstName()+" "+item.getLastName()+" "+item.getSalary()+" - Manager: "+item.getManager().getFirstName());
            }
        }
    }
    public void t02_completed(){
        ModelMapper modelMapper=new ModelMapper();
        List<Employee> employee=this.employeeRepository.findAll();
        java.lang.reflect.Type targetListType = new TypeToken<List<ManagerDto>>() {}.getType();
        List<ManagerDto> managerDto=modelMapper.map(employee, targetListType);
        for (ManagerDto dto : managerDto) {
            System.out.println(dto.getFirstName()+" "+dto.getLastName()+" | "+dto.getEmployees().size());
            for (EmployeeDto employeeDto : dto.getEmployees()) {
                System.out.println("- "+employeeDto.getFirstName()+" "+employeeDto.getLastName()
                        +" "+employeeDto.getSalary());
            }
        }
    }
}
