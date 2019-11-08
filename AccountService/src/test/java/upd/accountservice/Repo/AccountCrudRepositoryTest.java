package upd.accountservice.Repo;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@DataJpaTest
class AccountCrudRepositoryTest {


    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private AccountCrudRepository repository;



}
