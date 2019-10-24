package upd.accountservice.Controllers;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import upd.accountservice.Commands.*;
import upd.accountservice.Controllers.IncomingModels.*;

import java.util.UUID;

@RestController("/api")
public class AccountCommandController {

  private final CommandGateway commandGateway;

  @Autowired
    public AccountCommandController(final CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PostMapping("/register")
    public void register(@RequestBody RegisterApiModel apiModel) {
        String accountId = UUID.randomUUID().toString();

        commandGateway.send(
                new CreateAccount(
                        accountId,
                        apiModel.getEmail(),
                        apiModel.getPassword(),
                        apiModel.getPassword()
                )
        );
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
