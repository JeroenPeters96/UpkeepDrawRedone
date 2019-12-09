package upd.collectionservice.Events;

import upd.collectionservice.Models.CardCollection;

import java.util.List;
import java.util.Objects;

public class CardsAddedToCollection extends BaseEvent {
    private final String accountId;
    private final List<CardCollection> cards;

    public CardsAddedToCollection(String id, String accountId, List<CardCollection> cards) {
        super(id);
        this.accountId = accountId;
        this.cards = cards;
    }

    public String getAccountId() {
        return accountId;
    }

    public List<CardCollection> getCards() {
        return cards;
    }

    @Override
    public String toString() {
        return "CardsAddedToCollection{" +
                "accountId='" + accountId + '\'' +
                ", cards=" + cards +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CardsAddedToCollection that = (CardsAddedToCollection) o;
        return Objects.equals(getAccountId(), that.getAccountId()) &&
                Objects.equals(getCards(), that.getCards());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getAccountId(), getCards());
    }
}
