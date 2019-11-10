package upd.deckservice.Events;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

import java.util.Objects;

public class DeckDeleted {
    @TargetAggregateIdentifier
    private final String id;
    private final String deckId;

    public DeckDeleted(String id, String deckId) {
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
        return "DeckDeleted{" +
                "id='" + id + '\'' +
                ", deckId='" + deckId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeckDeleted that = (DeckDeleted) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getDeckId(), that.getDeckId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDeckId());
    }
}
