package upd.deckservice;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.commandhandling.model.AggregateLifecycle;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.factory.annotation.Autowired;
import upd.deckservice.Commands.*;
import upd.deckservice.Events.DeckCreated;
import upd.deckservice.Events.DeckDeleted;

@Aggregate
public class DeckAggregate {

    @Autowired
    private EventSourcingRepository<DeckAggregate> repo;



    @AggregateIdentifier
    private String deckId;

    @CommandHandler
    public DeckAggregate(CreateDeck command) {
        //TODO find accountId to check

        AggregateLifecycle.apply(
                new DeckCreated(
                        command.getDeckId(),
                        command.getAccountId(),
                        command.getName(),
                        command.getDescription()
                )
        );
    }

    @CommandHandler
    public DeckAggregate(DeleteDeck command) {


        AggregateLifecycle.apply(
                new DeckDeleted(
                        command.getDeckId()
                )
        );
    }

    @CommandHandler
    public DeckAggregate(RenameDeck command) {

    }

    @CommandHandler
    public DeckAggregate(AddCard command) {

    }

    @CommandHandler
    public DeckAggregate(RemoveCards command) {

    }
}


