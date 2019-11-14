package upd.accountservice.Controllers;

import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.responsetypes.ResponseTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import upd.accountservice.Controllers.IncomingModels.GetAccountByIdApiModel;
import upd.accountservice.Models.Account;
import upd.accountservice.Queries.FindAccountById;
import upd.accountservice.Queries.FindAllAccounts;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController("/qry")
public class AccountQueryController {

    private final QueryGateway queryGateway;

    @Autowired
    public AccountQueryController(@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection") final QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }


    @GetMapping("/getAccounts")
    public ResponseEntity<List<Account>> findAllAccounts(){
        List<Account> accounts = queryGateway.query(new FindAllAccounts(),
                ResponseTypes.multipleInstancesOf(Account.class))
                .join();

        if(accounts.size()==0)
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(accounts,HttpStatus.OK);
    }

    @GetMapping("/getAccount")
    public ResponseEntity<Account> findAccount(@RequestBody GetAccountByIdApiModel apiModel) {
        if(apiModel.getAccountId().equals("")){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        try {
            Account account = queryGateway.query(
                    new FindAccountById(apiModel.getAccountId()),
                            Account.class).get();
            if(account!=null && account.getId().equals(apiModel.getAccountId()))
                return new ResponseEntity<>(account,HttpStatus.OK);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
    }

    @GetMapping("/getUsername/{id}")
    public ResponseEntity<String> findUsername(@PathVariable String id) {
        try {
            Account account = queryGateway.query(
                    new FindAccountById(id),
                    Account.class).get();
            if(account!=null && account.getId().equals(id))
                return new ResponseEntity<>(account.getUsername(),HttpStatus.OK);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
    }
}
