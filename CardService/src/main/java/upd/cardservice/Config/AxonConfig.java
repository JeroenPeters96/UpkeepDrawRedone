package upd.cardservice.Config;

import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import upd.cardservice.CardAggregate;


@Configuration
public class AxonConfig {

    @Bean
    EventSourcingRepository<CardAggregate> accountAggregateEventSourcingRepository(EventStore eventStore) {
        EventSourcingRepository<CardAggregate> repository = new EventSourcingRepository<>(CardAggregate.class, eventStore);
        return repository;
    }
}
