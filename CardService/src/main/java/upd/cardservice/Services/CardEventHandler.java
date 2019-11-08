package upd.cardservice.Services;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upd.cardservice.Events.CardsUpdated;
import upd.cardservice.Models.Card;
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

    @EventHandler
    public void on(CardsUpdated event) {
        for (String card : event.getCards()){
            repository.save(new Card(card));
        }
    }
}
