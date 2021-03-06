package upd.deckservice.Events;

import org.axonframework.commandhandling.TargetAggregateIdentifier;
import upd.deckservice.Models.CardModel;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class CardsRemoved {
    @TargetAggregateIdentifier
    private final String id;
    private final String deckId;
    private final List<CardModel> cards;

    public CardsRemoved(String id, String deckId, List<CardModel> cards) {
        this.id = id;
        this.deckId = deckId;
        this.cards = cards;
    }

    public String getId() {
        return id;
    }

    public String getDeckId() {
        return deckId;
    }

    public List<CardModel> getCards() {
        return cards;
    }

    @Override
    public String toString() {
        return "CardsRemoved{" +
                "id='" + id + '\'' +
                ", deckId='" + deckId + '\'' +
                ", cards=" + cards +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CardsRemoved that = (CardsRemoved) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getDeckId(), that.getDeckId()) &&
                Objects.equals(getCards(), that.getCards());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDeckId(), getCards());
    }
}
