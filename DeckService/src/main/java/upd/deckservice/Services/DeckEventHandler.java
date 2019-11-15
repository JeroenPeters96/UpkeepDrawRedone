package upd.deckservice.Services;


import com.google.common.collect.Maps;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upd.deckservice.Events.*;
import upd.deckservice.Models.Card;
import upd.deckservice.Models.Deck;
import upd.deckservice.Repo.DeckCrudRepository;

@Service
public class DeckEventHandler {

    private final DeckCrudRepository repository;

    @Autowired
    public DeckEventHandler(final DeckCrudRepository repository) {
        this.repository = repository;
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
        Deck deck = repository.findDeckById(event.getDeckId());
        if(deck!=null) {
            Maps.difference(event.getCards(),deck.getCards()).entriesOnlyOnLeft().putAll(deck.getCards());
        }
        repository.save(deck);
    }

    @EventHandler
    public void on(CardsRemoved event) {
        Deck deck = repository.findDeckById(event.getDeckId());
        if(deck!=null) {
            for(Card card : deck.getCards().keySet()) {
                if(event.getCards().containsKey(card)) {
                    deck.getCards().replace(card,deck.getCards().get(card));
                }
            }
        }
        repository.save(deck);
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
