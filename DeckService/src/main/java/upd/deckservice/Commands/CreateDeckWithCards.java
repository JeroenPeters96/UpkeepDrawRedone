package upd.deckservice.Commands;

import org.axonframework.commandhandling.TargetAggregateIdentifier;
import upd.deckservice.Models.Card;

import java.util.Map;
import java.util.Objects;

public class CreateDeckWithCards {

    @TargetAggregateIdentifier
    private final String id;
    private final String deckId;
    private final String accountId;
    private final String name;
    private final String description;
    private final Map<Card,Integer> cards;

    public CreateDeckWithCards(String id, String deckId, String accountId, String name, String description, Map<Card, Integer> cards) {
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
        return "CreateDeckWithCards{" +
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
        if (!(o instanceof CreateDeckWithCards)) return false;
        CreateDeckWithCards that = (CreateDeckWithCards) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(deckId, that.deckId) &&
                Objects.equals(accountId, that.accountId) &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description) &&
                Objects.equals(cards, that.cards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, deckId, accountId, name, description, cards);
    }
}
