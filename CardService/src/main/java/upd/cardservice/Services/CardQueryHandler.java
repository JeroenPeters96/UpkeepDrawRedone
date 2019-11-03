package upd.cardservice.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upd.cardservice.Repo.CardCrudRepository;

@Service
public class CardQueryHandler {

    private final CardCrudRepository repository;

    @Autowired
    public CardQueryHandler(CardCrudRepository repository) {
        this.repository = repository;
    }
}
