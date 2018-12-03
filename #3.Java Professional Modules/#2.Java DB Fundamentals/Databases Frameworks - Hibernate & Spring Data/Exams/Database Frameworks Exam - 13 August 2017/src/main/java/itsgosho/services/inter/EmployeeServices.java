package itsgosho.services.inter;

import itsgosho.domain.entities.Branch;
import itsgosho.domain.entities.Employee;

public interface EmployeeServices {

    boolean save(Employee employee);
    void seedDatabase();
    void exportProductiveEmployee();
}
