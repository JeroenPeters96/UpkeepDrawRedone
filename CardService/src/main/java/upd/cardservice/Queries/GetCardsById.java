package upd.cardservice.Queries;

import java.util.Objects;

public class GetCardsById {

    private final String cardId;

    public GetCardsById(String cardId) {
        this.cardId = cardId;
    }

    public String getCardId() {
        return cardId;
    }

    @Override
    public String toString() {
        return "GetCardsById{" +
                "cardId='" + cardId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetCardsById that = (GetCardsById) o;
        return Objects.equals(getCardId(), that.getCardId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCardId());
    }
}
