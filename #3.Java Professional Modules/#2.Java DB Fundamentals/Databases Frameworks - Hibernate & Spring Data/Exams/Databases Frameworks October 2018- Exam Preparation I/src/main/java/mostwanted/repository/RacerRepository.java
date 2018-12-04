package mostwanted.repository;

import mostwanted.domain.entities.Racer;
import mostwanted.domain.entities.Town;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RacerRepository extends JpaRepository<Racer,Integer> {
    Racer findRacerByName(String name);
    List<Racer> findAllByHomeTown(Town town);
}
