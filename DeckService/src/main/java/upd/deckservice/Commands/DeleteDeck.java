package upd.deckservice.Commands;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

import java.util.Objects;

public class DeleteDeck {
    @TargetAggregateIdentifier
    private final String deckId;

    public DeleteDeck(String deckId) {
        this.deckId = deckId;
    }

    public String getDeckId() {
        return deckId;
    }

    @Override
    public String toString() {
        return "DeleteDeck{" +
                "deckId='" + deckId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DeleteDeck)) return false;
        DeleteDeck that = (DeleteDeck) o;
        return Objects.equals(deckId, that.deckId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deckId);
    }
}
