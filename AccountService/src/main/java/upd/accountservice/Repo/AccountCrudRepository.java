package upd.accountservice.Repo;

import org.springframework.data.repository.CrudRepository;
import upd.accountservice.Models.Account;

import java.util.List;
import java.util.Optional;

public interface AccountCrudRepository extends CrudRepository<Account,String> {

    List<Account> findAccountByEmail(String email);

}
