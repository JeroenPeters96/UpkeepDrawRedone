package upd.deckservice.Controllers.IncomingModels;

import java.util.Map;
import java.util.Objects;

public class AddCardApiModel {
    private final Map<String,Integer> cards;
    private final String deckId;

    public AddCardApiModel(Map<String,Integer> cardId, String deckId) {
        this.cards = cardId;
        this.deckId = deckId;
    }

    public Map<String,Integer> getCards() {
        return cards;
    }

    public String getDeckId() {
        return deckId;
    }

    @Override
    public String toString() {
        return "AddCardApiModel{" +
                "cards='" + cards + '\'' +
                ", deckId='" + deckId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AddCardApiModel)) return false;
        AddCardApiModel that = (AddCardApiModel) o;
        return Objects.equals(cards, that.cards) &&
                Objects.equals(deckId, that.deckId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cards, deckId);
    }
}
