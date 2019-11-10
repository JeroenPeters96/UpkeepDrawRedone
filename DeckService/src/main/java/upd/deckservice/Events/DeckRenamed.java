package upd.deckservice.Events;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

import java.util.Objects;

public class DeckRenamed {
    @TargetAggregateIdentifier
    private final String id;
    private final String deckId;
    private final String deckNewName;

    public DeckRenamed(String id, String deckId, String deckNewName) {
        this.id = id;
        this.deckId = deckId;
        this.deckNewName = deckNewName;
    }

    public String getId() {
        return id;
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
                "id='" + id + '\'' +
                ", deckId='" + deckId + '\'' +
                ", deckNewName='" + deckNewName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeckRenamed that = (DeckRenamed) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getDeckId(), that.getDeckId()) &&
                Objects.equals(getDeckNewName(), that.getDeckNewName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDeckId(), getDeckNewName());
    }
}
