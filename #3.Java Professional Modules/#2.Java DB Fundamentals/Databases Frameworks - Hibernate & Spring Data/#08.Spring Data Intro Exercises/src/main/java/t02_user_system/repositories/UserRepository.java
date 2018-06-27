package t02_user_system.repositories;

import org.springframework.data.repository.CrudRepository;
import t02_user_system.models.User;

import java.util.List;

public interface UserRepository extends CrudRepository<User,Integer> {
    List<User> findUsersByEmailEquals(String email);
}
