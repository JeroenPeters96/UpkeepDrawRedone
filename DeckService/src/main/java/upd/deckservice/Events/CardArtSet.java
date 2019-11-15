package upd.deckservice.Events;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

import java.util.Objects;

public class CardArtSet {

    @TargetAggregateIdentifier
    private final String id;
    private final String deckId;
    private final String cardId;

    public CardArtSet(String id, String deckId, String cardId) {
        this.id = id;
        this.deckId = deckId;
        this.cardId = cardId;
    }

    public String getId() {
        return id;
    }

    public String getDeckId() {
        return deckId;
    }

    public String getCardId() {
        return cardId;
    }

    @Override
    public String toString() {
        return "CardArtSet{" +
                "id='" + id + '\'' +
                ", deckId='" + deckId + '\'' +
                ", cardId='" + cardId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CardArtSet that = (CardArtSet) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getDeckId(), that.getDeckId()) &&
                Objects.equals(getCardId(), that.getCardId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDeckId(), getCardId());
    }
}
