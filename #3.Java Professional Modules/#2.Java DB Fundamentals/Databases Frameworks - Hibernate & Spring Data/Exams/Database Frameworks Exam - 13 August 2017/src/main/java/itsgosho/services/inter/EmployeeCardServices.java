package itsgosho.services.inter;

import itsgosho.domain.entities.Branch;
import itsgosho.domain.entities.EmployeeCard;

public interface EmployeeCardServices {

    boolean save(EmployeeCard employeeCard);
    void seedDatabase();
    void exportFreeCards();
}
