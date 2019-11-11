package upd.cardservice.Repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import upd.cardservice.Models.Card;

@Repository
public interface CardCrudRepository  extends CrudRepository<Card,String> {
    Card findCardByCardname(String cardname);
    Card findCardById(String cardId);
    Card findCardsBySetName(String setname);
}
