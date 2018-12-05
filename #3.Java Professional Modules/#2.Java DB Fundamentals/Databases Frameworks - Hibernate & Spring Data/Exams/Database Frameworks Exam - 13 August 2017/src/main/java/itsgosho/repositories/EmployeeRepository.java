package itsgosho.repositories;

import itsgosho.domain.entities.Branch;
import itsgosho.domain.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    @Query("select e,concat(e.firstName,' ',e.lastName) as full_name,e.position,ec.number\n" +
            "from Employee as e\n" +
            "join Branch as b on b = e.branch\n" +
            "join Product as p on p.branch = b\n" +
            "join EmployeeCard as ec on ec.employee=e\n" +
            "order by full_name,length(e.position) desc")
    List<Object> exportProductiveEmployees();
}
