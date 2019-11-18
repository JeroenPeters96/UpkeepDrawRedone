package upd.accountservice;


import org.axonframework.test.aggregate.AggregateTestFixture;
import org.axonframework.test.aggregate.FixtureConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import upd.accountservice.Commands.ChangeEmail;
import upd.accountservice.Commands.CreateAccount;
import upd.accountservice.Commands.DeleteAccount;
import upd.accountservice.Events.AccountCreated;
import upd.accountservice.Events.AccountDeleted;
import upd.accountservice.Events.EmailChanged;
import upd.accountservice.Models.Account;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringRunner.class)
@ActiveProfiles("test")
class AccountAggregateTest {

    private FixtureConfiguration<AccountAggregate> fixture;
    private Account account1;

    @BeforeEach
    public void setup() {
        fixture = new AggregateTestFixture<>(AccountAggregate.class);
        this.account1 = new Account("test@test.nl","pass","user1");
        account1.setId(1);
    }

    @Test
    void CreateAccountTest() {
        String id = UUID.randomUUID().toString();
        fixture.givenNoPriorActivity()
                .when(new CreateAccount(id,account1.getEmail(),account1.getPassword(),account1.getUsername()))
                .expectEvents(new AccountCreated(id,account1.getEmail(),account1.getPassword(),account1.getUsername()));
    }

    @Test
    void CreateAccountFailTest() {
        String id = UUID.randomUUID().toString();
        this.account1.setEmail("asdf");
        fixture.givenNoPriorActivity()
                .when(new CreateAccount(id,account1.getEmail(),account1.getPassword(),account1.getUsername()))
                .expectException(IllegalStateException.class);
    }

    @Test
    void ChangeEmailTest() {
        String id = UUID.randomUUID().toString();
        fixture.givenNoPriorActivity()
                .when(new ChangeEmail(id,account1.getId(),"newEmail@email.nl"))
                .expectEvents(new EmailChanged(id,account1.getId(),"newEmail@email.nl"));
    }

    @Test
    void ChangeEmailFailTest() {
        String id = UUID.randomUUID().toString();
        fixture.givenNoPriorActivity()
                .when(new ChangeEmail(id,account1.getId(),"fail"))
                .expectException(IllegalStateException.class);
    }

    @Test
    void DeleteAccountTest() {
        String id = UUID.randomUUID().toString();
        fixture.givenNoPriorActivity()
                .when(new DeleteAccount(id,account1.getId()))
                .expectEvents(new AccountDeleted(id,account1.getId()));
    }
}
