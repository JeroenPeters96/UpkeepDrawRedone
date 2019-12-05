package upd.cardservice.Queries;

import java.util.Objects;

public class GetCardsLikeName {
    private final String cardName;


    public GetCardsLikeName(String cardName) {
        this.cardName = cardName;
    }

    public String getCardName() {
        return cardName;
    }

    @Override
    public String toString() {
        return "GetCardsLikeName{" +
                "cardName='" + cardName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GetCardsLikeName)) return false;
        GetCardsLikeName that = (GetCardsLikeName) o;
        return Objects.equals(cardName, that.cardName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardName);
    }
}
