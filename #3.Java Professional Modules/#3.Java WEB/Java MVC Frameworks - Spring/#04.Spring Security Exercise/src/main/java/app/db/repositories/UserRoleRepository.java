package app.db.repositories;

import app.db.models.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole,String> {

    UserRole findUserRoleByAuthority(String authority);
}
