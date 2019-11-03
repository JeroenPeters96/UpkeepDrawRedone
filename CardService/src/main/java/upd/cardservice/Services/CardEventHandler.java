package upd.cardservice.Services;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upd.cardservice.Events.CardsUpdated;
import upd.cardservice.Repo.CardCrudRepository;

@Service
public class CardEventHandler {
    private final CardCrudRepository repository;

    @Autowired
    private CardEventHandler(final CardCrudRepository repository) {
        this.repository = repository;
    }

    @EventHandler
    public void on(CardsUpdated event) {

    }
}
