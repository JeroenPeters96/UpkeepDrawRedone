package upd.deckservice.Controllers.IncomingModels;

import java.util.Objects;

public class CardModelApiModel {
    private String cardId;
    private int count;

    public CardModelApiModel(String cardId, int count) {
        this.cardId = cardId;
        this.count = count;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "CardModelApiModel{" +
                "cardId='" + cardId + '\'' +
                ", count=" + count +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CardModelApiModel that = (CardModelApiModel) o;
        return getCount() == that.getCount() &&
                Objects.equals(getCardId(), that.getCardId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCardId(), getCount());
    }
}
