package upd.cardservice.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upd.cardservice.Repo.CardCrudRepository;

@Service
public class CardQueryHandlerImpl {

    private CardCrudRepository repository;

    @Autowired
    public CardQueryHandlerImpl(CardCrudRepository repository) {
        this.repository = repository;
    }

    public CardQueryHandlerImpl() {
    }
}
