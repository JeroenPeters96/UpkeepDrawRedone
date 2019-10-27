package upd.deckservice.Services;


import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upd.deckservice.Events.*;
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

    }

    @EventHandler
    public void on(DeckDeleted event) {

    }

    @EventHandler
    public void on(DeckRenamed event) {

    }

    @EventHandler
    public void on(CardsAdded event) {

    }

    @EventHandler
    public void on(CardsRemoved event) {

    }

}
