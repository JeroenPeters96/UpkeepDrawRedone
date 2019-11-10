package upd.deckservice;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.commandhandling.model.AggregateLifecycle;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.factory.annotation.Autowired;
import upd.deckservice.Commands.*;
import upd.deckservice.Events.*;

@Aggregate
public class DeckAggregate {

    @Autowired
    private EventSourcingRepository<DeckAggregate> repo;

    @AggregateIdentifier
    private String id;

    @CommandHandler
    public DeckAggregate(CreateDeck command) {
        //TODO find accountId to check

        AggregateLifecycle.apply(
                new DeckCreated(
                        command.getId(),
                        command.getDeckId(),
                        command.getAccountId(),
                        command.getName(),
                        command.getDescription()
                )
        );
    }

    @EventSourcingHandler
    public void on(DeckCreated event) {
        this.id = event.getId();
    }

    @CommandHandler
    public DeckAggregate(CreateDeckWithCards command) {
        //TODO find accountId to check

        AggregateLifecycle.apply(
                new DeckCreatedWithCards(
                        command.getId(),
                        command.getDeckId(),
                        command.getAccountId(),
                        command.getName(),
                        command.getDescription(),
                        command.getCards()
                )
        );
    }

    @EventSourcingHandler
    public void on(DeckCreatedWithCards event) {
        this.id = event.getId();
    }


    @CommandHandler
    public DeckAggregate(DeleteDeck command) {

        AggregateLifecycle.apply(
                new DeckDeleted(
                        command.getId(),
                        command.getDeckId()
                )
        );
    }

    @EventSourcingHandler
    public void on(DeckDeleted event) {
        this.id = event.getDeckId();
    }

    @CommandHandler
    public DeckAggregate(RenameDeck command) {
        if(command.getNewDeckName().length()<20) {
            AggregateLifecycle.apply(
                    new DeckRenamed(
                            command.getId(),
                            command.getDeckId(),
                            command.getNewDeckName()
                    )
            );
        }
    }

    @EventSourcingHandler
    public void on(DeckRenamed event) {
        this.id = event.getId();
    }

    @CommandHandler
    public DeckAggregate(AddCard command) {
        //TODO check if cards are legit
        AggregateLifecycle.apply(
                new CardsAdded(
                        command.getId(),
                        command.getDeckId(),
                        command.getCards()
                )
        );
    }

    @EventSourcingHandler
    public void on(CardsAdded event) {
        this.id = event.getDeckId();
    }

    @CommandHandler
    public DeckAggregate(RemoveCards command) {
        AggregateLifecycle.apply(
                new CardsRemoved(
                        command.getId(),
                        command.getDeckId(),
                        command.getCards()
                )
        );
    }

    @EventSourcingHandler
    public void on(CardsRemoved event) {
        this.id = event.getId();
    }

    protected DeckAggregate() {}
}


