package upd.collectionservice;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
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

    }

    @EventSourcingHandler
    public void on(CardsAddedToCollection event) {

    }

    @CommandHandler
    public CollectionAggregate(TradeCards command) {

    }

    @EventSourcingHandler
    public void on(CardsTraded event) {

    }

    @CommandHandler
    public CollectionAggregate(RemoveCardsFromCollection command) {

    }

    @EventSourcingHandler
    public void on(CardsRemovedCardsFromCollection event) {

    }

    protected CollectionAggregate() {}
}
