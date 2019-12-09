package upd.collectionservice.Commands;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

public abstract class BaseCommand {
    @TargetAggregateIdentifier
    private final String id;

    public BaseCommand(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
