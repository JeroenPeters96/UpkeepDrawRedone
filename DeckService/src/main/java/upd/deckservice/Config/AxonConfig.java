package upd.deckservice.Config;

import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import upd.deckservice.DeckAggregate;


@Configuration
public class AxonConfig {

    @Bean
    EventSourcingRepository<DeckAggregate> accountAggregateEventSourcingRepository(EventStore eventStore) {
        EventSourcingRepository<DeckAggregate> repository = new EventSourcingRepository<>(DeckAggregate.class, eventStore);
        return repository;
    }
}
