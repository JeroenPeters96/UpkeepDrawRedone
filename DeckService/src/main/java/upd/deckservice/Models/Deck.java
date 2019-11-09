package upd.deckservice.Models;

import upd.deckservice.Events.DeckCreated;
import upd.deckservice.Events.DeckCreatedWithCards;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Entity
@Table(name = "Deck")
public class Deck implements Serializable {

    @Id
    @Column(name = "ID", unique = true, nullable = false, updatable = false)
    private String id;

    @Column(name = "accountId",nullable = false,updatable = false)
    private String accountId;

    @Column(name = "deckname",nullable = false)
    private String deckname;

    @Column(name = "description")
    private String description;

    @ManyToMany
    @JoinTable(
            name = "cards_in_deck",
            joinColumns = @JoinColumn(name = "deckId"),
            inverseJoinColumns = @JoinColumn(name = "cardId")
    )
    private Map<Card,Integer> cards = new HashMap<>();

    public Deck(String id, String accountId, String deckname, String description, Map<Card, Integer> cards) {
        this.id = id;
        this.accountId = accountId;
        this.deckname = deckname;
        this.description = description;
        this.cards = cards;
    }

    public Deck(String id, String accountId, String deckname, String description) {
        this.id = id;
        this.accountId = accountId;
        this.deckname = deckname;
        this.description = description;
    }

    public Deck(DeckCreated event) {
     this.id = event.getDeckId();
     this.accountId = event.getAccountId();
     this.deckname = event.getName();
     this.description = event.getDescription();
     this.cards = new HashMap<>();
    }

    public Deck(DeckCreatedWithCards event) {
        this.id = event.getDeckId();
        this.accountId = event.getAccountId();
        this.deckname = event.getName();
        this.description = event.getDescription();
        this.cards = event.getCards();
    }

    public Deck() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getDeckname() {
        return deckname;
    }

    public void setDeckname(String deckname) {
        this.deckname = deckname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Map<Card, Integer> getCards() {
        return cards;
    }

    public void setCards(Map<Card, Integer> cards) {
        this.cards = cards;
    }

    @Override
    public String toString() {
        return "Deck{" +
                "id='" + id + '\'' +
                ", accountId='" + accountId + '\'' +
                ", deckname='" + deckname + '\'' +
                ", description='" + description + '\'' +
                ", cards=" + cards +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Deck)) return false;
        Deck deck = (Deck) o;
        return Objects.equals(id, deck.id) &&
                Objects.equals(accountId, deck.accountId) &&
                Objects.equals(deckname, deck.deckname) &&
                Objects.equals(description, deck.description) &&
                Objects.equals(cards, deck.cards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, accountId, deckname, description, cards);
    }
}
