package upd.cardservice.Events;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

import java.util.List;
import java.util.Objects;

public class CardsUpdated {
    @TargetAggregateIdentifier
    private final String id;
    private final List<String> cards;

    public CardsUpdated(String id, List<String> cards) {
        this.id = id;
        this.cards = cards;
    }

    public String getId() {
        return id;
    }

    public List<String> getCards() {
        return cards;
    }

    @Override
    public String toString() {
        return "CardsGotten{" +
                "id='" + id + '\'' +
                ", cards=" + cards +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CardsUpdated that = (CardsUpdated) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getCards(), that.getCards());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCards());
    }
}
