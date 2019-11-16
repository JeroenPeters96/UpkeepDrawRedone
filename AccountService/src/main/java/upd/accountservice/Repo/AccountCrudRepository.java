package upd.accountservice.Repo;

import org.springframework.data.repository.CrudRepository;
import upd.accountservice.Models.Account;

import java.util.List;
import java.util.Optional;

public interface AccountCrudRepository extends CrudRepository<Account,Integer> {

    Account findAccountByEmail(String email);
    Account findAccountByEmailAndPassword(String email, String password);

}
