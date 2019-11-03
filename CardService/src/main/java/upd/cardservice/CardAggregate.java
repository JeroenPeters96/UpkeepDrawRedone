package upd.cardservice;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.commandhandling.model.AggregateLifecycle;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.factory.annotation.Autowired;
import upd.cardservice.Commands.UpdateCards;
import upd.cardservice.Events.CardsUpdated;

@Aggregate
public class CardAggregate {

    @Autowired
    private EventSourcingRepository<CardAggregate> repo;

    @AggregateIdentifier
    private String Id;

    @CommandHandler
    public CardAggregate(UpdateCards command) {
        AggregateLifecycle.apply(
                new CardsUpdated(
                        command.getId(),
                        command.getCards()
                ));
    }

    @EventSourcingHandler
    public void on(CardsUpdated event) {
        this.Id = event.getId();
    }

    protected CardAggregate() {}
}
