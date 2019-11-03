package upd.cardservice.Services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import upd.cardservice.Controllers.CardCommandController;
import upd.cardservice.Models.Card;
import upd.cardservice.Repo.CardCrudRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@ActiveProfiles("test")
class CardQueryHandlerImplTest {

    @MockBean
    private CardCrudRepository cardCrudRepository;

    @InjectMocks
    private CardEventHandlerImpl cardEventHandler = new CardEventHandlerImpl();

    @BeforeEach
    void setup() {
        Card card = new Card("12345");


        when(cardCrudRepository.findById("12345")).thenReturn(Optional.of(card));
    }

    @Test
    void notNullInjects() {
        assertNotNull(cardEventHandler);
        assertNotNull(cardCrudRepository);
    }

}