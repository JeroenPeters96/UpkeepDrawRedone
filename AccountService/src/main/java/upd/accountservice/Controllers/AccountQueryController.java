package upd.accountservice.Controllers;

import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.responsetypes.ResponseTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upd.accountservice.Controllers.IncomingModels.GetAccountByIdApiModel;
import upd.accountservice.Controllers.IncomingModels.LoginApiModel;
import upd.accountservice.Models.Account;
import upd.accountservice.Queries.FindAccountById;
import upd.accountservice.Queries.FindAllAccounts;
import upd.accountservice.Queries.Login;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/qry")
public class AccountQueryController {

    private final QueryGateway queryGateway;

    @Autowired
    public AccountQueryController(@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection") final QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    @GetMapping("/login")
    public ResponseEntity<Account> login(LoginApiModel apiModel) {
        try {
            Account account = queryGateway.query(new Login(
                    apiModel.getEmail(),
                    apiModel.getPassword()
            ),Account.class).get();
            if(account!=null) {
                return new ResponseEntity<>(account, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
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
    public ResponseEntity<Account> findAccount(GetAccountByIdApiModel apiModel) {
        if(apiModel.getAccountId()==0){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        try {
            Account account = queryGateway.query(
                    new FindAccountById(apiModel.getAccountId()),
                            Account.class).get();
            if(account!=null && account.getId() == (apiModel.getAccountId()))
                return new ResponseEntity<>(account,HttpStatus.OK);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
    }

    @GetMapping("/getUsername/{id}")
    public ResponseEntity<String> findUsername(@PathVariable int id) {

        try {
            Account account = queryGateway.query(
                    new FindAccountById(id),
                    Account.class).get();
            if(account!=null && account.getId() == id)
                return new ResponseEntity<>(account.getUsername(),HttpStatus.OK);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
    }
}
