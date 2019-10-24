package upd.deckservice.Repo;

import org.springframework.data.repository.CrudRepository;
import upd.deckservice.Models.Deck;

public interface DeckCrudRepository extends CrudRepository<Deck,String> {
}
