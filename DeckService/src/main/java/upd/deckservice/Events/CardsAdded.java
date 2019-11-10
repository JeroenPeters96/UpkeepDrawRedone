package upd.deckservice.Events;

import org.axonframework.commandhandling.TargetAggregateIdentifier;
import upd.deckservice.Models.Card;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class CardsAdded {
    @TargetAggregateIdentifier
    private final String id;
    private final String deckId;
    private final Map<Card,Integer> cards;

    public CardsAdded(String id, String deckId, Map<Card, Integer> cards) {
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

    public Map<Card, Integer> getCards() {
        return cards;
    }

    @Override
    public String toString() {
        return "CardsAdded{" +
                "id='" + id + '\'' +
                ", deckId='" + deckId + '\'' +
                ", cards=" + cards +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CardsAdded that = (CardsAdded) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getDeckId(), that.getDeckId()) &&
                Objects.equals(getCards(), that.getCards());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDeckId(), getCards());
    }
}
