package itsgosho.domain.repositories;

import itsgosho.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {

    User findUserByUsername(String username);
    User findUserByEmail(String email);
}
