package upd.accountservice.Services;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upd.accountservice.Models.Account;
import upd.accountservice.Queries.FindAccountById;
import upd.accountservice.Queries.FindAllAccounts;
import upd.accountservice.Repo.AccountCrudRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountQueryHandler {

    private final AccountCrudRepository repository;


    @Autowired
    public AccountQueryHandler(AccountCrudRepository repository) { this.repository = repository; }


    @QueryHandler
    public List<Account> handle(FindAllAccounts query) {
       List<Account> returnList = new ArrayList<>();
       repository.findAll().iterator().forEachRemaining(returnList::add);
       return returnList;
    }

    @QueryHandler
    public Account handle(FindAccountById query) {
        if(repository.findById(query.getId()).isPresent()) {
            return repository.findById(query.getId()).get();
        }
        return null;
    }
}

