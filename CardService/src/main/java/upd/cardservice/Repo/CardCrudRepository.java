package upd.cardservice.Repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import upd.cardservice.Models.Card;

@Repository
public interface CardCrudRepository  extends CrudRepository<Card,String> {
}
