package upd.deckservice.Events;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

import java.util.Objects;

public class DeckCreated {
    @TargetAggregateIdentifier
    private final String id;
    private final String deckId;
    private final String accountId;
    private final String name;
    private final String description;
    private final String format;

    public DeckCreated(String id, String deckId, String accountId, String name, String description, String format) {
        this.id = id;
        this.deckId = deckId;
        this.accountId = accountId;
        this.name = name;
        this.description = description;
        this.format = format;
    }

    public String getId() {
        return id;
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

    public String getFormat() {
        return format;
    }

    @Override
    public String toString() {
        return "DeckCreated{" +
                "id='" + id + '\'' +
                ", deckId='" + deckId + '\'' +
                ", accountId='" + accountId + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", format='" + format + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeckCreated that = (DeckCreated) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getDeckId(), that.getDeckId()) &&
                Objects.equals(getAccountId(), that.getAccountId()) &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getDescription(), that.getDescription()) &&
                Objects.equals(getFormat(), that.getFormat());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDeckId(), getAccountId(), getName(), getDescription(), getFormat());
    }
}
