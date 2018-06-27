package app;

import app.models.Account;
import app.models.User;
import app.repositories.AccountRepository;
import app.repositories.UserRepository;
import app.services.AccountService;
import app.services.AccountServiceImpl;
import app.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.LinkedList;

@SpringBootApplication
@Component
public class ConsoleRunner implements CommandLineRunner {
    private AccountServiceImpl accountService;
    private UserServiceImpl userService;

    @Autowired
    public ConsoleRunner(AccountServiceImpl accountService, UserServiceImpl userService, AccountRepository accountRepository, UserRepository userRepository) {
        this.accountService = accountService;
        this.userService = userService;
    }

    @Override
    public void run(String... strings) throws Exception {
        User user=new User();
        user.setUsername("joro");
        user.setAge(17);

        Account account=new Account();
        account.setUser(user);
        account.setBalance(new BigDecimal(500));

        user.setAccounts(new LinkedList<Account>());
        user.getAccounts().add(account);
        userService.registerUser(user);

       accountService.withdrawMoney(new BigDecimal(150),1L);
       accountService.transferMoney(new BigDecimal(500),1L);
    }
}
