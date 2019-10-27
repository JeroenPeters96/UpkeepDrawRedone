package upd.deckservice.Controllers.IncomingModels;

import org.axonframework.commandhandling.TargetAggregateIdentifier;
import upd.deckservice.Models.Card;

import java.util.Map;
import java.util.Objects;

public class CreateDeckWithCardsApiModel {
   private final String accountId;
    private final String name;
    private final String description;
    private final Map<Card,Integer> cards;

    public CreateDeckWithCardsApiModel(String accountId, String name, String description, Map<Card, Integer> cards) {
        this.accountId = accountId;
        this.name = name;
        this.description = description;
        this.cards = cards;
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
        return "CreateDeckWithCardsApiModel{" +
                "accountId='" + accountId + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", cards=" + cards +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreateDeckWithCardsApiModel)) return false;
        CreateDeckWithCardsApiModel that = (CreateDeckWithCardsApiModel) o;
        return Objects.equals(accountId, that.accountId) &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description) &&
                Objects.equals(cards, that.cards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, name, description, cards);
    }
}
