package upd.accountservice.Services;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import upd.accountservice.Events.*;
import upd.accountservice.Models.Account;
import upd.accountservice.Repo.AccountCrudRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.BDDMockito.*;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
class AccountEventHandlerTest {

    @Mock
    private AccountCrudRepository repository;

    @InjectMocks
    @Spy
    private AccountEventHandler eventHandler;

    private Account account1;
    private Account account2;
    private Account account3;
    private List<Account> accountList;

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);

        this.account1 = new Account("test@test.nl","pass","user1");
        this.account2 = new Account("test2@test.nl","password","user2");
        this.account3 = new Account("test@test.nl","passs","user3");
        accountList = new ArrayList<>();
        accountList.add(account1);
        accountList.add(account2);
        accountList.add(account3);
    }


    @Test
    void injectNotNull() {
        assertNotNull(repository);
        assertNotNull(eventHandler);
    }


    @Test
    void accountCreateTest() {
        //Arrange
        when(eventHandler.getRepository().findAccountByEmail(account1.getEmail())).thenReturn(account1);
        when(eventHandler.getRepository().findAccountByEmail(account2.getEmail())).thenReturn(null);

        //Act
        eventHandler.on(new AccountCreated("1",account1.getEmail(),account1.getPassword(),account1.getUsername()));
        eventHandler.on(new AccountCreated("2",account2.getEmail(),account2.getPassword(),account2.getUsername()));

        //Assert
        verify(eventHandler.getRepository(),times(0)).save(account1);
        verify(eventHandler.getRepository(),times(1)).save(account2);
    }

    @Test
    void accountDeletedTest() {
        //Arrange
        when(eventHandler.getRepository().findById(1)).thenReturn(Optional.of(account1));
        when(eventHandler.getRepository().findById(2)).thenReturn(Optional.empty());
        //Act
        eventHandler.on(new AccountDeleted("1",1));
        eventHandler.on(new AccountDeleted("2",2));
        //Assert
        verify(eventHandler.getRepository(),times(1)).delete(account1);
        verify(eventHandler.getRepository(),times(0)).delete(account2);
    }

    @Test
    void emailChangedTest() {
        //Arrange
        when(eventHandler.getRepository().findById(1)).thenReturn(Optional.of(account1));
        when(eventHandler.getRepository().findById(2)).thenReturn(Optional.empty());
        //Act
        eventHandler.on(new EmailChanged("1",1,"new1@email.nl"));
        eventHandler.on(new EmailChanged("2",2,"new2@email.nl"));
        //Assert
        verify(eventHandler.getRepository(),times(1)).save(account1);
        verify(eventHandler.getRepository(),times(0)).save(account2);
    }

    @Test
    void passwordChangedTest() {
        //Arrange
        when(eventHandler.getRepository().findById(1)).thenReturn(Optional.of(account1));
        when(eventHandler.getRepository().findById(2)).thenReturn(Optional.empty());
        //Act
        eventHandler.on(new PasswordChanged("1",1,"newPassword1"));
        eventHandler.on(new PasswordChanged("2",2,"newPassword2"));
        //Assert
        verify(eventHandler.getRepository(),times(1)).save(account1);
        verify(eventHandler.getRepository(),times(0)).save(account2);
    }

    @Test
    void usernameChangedTest() {
        //Arrange
        when(eventHandler.getRepository().findById(1)).thenReturn(Optional.of(account1));
        when(eventHandler.getRepository().findById(2)).thenReturn(Optional.empty());
        //Act
        eventHandler.on(new UsernameChanged("1",1,"newUsername"));
        eventHandler.on(new UsernameChanged("2",2,"newUsername"));
        //Assert
        verify(eventHandler.getRepository(),times(1)).save(account1);
        verify(eventHandler.getRepository(),times(0)).save(account2);
    }
}
