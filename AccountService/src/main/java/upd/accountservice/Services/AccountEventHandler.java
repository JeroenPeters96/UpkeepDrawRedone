package upd.accountservice.Services;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upd.accountservice.Events.*;
import upd.accountservice.Models.Account;
import upd.accountservice.Repo.AccountCrudRepository;

import java.util.List;

@Service
public class AccountEventHandler {

    private final AccountCrudRepository repository;

    @Autowired
    public AccountEventHandler(final AccountCrudRepository repository) {
        this.repository = repository;
    }

    @EventHandler
    public void on(AccountCreated event){
        Account existing = repository.findAccountByEmail(event.getEmail());

        if(existing == null)
            repository.save(new Account(event));
    }

    @EventHandler
    public void on(AccountDeleted event){
        if(repository.findById(event.getAccountId()+"").isPresent()){
            repository.delete(repository.findById(event.getAccountId()+"").get());
        }
    }

    @EventHandler
    public void on(EmailChanged event){
        Account account;
        if(!repository.findById(event.getAccountId()+"").isPresent())
            return;
        account = repository.findById(event.getAccountId()+"").get();
        account.setEmail(event.getEmail());
        repository.save(account);
    }

    @EventHandler
    public void on(PasswordChanged event){
        Account account;
        if(!repository.findById(event.getAccountId()+"").isPresent())
            return;
        account = repository.findById(event.getAccountId()+ "").get();
        account.setPassword(event.getNewPassword());
        repository.save(account);
    }

    @EventHandler
    public void on(UsernameChanged event){
        Account account;
        if(!repository.findById(event.getAccountId()+"").isPresent())
            return;
        account = repository.findById(event.getAccountId()+"").get();
        account.setUsername(event.getNewUsername());
        repository.save(account);
    }
}
