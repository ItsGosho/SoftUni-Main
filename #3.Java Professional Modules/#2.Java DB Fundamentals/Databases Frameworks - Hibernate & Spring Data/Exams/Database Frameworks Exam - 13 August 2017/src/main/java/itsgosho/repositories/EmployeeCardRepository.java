package itsgosho.repositories;

import itsgosho.domain.entities.Branch;
import itsgosho.domain.entities.EmployeeCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeCardRepository extends JpaRepository<EmployeeCard,Long> {

    EmployeeCard findByNumber(String number);

    @Query("select ec\n" +
            "from EmployeeCard as ec\n" +
            "where ec.employee is null\n" +
            "order by ec.id asc")
    List<Object> exportFreeCards();
}
