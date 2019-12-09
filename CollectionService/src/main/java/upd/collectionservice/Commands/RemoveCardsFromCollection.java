package upd.collectionservice.Commands;

import upd.collectionservice.Models.CardCollection;

import java.util.List;
import java.util.Objects;

public class RemoveCardsFromCollection extends BaseCommand {

    private final List<CardCollection> cards;

    public RemoveCardsFromCollection(String id, List<CardCollection> cards) {
        super(id);
        this.cards = cards;
    }


    public List<CardCollection> getCards() {
        return cards;
    }

    @Override
    public String toString() {
        return "RemoveCardsFromCollection{" +
                ", cards=" + cards +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RemoveCardsFromCollection that = (RemoveCardsFromCollection) o;
        return Objects.equals(getCards(), that.getCards());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCards());
    }
}
