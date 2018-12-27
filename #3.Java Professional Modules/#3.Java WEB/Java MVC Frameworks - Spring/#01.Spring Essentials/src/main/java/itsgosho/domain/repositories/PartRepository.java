package itsgosho.domain.repositories;

import itsgosho.domain.entities.Car;
import itsgosho.domain.entities.Part;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartRepository extends JpaRepository<Part,Integer> {
}
