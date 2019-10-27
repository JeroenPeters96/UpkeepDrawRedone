package upd.deckservice.Events;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

import java.util.Objects;

public class DeckRenamed {
    @TargetAggregateIdentifier
    private final String deckId;
    private final String deckNewName;

    public DeckRenamed(String deckId, String deckNewName) {
        this.deckId = deckId;
        this.deckNewName = deckNewName;
    }

    public String getDeckId() {
        return deckId;
    }

    public String getDeckNewName() {
        return deckNewName;
    }

    @Override
    public String toString() {
        return "DeckRenamed{" +
                "deckId='" + deckId + '\'' +
                ", deckNewName='" + deckNewName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DeckRenamed)) return false;
        DeckRenamed that = (DeckRenamed) o;
        return Objects.equals(deckId, that.deckId) &&
                Objects.equals(deckNewName, that.deckNewName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deckId, deckNewName);
    }
}
