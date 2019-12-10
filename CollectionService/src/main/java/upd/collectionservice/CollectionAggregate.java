package upd.collectionservice;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.commandhandling.model.AggregateLifecycle;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.factory.annotation.Autowired;
import upd.collectionservice.Commands.AddCardsToCollection;
import upd.collectionservice.Commands.RemoveCardsFromCollection;
import upd.collectionservice.Commands.TradeCards;
import upd.collectionservice.Events.CardsAddedToCollection;
import upd.collectionservice.Events.CardsRemovedCardsFromCollection;
import upd.collectionservice.Events.CardsTraded;

@Aggregate
public class CollectionAggregate {

    @Autowired
    private EventSourcingRepository<CollectionAggregate> repo;

    @AggregateIdentifier
    private String id;

    @CommandHandler
    public CollectionAggregate(AddCardsToCollection command) {
        AggregateLifecycle.apply(
                new CardsAddedToCollection(
                        command.getId(),
                        command.getAccountId(),
                        command.getCards()
                )
        );
    }

    @EventSourcingHandler
    public void on(CardsAddedToCollection event) {
        this.id = event.getId();
    }

    @CommandHandler
    public CollectionAggregate(TradeCards command) {
        AggregateLifecycle.apply(
                new CardsTraded(
                        command.getId(),
                        command.getReceiveAccountId(),
                        command.getSendAccountId(),
                        command.getCards()
                )
        );
    }

    @EventSourcingHandler
    public void on(CardsTraded event) {
        this.id = event.getId();
    }

    @CommandHandler
    public CollectionAggregate(RemoveCardsFromCollection command) {
        AggregateLifecycle.apply(
                new CardsRemovedCardsFromCollection(
                        command.getId(),
                        command.getCards()
                )
        );
    }

    @EventSourcingHandler
    public void on(CardsRemovedCardsFromCollection event) {
        this.id = event.getId();
    }

    protected CollectionAggregate() {}
}
