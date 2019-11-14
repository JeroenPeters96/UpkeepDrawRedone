package upd.cardservice.Queries;

import java.util.List;
import java.util.Objects;

public class GetCardsByName {

    private final List<String> cardNames;

    public GetCardsByName(List<String> cardNames) {
        this.cardNames = cardNames;
    }

    public List<String> getCardNames() {
        return cardNames;
    }

    @Override
    public String toString() {
        return "GetCardsByName{" +
                "cardNames=" + cardNames +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GetCardsByName)) return false;
        GetCardsByName that = (GetCardsByName) o;
        return Objects.equals(cardNames, that.cardNames);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardNames);
    }
}
