package upd.collectionservice.Repo;

import org.springframework.data.repository.CrudRepository;
import upd.collectionservice.Models.CardCollection;

import java.util.List;

public interface CollectionCrudRepo extends CrudRepository<CardCollection,Integer> {

    List<CardCollection> findCardCollectionsByCardIdAndAccountId(String cardId, String accountId);
    CardCollection findCardCollectionByAccountIdAndCardId(String cardId, String accountId);
    List<CardCollection> findCardCollectionsByAccountId(String accountId);

    void deleteByAccountIdAndCardId(String accountId, String cardId);
}
