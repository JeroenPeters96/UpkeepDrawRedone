package upd.collectionservice.Config;

import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import upd.collectionservice.CollectionAggregate;


@Configuration
public class AxonConfig {

    @Bean
    EventSourcingRepository<CollectionAggregate> accountAggregateEventSourcingRepository(EventStore eventStore) {
        EventSourcingRepository<CollectionAggregate> repository = new EventSourcingRepository<>(CollectionAggregate.class, eventStore);
        return repository;
    }
}
