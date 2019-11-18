package upd.accountservice.Services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import upd.accountservice.Models.Account;
import upd.accountservice.Queries.FindAccountByEmail;
import upd.accountservice.Queries.FindAccountById;
import upd.accountservice.Queries.FindAllAccounts;
import upd.accountservice.Queries.Login;
import upd.accountservice.Repo.AccountCrudRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.BDDMockito.*;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@DataJpaTest
class AccountQueryHandlerTest {

    @Mock
    private AccountCrudRepository repository;

    @InjectMocks
    @Spy
    private AccountQueryHandler queryHandler;

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
        assertNotNull(queryHandler);
    }

    @Test
    void findAllAccountsTest() {
        //Arrange
         when(queryHandler.getRepository().findAll()).thenReturn(accountList);
        //Act
        List<Account> foundAccounts = queryHandler.handle(new FindAllAccounts());
        //Assert
        assertEquals(accountList,foundAccounts);
    }

    @Test
    void findAccountById() {
        //Arrange
        when(queryHandler.getRepository().findById(1)).thenReturn(Optional.of(account1));
        when(queryHandler.getRepository().findById(2)).thenReturn(Optional.of(account2));
        when(queryHandler.getRepository().findById(3)).thenReturn(Optional.empty());
        //Act
        Account found1 = queryHandler.handle(new FindAccountById(1));
        Account found2 = queryHandler.handle(new FindAccountById(2));
        Account found3 = queryHandler.handle(new FindAccountById(3));
        //Assert
        assertEquals(account1,found1);
        assertEquals(account2,found2);
        assertNull(found3);
    }

    @Test
    void findAccountByEmail() {
        //Arrange
        when(queryHandler.getRepository().findAccountByEmail(account1.getEmail())).thenReturn(account1);
        when(queryHandler.getRepository().findAccountByEmail(account2.getEmail())).thenReturn(account2);
        when(queryHandler.getRepository().findAccountByEmail("")).thenReturn(null);
        //Act
        Account found1 = queryHandler.handle(new FindAccountByEmail(account1.getEmail()));
        Account found2 = queryHandler.handle(new FindAccountByEmail(account2.getEmail()));
        Account found3 = queryHandler.handle(new FindAccountByEmail(""));
        //Assert
        assertEquals(account1,found1);
        assertEquals(account2,found2);
        assertNull(found3);
    }

    @Test
    void loginTest() {
        //Arrange
        when(queryHandler.getRepository().findAccountByEmailAndPassword(account1.getEmail(),account1.getPassword())).thenReturn(account1);
        when(queryHandler.getRepository().findAccountByEmailAndPassword(account2.getEmail(),account2.getPassword())).thenReturn(account2);
        when(queryHandler.getRepository().findAccountByEmailAndPassword("","")).thenReturn(null);
        when(queryHandler.getRepository().findAccountByEmailAndPassword(account3.getEmail(),"")).thenReturn(null);
        when(queryHandler.getRepository().findAccountByEmailAndPassword("",account3.getPassword())).thenReturn(null);
        //Act
        Account found1 = queryHandler.handle(new Login(account1.getEmail(),account1.getPassword()));
        Account found2 = queryHandler.handle(new Login(account2.getEmail(),account2.getPassword()));
        Account found3 = queryHandler.handle(new Login("",""));
        Account found4 = queryHandler.handle(new Login(account3.getEmail(),""));
        Account found5 = queryHandler.handle(new Login("",account3.getPassword()));
        //Assert
        assertEquals(account1,found1);
        assertEquals(account2,found2);
        assertNull(found3);
        assertNull(found4);
        assertNull(found5);
    }
}
