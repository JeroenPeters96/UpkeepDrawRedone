package upd.deckservice.Controllers.IncomingModels;

import java.util.Objects;

public class AddCardApiModel {
    private final String cardId;
    private final String deckId;

    public AddCardApiModel(String cardId, String deckId) {
        this.cardId = cardId;
        this.deckId = deckId;
    }

    public String getCardId() {
        return cardId;
    }

    public String getDeckId() {
        return deckId;
    }

    @Override
    public String toString() {
        return "AddCardApiModel{" +
                "cardId='" + cardId + '\'' +
                ", deckId='" + deckId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AddCardApiModel)) return false;
        AddCardApiModel that = (AddCardApiModel) o;
        return Objects.equals(cardId, that.cardId) &&
                Objects.equals(deckId, that.deckId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardId, deckId);
    }
}
