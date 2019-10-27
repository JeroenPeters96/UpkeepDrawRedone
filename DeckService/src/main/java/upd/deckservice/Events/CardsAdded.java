package upd.deckservice.Events;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

import java.util.List;
import java.util.Objects;

public class CardsAdded {
    @TargetAggregateIdentifier
    private final String deckId;
    private final List<String> cards;

    public CardsAdded(String deckId, List<String> cards) {
        this.deckId = deckId;
        this.cards = cards;
    }

    public String getDeckId() {
        return deckId;
    }

    public List<String> getCards() {
        return cards;
    }

    @Override
    public String toString() {
        return "CardsAdded{" +
                "deckId='" + deckId + '\'' +
                ", cards=" + cards +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CardsAdded)) return false;
        CardsAdded that = (CardsAdded) o;
        return Objects.equals(deckId, that.deckId) &&
                Objects.equals(cards, that.cards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deckId, cards);
    }
}
