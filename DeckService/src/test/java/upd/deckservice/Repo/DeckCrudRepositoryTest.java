package upd.deckservice.Repo;

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
import upd.deckservice.Models.CardModel;
import upd.deckservice.Models.Deck;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
class DeckCrudRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private DeckCrudRepository repository;

    private Deck deck1;
    private Deck deck2;
    private Deck deck3;


    @BeforeEach
    void setUp() {
        deck1 = new Deck("1","1","Burn","Burn baby burn","EDH");
        deck2 = new Deck("2","1","Control","No","EDH");
        deck3 = new Deck("3","2","Midrange","Durdle","EDH");
    }

    @AfterEach
    void tearDown() {
        repository.deleteAll();
    }

    @Test
    void testInjects() {
        assertNotNull(entityManager);
        assertNotNull(repository);
    }

    @Test
    void createDeck() {
        //Arrange
        repository.save(deck1);
        repository.save(deck2);

        Deck foundDeck = null;
        Deck foundDeck1 = null;

        //Act
        foundDeck = repository.findDeckById(deck1.getId());
        foundDeck1 = repository.findDeckById(deck2.getId());


        //Assert
        assertNull(repository.findDeckById(deck3.getId()));
        assertEquals(deck1,foundDeck);
        assertEquals(deck2,foundDeck1);
    }

    @Test
    void createDeckWithCards() {

        List<CardModel> cardModels = new ArrayList<>();
        cardModels.add(new CardModel(UUID.randomUUID().toString(),"1",4));
        cardModels.add(new CardModel(UUID.randomUUID().toString(),"2",4));
        cardModels.add(new CardModel(UUID.randomUUID().toString(),"3",4));
        cardModels.add(new CardModel(UUID.randomUUID().toString(),"4",4));
        cardModels.add(new CardModel(UUID.randomUUID().toString(),"5",4));

        deck1.setCards(new ArrayList<>(cardModels));

        repository.save(deck1);

        Deck foundDeck = repository.findDeckById(deck1.getId());


        assertEquals(deck1,foundDeck);
    }

    @Test
    void findDecksByAccountId() {
        //Arrange
        repository.save(deck1);
        repository.save(deck2);
        repository.save(deck3);

        List<Deck> decksToFind = new ArrayList<>();
        decksToFind.add(deck1);
        decksToFind.add(deck2);
        List<Deck> foundDecks = null;
        List<Deck> foundDecks1= null;

        //Act
        foundDecks = repository.findDecksByAccountId("1");
        foundDecks1 = repository.findDecksByAccountId("3");

        //Assert
        assertEquals(decksToFind,foundDecks);
        assertEquals(new ArrayList<Deck>(),foundDecks1);
    }

    @Test
    void findDecksByDecknameContaining() {
        //Arrange
        repository.save(deck1);
        repository.save(deck2);
        repository.save(deck3);

        List<Deck> decksToFind = new ArrayList<>();
        decksToFind.add(deck1);
        decksToFind.add(deck2);
        decksToFind.add(deck3);

        List<Deck> foundDecks = null;

        foundDecks = repository.findDecksByDecknameContaining("r");

        assertEquals(decksToFind,foundDecks);
    }

    @Test
    void deckDelete() {
        repository.save(deck1);

        repository.delete(deck1);

        assertNull(repository.findDeckById(deck1.getId()));
    }

    @Test
    void addCards() {
        repository.save(deck1);

        Deck foundDeck = repository.findDeckById(deck1.getId());

        List<CardModel> cardModels = new ArrayList<>();
        cardModels.add(new CardModel(UUID.randomUUID().toString(),"1",4));


        deck1.setCards(new ArrayList<>(cardModels));
        foundDeck.setCards(new ArrayList<>(cardModels));
        repository.save(foundDeck);

        assertEquals(deck1,repository.findDeckById(foundDeck.getId()));
    }

    @Test
    void removeCards() {
        repository.save(deck1);

        Deck foundDeck = repository.findDeckById(deck1.getId());

        List<CardModel> cardModels = new ArrayList<>();
        cardModels.add(new CardModel(UUID.randomUUID().toString(),"1",4));
        cardModels.add(new CardModel(UUID.randomUUID().toString(),"2",4));
        cardModels.add(new CardModel(UUID.randomUUID().toString(),"3",4));
        cardModels.add(new CardModel(UUID.randomUUID().toString(),"4",4));
        cardModels.add(new CardModel(UUID.randomUUID().toString(),"5",4));


        deck1.setCards(new ArrayList<>(cardModels));
        foundDeck.setCards(new ArrayList<>(cardModels));

        deck1.getCards().remove(0);
        foundDeck.getCards().remove(0);

        repository.save(foundDeck);

        assertEquals(deck1,repository.findDeckById(foundDeck.getId()));
    }
}