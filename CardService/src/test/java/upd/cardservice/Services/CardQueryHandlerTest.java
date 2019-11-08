package upd.cardservice.Services;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import upd.cardservice.Models.Card;
import upd.cardservice.Repo.CardCrudRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles("test")
class CardQueryHandlerTest {

    @MockBean
    private CardCrudRepository cardCrudRepository;

    @InjectMocks
    private CardEventHandler cardEventHandler = new CardEventHandler();

    @Test
    void notNullInjects() {
        assertNotNull(cardEventHandler);
        assertNotNull(cardCrudRepository);
    }

    @Test
    void whenFindById_ReturnCard() {
        //given
        Card card = new Card("12345");

        //when
        when(cardCrudRepository.findById("12345")).thenReturn(Optional.of(card));

        //then
//        assertThat(cardEventHandler.on();)
    }

}
