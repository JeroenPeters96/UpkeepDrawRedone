package upd.deckservice.Events;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

import java.util.Objects;

public class DeckDeleted {
    @TargetAggregateIdentifier
    private final String deckId;

    public DeckDeleted(String deckId) {
        this.deckId = deckId;
    }

    public String getDeckId() {
        return deckId;
    }

    @Override
    public String toString() {
        return "DeckDeleted{" +
                "deckId='" + deckId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DeckDeleted)) return false;
        DeckDeleted that = (DeckDeleted) o;
        return Objects.equals(deckId, that.deckId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deckId);
    }
}
