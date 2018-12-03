package itsgosho.repositories;

import itsgosho.domain.entities.Branch;
import itsgosho.domain.entities.EmployeeCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeCardRepository extends JpaRepository<EmployeeCard,Long> {

    EmployeeCard findByNumber(String number);
}
