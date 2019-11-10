package upd.deckservice.Commands;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

import java.util.Objects;

public class CreateDeck {

    @TargetAggregateIdentifier
    private final String id;
    private final String deckId;
    private final String accountId;
    private final String name;
    private final String description;

    public CreateDeck(String id, String deckId, String accountId, String name, String description) {
        this.id = id;
        this.deckId = deckId;
        this.accountId = accountId;
        this.name = name;
        this.description = description;
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

    @Override
    public String toString() {
        return "CreateDeck{" +
                "id='" + id + '\'' +
                ", deckId='" + deckId + '\'' +
                ", accountId='" + accountId + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreateDeck)) return false;
        CreateDeck that = (CreateDeck) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(deckId, that.deckId) &&
                Objects.equals(accountId, that.accountId) &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, deckId, accountId, name, description);
    }
}
