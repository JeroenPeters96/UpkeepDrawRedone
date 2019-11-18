package upd.deckservice.Services;

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
import upd.deckservice.Events.*;
import upd.deckservice.Models.CardModel;
import upd.deckservice.Models.Deck;
import upd.deckservice.Repo.DeckCrudRepository;

import java.util.*;

import static org.mockito.BDDMockito.*;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
class DeckEventHandlerTest {

    @Mock
    private DeckCrudRepository repository;

    @InjectMocks
    @Spy
    private DeckEventHandler eventHandler;

    private String card1;
    private String card2;
    private String card3;
    private String card4;
    private String card5;

    private Deck deck1;
    private Deck deck2;
    private Deck deck3;

    List<String> cards;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        card1 = "1";
        card2 = "2";
        card3 = "3";
        card4 = "4";
        card5 = "5";

        cards = new ArrayList<>();
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);


        deck1 = new Deck("1", "1", "Burn", "Burn baby burn", "EDH");
        deck2 = new Deck("2", "1", "Control", "No", "EDH");
        deck3 = new Deck("3", "2", "Midrange", "Durdle", "EDH");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void injectNotNull() {
        assertNotNull(repository);
        assertNotNull(eventHandler);
    }

    @Test
    void createDeckTest() {
        //Arrange

        //Act
        eventHandler.on(new DeckCreated("1",deck1.getId(),deck1.getAccountId(),deck1.getDeckname(), deck1.getDescription(),deck1.getFormat()));
        //Assert
        verify(eventHandler.getRepository(),times(1)).save(deck1);
    }

    @Test
    void createDeckWithCardsTest() {
        //Arrange
        List<CardModel> cardModels = new ArrayList<>();
        cardModels.add(new CardModel(UUID.randomUUID().toString(),"1",4));
        cardModels.add(new CardModel(UUID.randomUUID().toString(),"2",4));
        cardModels.add(new CardModel(UUID.randomUUID().toString(),"3",4));

        deck1.setCards(cardModels);
        //Act
        eventHandler.on(new DeckCreatedWithCards("1",deck1.getId(),deck1.getAccountId(),deck1.getDeckname(), deck1.getDescription(),deck1.getFormat(),deck1.getDeckArt(),deck1.getCards()));
        //Assert
        verify(eventHandler.getRepository(),times(1)).save(deck1);
    }

    @Test
    void deleteDeckTest() {
        //Arrange
        when(eventHandler.getRepository().findById(deck1.getId())).thenReturn(Optional.of(deck1));
        //Act
        eventHandler.on(new DeckDeleted("1",deck1.getId()));
        //Assert
        verify(eventHandler.getRepository(),times(1)).delete(deck1);
    }

    @Test
    void renameDeckTest() {
        //Arrange
        when(eventHandler.getRepository().findById(deck1.getId())).thenReturn(Optional.of(deck1));
        //Act
        eventHandler.on(new DeckRenamed("1",deck1.getId(),"test"));
        deck1.setDeckname("test");
        //Assert
        verify(eventHandler.getRepository(),times(1)).save(deck1);
    }


    @Test
    void cardsAddedTest() {
        //Arrange
        List<CardModel> cardModels = new ArrayList<>();
        cardModels.add(new CardModel(UUID.randomUUID().toString(),"2",4));

        deck1.setCards(new ArrayList<>(cardModels));
        System.out.println(deck1);
        when(eventHandler.getRepository().findById(deck1.getId())).thenReturn(Optional.of(deck1));
        //Act
        eventHandler.on(new CardsAdded("1",deck1.getId(), new ArrayList<>(cardModels)));
        for(CardModel cardId : cardModels) {
            deck1.getCards().add(cardId);
        }
        //Assert
        verify(eventHandler.getRepository(),times(1)).save(deck1);
    }


    @Test
    void cardsRemoveTest() {
        //Arrange
        List<CardModel> cardModels = new ArrayList<>();
        cardModels.add(new CardModel(UUID.randomUUID().toString(),"1",4));
        cardModels.add(new CardModel(UUID.randomUUID().toString(),"2",4));
        cardModels.add(new CardModel(UUID.randomUUID().toString(),"3",4));
        cardModels.add(new CardModel(UUID.randomUUID().toString(),"4",4));
        cardModels.add(new CardModel(UUID.randomUUID().toString(),"5",4));

        deck1.setCards(new ArrayList<>(cardModels));
        cardModels.remove(2);
        cardModels.remove(3);
        when(eventHandler.getRepository().findById(deck1.getId())).thenReturn(Optional.of(deck1));
        //Act
        eventHandler.on(new CardsRemoved("1",deck1.getId(), cardModels));

        List<CardModel> newList = new ArrayList<>();
        newList.add(new CardModel(UUID.randomUUID().toString(),"2",4));
        newList.add(new CardModel(UUID.randomUUID().toString(),"4",4));
        deck1.setCards(new ArrayList<>(newList));
        //Assert
        verify(eventHandler.getRepository(),times(1)).save(deck1);
    }
}