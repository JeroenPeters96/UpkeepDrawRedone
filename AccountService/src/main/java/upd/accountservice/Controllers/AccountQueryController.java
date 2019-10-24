package upd.accountservice.Controllers;

import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import upd.accountservice.Models.Account;
import upd.accountservice.Queries.FindAllAccounts;

import java.util.List;

@RestController("/api")
public class AccountQueryController {

    private final QueryGateway queryGateway;

    @Autowired
    public AccountQueryController(final QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }


    @GetMapping("/getAccounts")
    public List<Account> findAllAccounts(){
        return queryGateway.query(new FindAllAccounts(),
                ResponseTypes.multipleInstancesOf(Account.class))
                .join();
    }
}
