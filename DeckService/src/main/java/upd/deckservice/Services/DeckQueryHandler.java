package upd.deckservice.Services;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upd.deckservice.Repo.DeckCrudRepository;

@Service
public class DeckQueryHandler {

    private final DeckCrudRepository repository;

    @Autowired
    public DeckQueryHandler(DeckCrudRepository repository) {
        this.repository = repository;
    }

}
