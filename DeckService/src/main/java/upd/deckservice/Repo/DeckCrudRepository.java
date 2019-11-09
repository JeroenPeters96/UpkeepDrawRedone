package upd.deckservice.Repo;

import org.springframework.data.repository.CrudRepository;
import upd.deckservice.Models.Deck;

import java.util.List;

public interface DeckCrudRepository extends CrudRepository<Deck,String> {

    List<Deck> findDecksByAccountId(String accountId);
    Deck findDeckById(String deckId);
}
