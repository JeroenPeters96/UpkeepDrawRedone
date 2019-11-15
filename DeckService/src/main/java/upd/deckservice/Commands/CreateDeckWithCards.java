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
    private final String format;
    private final String cardArt;

    public CreateDeckWithCards(String id, String deckId, String accountId, String name, String description, Map<Card, Integer> cards, String format,String cardArt) {
        this.id = id;
        this.deckId = deckId;
        this.accountId = accountId;
        this.name = name;
        this.description = description;
        this.cards = cards;
        this.format = format;
        this.cardArt = cardArt;
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

    public String getFormat() {
        return format;
    }

    public String getCardArt() {
        return cardArt;
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
                ", format='" + format + '\'' +
                ", cardArt='" + cardArt + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateDeckWithCards that = (CreateDeckWithCards) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getDeckId(), that.getDeckId()) &&
                Objects.equals(getAccountId(), that.getAccountId()) &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getDescription(), that.getDescription()) &&
                Objects.equals(getCards(), that.getCards()) &&
                Objects.equals(getFormat(), that.getFormat()) &&
                Objects.equals(getCardArt(), that.getCardArt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDeckId(), getAccountId(), getName(), getDescription(), getCards(), getFormat(), getCardArt());
    }
}
