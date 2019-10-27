package upd.deckservice.Commands;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

import java.util.Objects;

public class AddCard {
    @TargetAggregateIdentifier
    private final String deckId;
    private final String cardId;

    public AddCard(String deckId, String cardId) {
        this.deckId = deckId;
        this.cardId = cardId;
    }

    public String getDeckId() {
        return deckId;
    }

    public String getCardId() {
        return cardId;
    }

    @Override
    public String toString() {
        return "AddCard{" +
                "deckId='" + deckId + '\'' +
                ", cardId='" + cardId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AddCard)) return false;
        AddCard addCard = (AddCard) o;
        return Objects.equals(deckId, addCard.deckId) &&
                Objects.equals(cardId, addCard.cardId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deckId, cardId);
    }
}
