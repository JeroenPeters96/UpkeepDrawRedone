package upd.deckservice.Commands;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

import java.util.Objects;

public class DeleteDeck {

    @TargetAggregateIdentifier
    private final String id;
    private final String deckId;

    public DeleteDeck(String id, String deckId) {
        this.id = id;
        this.deckId = deckId;
    }

    public String getId() {
        return id;
    }

    public String getDeckId() {
        return deckId;
    }

    @Override
    public String toString() {
        return "DeleteDeck{" +
                "id='" + id + '\'' +
                ", deckId='" + deckId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DeleteDeck)) return false;
        DeleteDeck that = (DeleteDeck) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(deckId, that.deckId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, deckId);
    }
}
