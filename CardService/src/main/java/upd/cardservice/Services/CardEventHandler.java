package upd.cardservice.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upd.cardservice.Repo.CardCrudRepository;

@Service
public class CardEventHandler {
    @Autowired
    private CardCrudRepository repository;

    @Autowired
    private CardEventHandler(final CardCrudRepository repository) {
        this.repository = repository;
    }

    public CardEventHandler() {
    }


}
