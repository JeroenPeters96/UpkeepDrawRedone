package upd.collectionservice.Commands;

import upd.collectionservice.Models.CardCollection;

import java.util.List;
import java.util.Objects;

public class AddCardsToCollection extends BaseCommand {
    private final String accountId;
    private final List<CardCollection> cards;

    public AddCardsToCollection(String id, String accountId, List<CardCollection> cards) {
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
        return "AddCardsToCollection{" +
                "accountId='" + accountId + '\'' +
                ", cards=" + cards +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddCardsToCollection that = (AddCardsToCollection) o;
        return Objects.equals(getAccountId(), that.getAccountId()) &&
                Objects.equals(getCards(), that.getCards());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAccountId(), getCards());
    }
}
