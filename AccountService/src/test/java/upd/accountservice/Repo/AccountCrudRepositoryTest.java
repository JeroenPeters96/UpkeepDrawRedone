package upd.accountservice.Repo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import upd.accountservice.Models.Account;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
class AccountCrudRepositoryTest {


    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private AccountCrudRepository repository;

    @Test
    void testImports() {
        assertNotNull(entityManager);
        assertNotNull(repository);
    }

    private Account account1;
    private Account account2;
    private List<Account> accountList;

    @BeforeEach
   void setup() {
        this.account1 = new Account("test@test.nl","pass","user1");
        this.account2 = new Account("test2@test.nl","password","user2");
        accountList = new ArrayList<>();
        accountList.add(account1);
        accountList.add(account2);
    }

    @AfterEach
    void breakdown() {
        repository.deleteAll();
    }

    @Test
    void createAccountTest() {
        //given
        repository.save(account1);
        repository.save(account2);

        Account found = null;

        //when
        if(repository.findById(account1.getId()).isPresent())
            found = repository.findById(account1.getId()).get();

        //then
        assertEquals(account1,found);

        assertNotEquals(account2,found);
    }


    //TODO check email upon api call for registration

    @Test
    void findAccountEmailTest() {
        //given
        repository.save(account1);
        repository.save(account2);
        Account found = null;

        //when
        found = repository.findAccountByEmail("test@test.nl");


        //then
        assertEquals(account1,found);
        assertNotEquals(account2,found);
    }


    @Test
    void findAccountWrongEmailTest() {
        //given
        repository.save(account1);
        repository.save(account2);
        Account found = null;


        //when
        found = repository.findAccountByEmail("123@123.nl");

        //then
        assertNull(found);
    }


    @Test
    void findAccountEmailPasswordTest() {
        //given
        repository.save(account1);
        repository.save(account2);
        Account found = null;

        //when
        found = repository.findAccountByEmailAndPassword("test2@test.nl","password");


        //then
        assertEquals(account2,found);
        assertNotEquals(account1,found);
    }
    @Test
    void findAccountEmailWrongPasswordTest() {
        //given
        repository.save(account1);
        repository.save(account2);
        Account found = null;

        //when
        found = repository.findAccountByEmailAndPassword("test2@test.nl","password11");


        //then
        assertNull(found);
    }

    @Test
    void findAccountWrongEmailPasswordTest() {
        //given
        repository.save(account1);
        repository.save(account2);
        Account found = null;

        //when
        found = repository.findAccountByEmailAndPassword("testasdf@test.nl","password1");


        //then
        assertNull(found);
    }

    @Test
    void findAllTest() {
        repository.save(account1);
        repository.save(account2);
        List<Account> found = new ArrayList<>();

        repository.findAll().forEach(e-> found.add(e));

        assertEquals(accountList,found);
    }
}
