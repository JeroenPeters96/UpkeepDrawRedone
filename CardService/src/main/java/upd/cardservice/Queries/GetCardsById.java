package upd.cardservice.Queries;

import upd.cardservice.Models.Card;

import java.util.List;
import java.util.Objects;

public class GetCardsById {

   private final List<Integer> cardIdList;

    public GetCardsById(List<Integer> cardIdList) {
        this.cardIdList = cardIdList;
    }

    public List<Integer> getCardIdList() {
        return cardIdList;
    }

    @Override
    public String toString() {
        return "GetCardsById{" +
                "cardIdList=" + cardIdList +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GetCardsById)) return false;
        GetCardsById that = (GetCardsById) o;
        return Objects.equals(cardIdList, that.cardIdList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardIdList);
    }
}
