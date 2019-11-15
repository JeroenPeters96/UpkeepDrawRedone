package upd.accountservice;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.commandhandling.model.AggregateLifecycle;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.factory.annotation.Autowired;
import upd.accountservice.Commands.ChangeEmail;
import upd.accountservice.Commands.CreateAccount;
import upd.accountservice.Commands.DeleteAccount;
import upd.accountservice.Events.AccountCreated;
import upd.accountservice.Events.AccountDeleted;
import upd.accountservice.Events.EmailChanged;

import java.util.regex.Pattern;

@Aggregate
public class AccountAggregate {

    @Autowired
    private EventSourcingRepository<AccountAggregate> repo;

    @AggregateIdentifier
    private String id;

    @CommandHandler
    public AccountAggregate(CreateAccount command) {
        String emailRegex = "^(.+)@(.+)$";
        Pattern emailPattern = Pattern.compile(emailRegex);
        if(!emailPattern.matcher(command.getEmail()).matches()){
         throw new IllegalStateException("Not a valid email.");
        }
        AggregateLifecycle.apply(
                new AccountCreated(
                command.getId(),
                command.getEmail(),
                command.getPassword(),
                command.getUsername()
                ));
    }

    @EventSourcingHandler
    public void on(AccountCreated event) {
        this.id = event.getId();
    }

    @CommandHandler
    public AccountAggregate(ChangeEmail command) {
        String emailRegex = "^(.+)@(.+)$";
        Pattern emailPattern = Pattern.compile(emailRegex);
        if(!emailPattern.matcher(command.getEmail()).matches()){
            throw new IllegalStateException("Not a valid email.");
        }
        AggregateLifecycle.apply(
                new EmailChanged(
                        command.getId(),
                        command.getAccountId(),
                        command.getEmail()
                ));
    }

    @EventSourcingHandler
    public void on(EmailChanged event) {
        this.id = event.getId();
    }


    @CommandHandler
    public AccountAggregate(DeleteAccount command) {
        AggregateLifecycle.apply(
                new AccountDeleted(
                        command.getId(),
                        command.getAccountId()
                )
        );
    }

    @EventSourcingHandler
    public void on(AccountDeleted event) {
        this.id = event.getId();
    }

    protected AccountAggregate() {}
    
}
