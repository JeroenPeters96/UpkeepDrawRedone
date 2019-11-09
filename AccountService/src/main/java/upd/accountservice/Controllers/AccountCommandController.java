package upd.accountservice.Controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import org.axonframework.commandhandling.gateway.CommandGateway;

import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upd.accountservice.Commands.*;
import upd.accountservice.Controllers.IncomingModels.*;
import upd.accountservice.Models.Account;
import upd.accountservice.Queries.FindAccountById;

import java.util.UUID;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/cmd")
@Api(value = "/cmd",tags = {"Account Commands"})
@SwaggerDefinition( tags = {
        @Tag(name = "Account Commands",description = "Account related functionalities")
})

public class AccountCommandController {

    private final CommandGateway commandGateway;
    private final QueryGateway queryGateway;

    @Autowired
    public AccountCommandController(final CommandGateway commandGateway, @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection") final QueryGateway queryGateway) {
        this.commandGateway = commandGateway;
        this.queryGateway = queryGateway;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterApiModel apiModel) {
        String accountId = UUID.randomUUID().toString();
        String id = UUID.randomUUID().toString();
        commandGateway.send(
                new CreateAccount(
                        id,
                        accountId,
                        apiModel.getEmail(),
                        apiModel.getPassword(),
                        apiModel.getUsername()
                )
        );

        Account savedAccount;

        try {
            savedAccount = queryGateway.query(new FindAccountById(accountId), Account.class).get();
            if (savedAccount.getId().equals(accountId) &&
                    savedAccount.getEmail().equals(apiModel.getEmail()) &&
                    savedAccount.getUsername().equals(apiModel.getUsername()) &&
                    savedAccount.getPassword().equals(apiModel.getPassword()))
                return new ResponseEntity<>("Registration succesfull", HttpStatus.OK);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Registration unsuccesfull", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody DeleteApiModel apiModel) {
        String id = UUID.randomUUID().toString();
        Account account;
        try {
            account = queryGateway.query(new FindAccountById(apiModel.getAccountId()), Account.class).get();
            if (account == null)
                return;
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return;
        }
        commandGateway.send(
                new DeleteAccount(
                        id,
                        apiModel.getAccountId()
                )
        );
    }

    @PostMapping("/email")
    public void changeEmail(@RequestBody ChangeEmailApiModel apiModel) {
        String id = UUID.randomUUID().toString();
        commandGateway.send(
                new ChangeEmail(
                        id,
                        apiModel.getAccountId(),
                        apiModel.getNewEmail()
                )
        );
    }

    @PostMapping("/username")
    public void changeUsername(@RequestBody ChangeUsernameApiModel apiModel) {
        String id = UUID.randomUUID().toString();
        commandGateway.send(
                new ChangeUsername(
                        id,
                        apiModel.getAccountId(),
                        apiModel.getUsername()
                )
        );
    }

    @PostMapping("/password")
    public void changePassword(@RequestBody ChangePasswordApiModel apiModel) {
        String id = UUID.randomUUID().toString();
        commandGateway.send(
                new ChangePassword(
                        id,
                        apiModel.getAccountId(),
                        apiModel.getPassword()
                )
        );
    }
}
