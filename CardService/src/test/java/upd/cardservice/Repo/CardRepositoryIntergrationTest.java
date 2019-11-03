package upd.cardservice.Repo;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.jupiter.api.Test;
import upd.cardservice.Models.Card;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@DataJpaTest
class CardRepositoryIntergrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CardCrudRepository cardCrudRepository;

    @Test
    void notNullInjects() {
        assertNotNull(entityManager);
        assertNotNull(cardCrudRepository);
    }

    @Test
    void whenFindById_ThenReturnCards() {
        //given
        Card card= new Card("12345");
        entityManager.persist(card);
        entityManager.flush();

        //when
        Card found = cardCrudRepository.findById("12345").get();

        //then
        assertThat(found)
                .isEqualTo(card);
    }
}