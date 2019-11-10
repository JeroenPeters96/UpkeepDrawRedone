package upd.deckservice.Events;

import org.axonframework.commandhandling.TargetAggregateIdentifier;
import upd.deckservice.Commands.CreateDeckWithCards;
import upd.deckservice.Models.Card;

import java.util.Map;
import java.util.Objects;

public class DeckCreatedWithCards {
    @TargetAggregateIdentifier
    private final String id;
    private final String deckId;
    private final String accountId;
    private final String name;
    private final String description;
    private final Map<Card, Integer> cards;

    public DeckCreatedWithCards(String id, String deckId, String accountId, String name, String description, Map<Card, Integer> cards) {
        this.id = id;
        this.deckId = deckId;
        this.accountId = accountId;
        this.name = name;
        this.description = description;
        this.cards = cards;
    }

    public String getId() {
        return id;
    }

    public String getDeckId() {
        return deckId;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Map<Card, Integer> getCards() {
        return cards;
    }

    @Override
    public String toString() {
        return "DeckCreatedWithCards{" +
                "id='" + id + '\'' +
                ", deckId='" + deckId + '\'' +
                ", accountId='" + accountId + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", cards=" + cards +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeckCreatedWithCards that = (DeckCreatedWithCards) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getDeckId(), that.getDeckId()) &&
                Objects.equals(getAccountId(), that.getAccountId()) &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getDescription(), that.getDescription()) &&
                Objects.equals(getCards(), that.getCards());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDeckId(), getAccountId(), getName(), getDescription(), getCards());
    }
}
