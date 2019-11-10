package upd.deckservice.Commands;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

import java.util.Objects;

public class RenameDeck {

    @TargetAggregateIdentifier
    private final String id;
    private final String deckId;
    private final String newDeckName;

    public RenameDeck(String id, String deckId, String newDeckName) {
        this.id = id;
        this.deckId = deckId;
        this.newDeckName = newDeckName;
    }

    public String getId() {
        return id;
    }

    public String getDeckId() {
        return deckId;
    }

    public String getNewDeckName() {
        return newDeckName;
    }

    @Override
    public String toString() {
        return "RenameDeck{" +
                "id='" + id + '\'' +
                ", deckId='" + deckId + '\'' +
                ", newDeckName='" + newDeckName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RenameDeck)) return false;
        RenameDeck that = (RenameDeck) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(deckId, that.deckId) &&
                Objects.equals(newDeckName, that.newDeckName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, deckId, newDeckName);
    }
}
