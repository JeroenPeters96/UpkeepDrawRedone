package upd.deckservice.Controllers.IncomingModels;


import upd.deckservice.Models.CardModel;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class CreateDeckWithCardsApiModel {
    private final String accountId;
    private final String name;
    private final String description;
    private final List<CardModelApiModel> cards;
    private final String format;

    public CreateDeckWithCardsApiModel(String accountId, String name, String description, List<CardModelApiModel> cards, String format) {
        this.accountId = accountId;
        this.name = name;
        this.description = description;
        this.cards = cards;
        this.format = format;
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

    public List<CardModelApiModel> getCards() {
        return cards;
    }

    public String getFormat() {
        return format;
    }

    @Override
    public String toString() {
        return "CreateDeckWithCardsApiModel{" +
                "accountId='" + accountId + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", cards=" + cards +
                ", format='" + format + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateDeckWithCardsApiModel that = (CreateDeckWithCardsApiModel) o;
        return Objects.equals(getAccountId(), that.getAccountId()) &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getDescription(), that.getDescription()) &&
                Objects.equals(getCards(), that.getCards()) &&
                Objects.equals(getFormat(), that.getFormat());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAccountId(), getName(), getDescription(), getCards(), getFormat());
    }
}
