package app.repositories;

import app.models.Account;
import app.models.User;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account,Long> {

    Account getAccountById(long id);
}
