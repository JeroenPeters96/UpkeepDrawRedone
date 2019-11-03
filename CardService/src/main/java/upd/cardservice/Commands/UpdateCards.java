package upd.cardservice.Commands;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

import java.util.List;
import java.util.Objects;

public class UpdateCards {
    @TargetAggregateIdentifier
    private final String id;
    private final List<String> cards;

    public UpdateCards(String id, List<String> cards) {
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
        return "GetCards{" +
                "id='" + id + '\'' +
                ", cards=" + cards +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UpdateCards updateCards = (UpdateCards) o;
        return Objects.equals(getId(), updateCards.getId()) &&
                Objects.equals(getCards(), updateCards.getCards());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCards());
    }
}
