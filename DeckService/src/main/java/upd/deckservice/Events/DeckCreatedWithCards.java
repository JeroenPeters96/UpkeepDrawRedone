package upd.deckservice.Events;

import org.axonframework.commandhandling.TargetAggregateIdentifier;
import upd.deckservice.Models.CardModel;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class DeckCreatedWithCards {
    @TargetAggregateIdentifier
    private final String id;
    private final String deckId;
    private final String accountId;
    private final String name;
    private final String description;
    private final String format;
    private final String cardArt;
    private final List<CardModel> cards;

    public DeckCreatedWithCards(String id, String deckId, String accountId, String name, String description,String format,String cardArt, List<CardModel> cards) {
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

    public List<CardModel> getCards() {
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
        return "DeckCreatedWithCards{" +
                "id='" + id + '\'' +
                ", deckId='" + deckId + '\'' +
                ", accountId='" + accountId + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", format='" + format + '\'' +
                ", cardArt='" + cardArt + '\'' +
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
                Objects.equals(getFormat(), that.getFormat()) &&
                Objects.equals(getCardArt(), that.getCardArt()) &&
                Objects.equals(getCards(), that.getCards());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDeckId(), getAccountId(), getName(), getDescription(), getFormat(), getCardArt(), getCards());
    }
}
