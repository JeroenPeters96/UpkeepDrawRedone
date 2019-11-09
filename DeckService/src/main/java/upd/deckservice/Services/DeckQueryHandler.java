package upd.deckservice.Services;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upd.deckservice.Models.Deck;
import upd.deckservice.Queries.DecksFromUser;
import upd.deckservice.Queries.FindDeckById;
import upd.deckservice.Repo.DeckCrudRepository;

import java.util.List;

@Service
public class DeckQueryHandler {

    private final DeckCrudRepository repository;

    @Autowired
    public DeckQueryHandler(DeckCrudRepository repository) {
        this.repository = repository;
    }

    @QueryHandler
    public List<Deck> handle(DecksFromUser query) {
        return repository.findDecksByAccountId(query.getAccountId());
    }

    @QueryHandler
    public Deck handle(FindDeckById query) {
       return repository.findDeckById(query.getDeckId());
    }
}
