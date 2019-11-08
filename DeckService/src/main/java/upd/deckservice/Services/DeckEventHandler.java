package upd.deckservice.Services;


import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upd.deckservice.Events.*;
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

    }

    @EventHandler
    public void on(CardsRemoved event) {

    }

}
