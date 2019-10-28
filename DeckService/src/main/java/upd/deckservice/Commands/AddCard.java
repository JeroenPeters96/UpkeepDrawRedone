package upd.deckservice.Commands;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

import java.util.Map;
import java.util.Objects;

public class AddCard {
    @TargetAggregateIdentifier
    private final String deckId;
    private final Map<String,Integer> cards;

    public AddCard(String deckId, Map<String,Integer> cards) {
        this.deckId = deckId;
        this.cards = cards;
    }

    public String getDeckId() {
        return deckId;
    }

    public Map<String,Integer> getCards() {
        return cards;
    }

    @Override
    public String toString() {
        return "AddCard{" +
                "deckId='" + deckId + '\'' +
                ", cards=" + cards +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AddCard)) return false;
        AddCard addCard = (AddCard) o;
        return Objects.equals(deckId, addCard.deckId) &&
                Objects.equals(cards, addCard.cards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deckId, cards);
    }
}
