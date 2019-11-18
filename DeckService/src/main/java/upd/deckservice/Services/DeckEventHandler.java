package upd.deckservice.Services;


import com.google.common.collect.Maps;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upd.deckservice.Events.*;
import upd.deckservice.Models.CardModel;
import upd.deckservice.Models.Deck;
import upd.deckservice.Repo.DeckCrudRepository;

import java.util.HashMap;
import java.util.Map;

@Service
public class DeckEventHandler {

    private final DeckCrudRepository repository;

    @Autowired
    public DeckEventHandler(final DeckCrudRepository repository) {
        this.repository = repository;
    }

    public DeckCrudRepository getRepository() {
        return repository;
    }

    @EventHandler
    public void on(DeckCreated event) {
        repository.save(new Deck(event));
    }

    @EventHandler
    public void on(DeckCreatedWithCards event) {
        repository.save(new Deck(event));
    }

    @EventHandler
    public void on(DeckDeleted event) {
        if(repository.findById(event.getDeckId()).isPresent()) {
            repository.delete(repository.findById(event.getDeckId()).get());
        }
    }

    @EventHandler
    public void on(DeckRenamed event) {
        if(repository.findById(event.getDeckId()).isPresent()) {
            Deck saved = repository.findById(event.getDeckId()).get();
            saved.setDeckname(event.getDeckNewName());
            repository.save(saved);
        }
    }

    @EventHandler
    public void on(CardsAdded event) {
        boolean cont = false;
        int counter = 0;
        if(repository.findById(event.getDeckId()).isPresent()) {
        Deck deck = repository.findById(event.getDeckId()).get();
        Deck tempDeck = new Deck(deck);
            for(CardModel cardId : event.getCards()) {

                for(CardModel card : tempDeck.getCards()) {

                    if(card.getCardId().equals(cardId.getCardId())) {
                        deck.getCards().get(counter).setCount(deck.getCards().get(counter).getCount()+cardId.getCount());
                        cont=true;
                        break;
                    }
                    counter++;
                }
                if(!cont) {
                    deck.getCards().add(cardId);
                    cont=false;
                }
                counter = 0;
            }
            repository.save(deck);
        }
    }

    @EventHandler
    public void on(CardsRemoved event) {
        int counter = 0;
        if(repository.findById(event.getDeckId()).isPresent()) {
            Deck deck = repository.findById(event.getDeckId()).get();
            Deck tempDeck = new Deck(deck);
            for(CardModel cardId : event.getCards()) {

                for(CardModel card : tempDeck.getCards()) {

                    if(card.getCardId().equals(cardId.getCardId())) {
                        deck.getCards().get(counter).setCount(deck.getCards().get(counter).getCount()-cardId.getCount());
                        if (deck.getCards().get(counter).getCount()<=0) {
                            deck.getCards().remove(counter);
                        }
                        break;
                    }
                    counter++;
                }
                counter = 0;
            }
            repository.save(deck);
        }
    }

    @EventHandler
    public void on(CardArtSet event) {
        Deck deck = repository.findDeckById(event.getDeckId());
        if(deck!=null) {
            deck.setDeckArt(event.getCardId());
            repository.save(deck);
        }
    }

    @EventHandler
    public void on(FormatSaved event) {
        Deck deck = repository.findDeckById(event.getDeckId());
        if(deck!=null) {
            deck.setFormat(event.getFormat());
            repository.save(deck);
        }
    }
}
