package app.services;

import app.models.Account;
import app.models.User;
import app.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


@Service
@Primary
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    @Override
    public void withdrawMoney(BigDecimal money, Long id) {
           Account account=accountRepository.getAccountById(id);
           User user=account.getUser();
           if(user!=null){
               if(account.getBalance().subtract(money).compareTo(new BigDecimal(0))>0){
                   account.setBalance(account.getBalance().subtract(money));
                   accountRepository.save(account);
               }else{
                   throw new IllegalArgumentException("There is not enought money for the withdraw! ;d");
               }
           }else{
               throw new IllegalArgumentException("There is not user with that username!");
           }
    }

    @Override
    public void transferMoney(BigDecimal money, Long id) {
        Account account=accountRepository.getAccountById(id);
        User user=account.getUser();
        if(user!=null){
            if(money.compareTo(new BigDecimal(0))>0){
                account.setBalance(account.getBalance().add(money));
                accountRepository.save(account);
            }else{
                throw new IllegalArgumentException("The money for insert are <0");
            }
        }else{
            throw new IllegalArgumentException("There is not user with that username!");
        }
    }
}
