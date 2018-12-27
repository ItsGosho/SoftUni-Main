package itsgosho.domain.repositories;

import itsgosho.domain.entities.Capital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CapitalRepository extends JpaRepository<Capital,String> {

    Capital findCapitalByName(String name);
}
