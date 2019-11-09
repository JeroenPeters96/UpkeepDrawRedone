package upd.deckservice.Commands;

import org.axonframework.commandhandling.TargetAggregateIdentifier;
import upd.deckservice.Models.Card;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class RemoveCards {
    @TargetAggregateIdentifier
    private final String deckId;
    private final Map<Card,Integer> cards;

    public RemoveCards(String deckId, Map<Card,Integer> cards) {
        this.deckId = deckId;
        this.cards = cards;
    }

    public String getDeckId() {
        return deckId;
    }

    public Map<Card,Integer> getCards() {
        return cards;
    }

    @Override
    public String toString() {
        return "RemoveCards{" +
                "deckId='" + deckId + '\'' +
                ", cards=" + cards +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RemoveCards)) return false;
        RemoveCards that = (RemoveCards) o;
        return Objects.equals(deckId, that.deckId) &&
                Objects.equals(cards, that.cards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deckId, cards);
    }
}
