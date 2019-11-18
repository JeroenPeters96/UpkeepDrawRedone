package upd.deckservice.Services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import upd.deckservice.Models.Deck;
import upd.deckservice.Queries.DecksFromUser;
import upd.deckservice.Queries.FindDeckById;
import upd.deckservice.Queries.FindDecksByLikeName;
import upd.deckservice.Repo.DeckCrudRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;

class DeckQueryHandlerTest {

    @Mock
    private DeckCrudRepository repository;

    @InjectMocks
    @Spy
    private DeckQueryHandler queryHandler;

    private Deck deck1;
    private Deck deck2;
    private Deck deck3;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        deck1 = new Deck("1", "1", "Burn", "Burn baby burn", "EDH");
        deck2 = new Deck("2", "1", "Control", "No", "EDH");
        deck3 = new Deck("3", "2", "Midrange", "Durdle", "EDH");
    }


    @Test
    void injectNotNull() {
        assertNotNull(repository);
        assertNotNull(queryHandler);
    }

    @Test
    void decksFromUserTest() {
        //Arrange
        List<Deck> decksFromUser = new ArrayList<>();
        decksFromUser.add(deck1);
        decksFromUser.add(deck2);
        when(queryHandler.getRepository().findDecksByAccountId("1")).thenReturn(decksFromUser);
        //Act
       List<Deck> foundDecks = queryHandler.handle(new DecksFromUser("1"));
        //Assert
        assertEquals(decksFromUser,foundDecks);
    }

    @Test
    void findDeckByIdTest() {
        //Arrange
        when(queryHandler.getRepository().findDeckById("1")).thenReturn(deck1);
        //Act
        Deck foundDeck = queryHandler.handle(new FindDeckById("1"));
        //Assert
        assertEquals(deck1,foundDeck);
    }

    @Test
    void findDecksByLikeNameTest() {
        //Arrange
        List<Deck> decksToFind = new ArrayList<>();
        decksToFind.add(deck1);
        when(queryHandler.getRepository().findDecksByDecknameContaining("Burn")).thenReturn(decksToFind);
        //Act
        List<Deck> foundDecks = queryHandler.handle(new FindDecksByLikeName("Burn"));
        //Assert
        assertEquals(decksToFind,foundDecks);
    }
}