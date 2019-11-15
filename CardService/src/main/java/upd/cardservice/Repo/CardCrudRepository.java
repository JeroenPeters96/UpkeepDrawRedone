package upd.cardservice.Repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import upd.cardservice.Models.Card;

@Repository
public interface CardCrudRepository  extends CrudRepository<Card,Integer> {
//    @Query("Select a FROM Card WHERE a.cardname= :name")
//    Card findCardByCardname(@Param("name") String Cardname);
//    @Query("Select a FROM Card WHERE a.setId= :setid")
//    Card findCardsBySetName(@Param("setid")String setname);

    Card findCardByCardname(String cardname);
}
