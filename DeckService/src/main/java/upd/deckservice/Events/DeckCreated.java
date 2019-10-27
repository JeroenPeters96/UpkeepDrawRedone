package upd.deckservice.Events;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

import java.util.Objects;

public class DeckCreated {
    @TargetAggregateIdentifier
    private final String deckId;
    private final String accountId;
    private final String name;
    private final String description;

    public DeckCreated(String deckId, String accountId, String name, String description) {
        this.deckId = deckId;
        this.accountId = accountId;
        this.name = name;
        this.description = description;
    }

    public String getDeckId() {
        return deckId;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "DeckCreated{" +
                "deckId='" + deckId + '\'' +
                ", accountId='" + accountId + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DeckCreated)) return false;
        DeckCreated that = (DeckCreated) o;
        return Objects.equals(deckId, that.deckId) &&
                Objects.equals(accountId, that.accountId) &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deckId, accountId, name, description);
    }
}
