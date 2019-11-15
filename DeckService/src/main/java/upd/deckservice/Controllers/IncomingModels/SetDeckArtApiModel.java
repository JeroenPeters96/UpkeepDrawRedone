package upd.deckservice.Controllers.IncomingModels;

import java.util.Objects;

public class SetDeckArtApiModel {
    private final String deckId;
    private final String cardId;

    public SetDeckArtApiModel(String deckId, String cardId) {
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
        return "SetDeckArtApiModel{" +
                "deckId='" + deckId + '\'' +
                ", cardId='" + cardId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SetDeckArtApiModel that = (SetDeckArtApiModel) o;
        return Objects.equals(getDeckId(), that.getDeckId()) &&
                Objects.equals(getCardId(), that.getCardId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDeckId(), getCardId());
    }
}
