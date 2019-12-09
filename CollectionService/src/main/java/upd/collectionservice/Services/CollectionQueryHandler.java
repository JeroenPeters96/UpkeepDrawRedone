package upd.collectionservice.Services;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upd.collectionservice.Models.CardCollection;
import upd.collectionservice.Queries.CollectionByAccount;
import upd.collectionservice.Repo.CollectionCrudRepo;

import java.util.List;

@Service
public class CollectionQueryHandler {

    private final CollectionCrudRepo repo;

    @Autowired
    public CollectionQueryHandler(final CollectionCrudRepo repo) {
        this.repo = repo;
    }

    @QueryHandler
    public List<CardCollection> on(CollectionByAccount query) {
        return repo.findCardCollectionsByAccountId(query.getAccountId());
    }
}
