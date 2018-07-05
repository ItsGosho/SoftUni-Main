package app.repositories;

import app.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    Employee getEmployeeById(int id);

    List<Employee> getAllByBirthdayAfter(Date date);
}
