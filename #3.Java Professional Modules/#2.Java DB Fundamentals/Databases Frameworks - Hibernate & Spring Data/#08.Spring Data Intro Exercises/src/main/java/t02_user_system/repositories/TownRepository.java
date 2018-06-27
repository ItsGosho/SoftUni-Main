package t02_user_system.repositories;

import org.springframework.data.repository.CrudRepository;
import t02_user_system.models.Town;

public interface TownRepository extends CrudRepository<Town,Integer> {
}
