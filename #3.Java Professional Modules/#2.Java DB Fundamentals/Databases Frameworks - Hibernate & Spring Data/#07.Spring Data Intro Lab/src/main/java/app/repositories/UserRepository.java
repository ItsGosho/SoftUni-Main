package app.repositories;

import app.models.Account;
import app.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User,Long> {

    User getByUsername(String username);
}
