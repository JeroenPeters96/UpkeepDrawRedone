package upd.collectionservice.Events;

import upd.collectionservice.Models.CardCollection;

import java.util.List;
import java.util.Objects;

public class CardsRemovedCardsFromCollection extends BaseEvent {
    private final List<CardCollection> cards;

    public CardsRemovedCardsFromCollection(String id, List<CardCollection> cards) {
        super(id);
        this.cards = cards;
    }


    public List<CardCollection> getCards() {
        return cards;
    }

    @Override
    public String toString() {
        return "CardsRemovedCardsFromCollection{" +
                ", cards=" + cards +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CardsRemovedCardsFromCollection that = (CardsRemovedCardsFromCollection) o;
        return Objects.equals(getCards(), that.getCards());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getCards());
    }
}
