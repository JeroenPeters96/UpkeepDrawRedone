package upd.deckservice.Commands;

import org.axonframework.commandhandling.TargetAggregateIdentifier;
import upd.deckservice.Models.CardModel;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class AddCard {

    @TargetAggregateIdentifier
    private String id;
    private String deckId;
    private List<CardModel> cards;

    public AddCard() {
    }

    public AddCard(String id, String deckId, List<CardModel> cards) {
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
        return "AddCard{" +
                "id='" + id + '\'' +
                ", deckId='" + deckId + '\'' +
                ", cards=" + cards +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AddCard)) return false;
        AddCard addCard = (AddCard) o;
        return Objects.equals(id, addCard.id) &&
                Objects.equals(deckId, addCard.deckId) &&
                Objects.equals(cards, addCard.cards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, deckId, cards);
    }
}
