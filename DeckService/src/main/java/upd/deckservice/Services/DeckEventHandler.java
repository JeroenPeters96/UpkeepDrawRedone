package upd.deckservice.Services;


import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upd.deckservice.Repo.DeckCrudRepository;

@Service
public class DeckEventHandler {

    private final DeckCrudRepository repository;

    @Autowired
    public DeckEventHandler(final DeckCrudRepository repository) {
        this.repository = repository;
    }


}
