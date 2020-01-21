package upd.deckservice.Services;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upd.deckservice.Models.Deck;
import upd.deckservice.Queries.DecksFromUser;
import upd.deckservice.Queries.FindDeckById;
import upd.deckservice.Queries.FindDecksByLikeName;
import upd.deckservice.Repo.DeckCrudRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeckQueryHandler {

    private final DeckCrudRepository repository;

    public DeckCrudRepository getRepository() {
        return repository;
    }

    @Autowired
    public DeckQueryHandler(DeckCrudRepository repository) {
        this.repository = repository;
    }

    @QueryHandler
    public List<Deck> handle(DecksFromUser query) {
        List<Deck> found = repository.findDecksByAccountId(query.getAccountId());
        if(found==null) {
            return new ArrayList<>();
        }
        return found;
    }

    @QueryHandler
    public Deck handle(FindDeckById query) {
        Deck found = repository.findDeckById(query.getDeckId());
        if(found==null) {
            return null;
        }
        return repository.findDeckById(query.getDeckId());
    }

    @QueryHandler
    public List<Deck> handle(FindDecksByLikeName query) {
        List<Deck> found = repository.findDecksByDecknameContaining(query.getDeckName());
        if(found==null) {
            return new ArrayList<>();
        }
        return repository.findDecksByDecknameContaining(query.getDeckName());
    }
}
