package upd.accountservice.Controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import org.axonframework.commandhandling.gateway.CommandGateway;

import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
    public AccountCommandController(final CommandGateway commandGateway, final QueryGateway queryGateway) {
        this.commandGateway = commandGateway;
        this.queryGateway = queryGateway;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterApiModel apiModel) {
        String accountId = UUID.randomUUID().toString();
        commandGateway.send(
                new CreateAccount(
                        accountId,
                        apiModel.getEmail(),
                        apiModel.getPassword(),
                        apiModel.getUsername()
                )
        );

        Account savedAccount;

        try {
            savedAccount = queryGateway.query(new FindAccountById(accountId), Account.class).get();
           if(savedAccount.getId().equals(accountId)&&
           savedAccount.getEmail().equals(apiModel.getEmail())&&
           savedAccount.getUsername().equals(apiModel.getUsername())&&
           savedAccount.getPassword().equals(apiModel.getPassword()))
               return new ResponseEntity<>("Registration succesfull", HttpStatus.OK);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Registration unsuccesfull",HttpStatus.NOT_FOUND);
    }

    @PostMapping("/delete")
    public void delete(@RequestBody DeleteApiModel apiModel) {
      commandGateway.send(
              new DeleteAccount(
                      apiModel.getAccountId()
              )
      );
    }

    @PostMapping("/email")
    public void changeEmail(@RequestBody ChangeEmailApiModel apiModel) {
      commandGateway.send(
              new ChangeEmail(
                      apiModel.getAccountId(),
                      apiModel.getNewEmail()
              )
      );
    }

    @PostMapping("/username")
    public void changeUsername(@RequestBody ChangeUsernameApiModel apiModel) {
        commandGateway.send(
                new ChangeUsername(
                        apiModel.getAccountId(),
                        apiModel.getUsername()
                )
        );
    }

    @PostMapping("/password")
    public void changePassword(@RequestBody ChangePasswordApiModel apiModel) {
      commandGateway.send(
              new ChangePassword(
                      apiModel.getAccountId(),
                      apiModel.getPassword()
              )
      );
    }
}
